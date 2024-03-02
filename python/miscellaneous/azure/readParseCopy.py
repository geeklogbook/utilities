from azure.storage.blob import ContainerClient
import pandas as pd
import json
import os
from dotenv import load_dotenv
load_dotenv()


# SOURCE AND TARGET
source_container_url = os.environ['SOURCE_BLOB_STORAGE']
target_container_url = os.environ['TARGET_BLOB_STORAGE']
source_container_client = ContainerClient.from_container_url(source_container_url)
target_container_client = ContainerClient.from_container_url(target_container_url)

# CREATE DATAFRAME WITH THE DATA
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
target_blob_client = target_container_client.get_blob_client("data.csv")
target_blob_client.upload_blob(csv_data, overwrite=True)