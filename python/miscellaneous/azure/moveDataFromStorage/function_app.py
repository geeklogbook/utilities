#Idea from the code: https://github.com/DataEngineeringWithNick/AzureFunctionsPythonV2/blob/main/MyFunctionProject/function_app.py

import azure.functions as func
from azure.storage.blob import ContainerClient
import json
import logging
import pandas as pd

app = func.FunctionApp()


#COMMON FUNCTIONS

#Return String
@app.function_name('stringInTheBrowser')
@app.route(route="stringInTheBrowser", auth_level=func.AuthLevel.ANONYMOUS)
def stringInTheBrowser(req: func.HttpRequest) -> func.HttpResponse:
    logging.info('Python HTTP trigger function processed a request.')
    return func.HttpResponse(
        "Wow this first HTTP Function works!!!!",   
        status_code=200
    )

#Return String and the paramenter
@app.function_name('stringWithParams')
@app.route(route="stringWithParams")
def stringWithParams(req: func.HttpRequest) -> func.HttpResponse:
    logging.info('Starting the second HTTP Function request.')
    name = req.params.get('name')
    if name:
        message = f"Hello, {name}, so glad this Function worked!!"
    else:
        message = "Hello, so glad this Function worked!!"
    return func.HttpResponse(
        message,
        status_code=200
    )


#DATA PROCESSING FUNCTION
source_string = ""
target_string = ""

@app.function_name('showElementsFromStorage')
@app.route(route="showElementsFromStorage")
def showElementsFromStorage(req: func.HttpRequest) -> func.HttpResponse:
    source_container_url = source_string
    source_container_client = ContainerClient.from_container_url(source_container_url)
    blob_list = source_container_client.list_blobs()
    blobs = []
    for blob in blob_list:
        if blob.name.endswith(".json"):
            blobs.append(blob.name)

    files_str = "\n".join(blobs)
    return func.HttpResponse(files_str, status_code=200)

@app.function_name('readParseCopy')
@app.route(route="processAndCopyFiles")
def readParseCopy(req: func.HttpRequest) -> func.HttpResponse:
    source_container_url = source_string
    target_container_url = target_string
    source_container_client = ContainerClient.from_container_url(source_container_url)
    target_container_client = ContainerClient.from_container_url(target_container_url)

    
    dataframes = []
    blob_list = source_container_client.list_blobs()
    for blob in blob_list:
        if blob.name.endswith(".json"):
            blob_client = source_container_client.get_blob_client(blob)
            blob_data = blob_client.download_blob().readall()
            d = json.loads(blob_data)
            df = pd.DataFrame(d)
            df['blob_creation_time'] = blob.creation_time
            dataframes.append(df)

    # FINAL DF AND CSV
    final_df = pd.concat(dataframes, ignore_index=True)
    csv_data = final_df.to_csv(index=False)

    #UPLOAD FILE
    target_blob_client = target_container_client.get_blob_client("data_azure_function.csv")
    target_blob_client.upload_blob(csv_data, overwrite=True)

    return func.HttpResponse("Loaded", status_code=200)

"""
Conclusion about the usage of Azure Function for Processing Data.
https://learn.microsoft.com/en-us/azure/azure-functions/functions-scenarios?pivots=programming-language-python
https://learn.microsoft.com/en-us/azure/azure-functions/functions-bindings-event-hubs-trigger?pivots=programming-language-python&tabs=python-v2%2Cisolated-process%2Cnodejs-v4%2Cfunctionsv2%2Cextensionv5
https://learn.microsoft.com/en-us/azure/azure-functions/functions-bindings-kafka-trigger?pivots=programming-language-python&tabs=isolated-process%2Cconfluent

"""