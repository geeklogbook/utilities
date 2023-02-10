import pandas as pd
from soda.scan import Scan

# Create soda scan object
scan = Scan()
scan.set_scan_definition_name("test")
scan.set_data_source_name("dask")

# Create an artificial pandas dataframe
df_employee = pd.DataFrame({
  "first-name":["people1", "people2", "people3"]
  })

# Add pandas dataframe to scan and assign a dataset name to refer from checks yaml
scan.add_pandas_dataframe(dataset_name="employee", pandas_df=df_employee)

checks = """
checks for employee:
  - missing_count("first-name") = 0
 """ 

scan.add_sodacl_yaml_str(checks)
scan.execute()
