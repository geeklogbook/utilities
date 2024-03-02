from azure.storage.blob import ContainerClient
import pandas as pd
import json
import os
from dotenv import load_dotenv
load_dotenv()

source_container_url = os.environ['SOURCE_BLOB_STORAGE']
source_container_client = ContainerClient.from_container_url(source_container_url)

blob_list = source_container_client.list_blobs()
for blob in blob_list:
    if blob.name.endswith(".json"):
        print(blob.name)
