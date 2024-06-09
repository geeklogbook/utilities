import os
import os.path as path

two_up =  path.abspath(path.join(__file__ ,"../../../datasources", ))
working_directory = os.getcwd()


def absoluteFilePaths(directory):
    for dirpath,_,filenames in os.walk(directory):
        for f in filenames:
            yield os.path.abspath(os.path.join(dirpath, f))

path_file = absoluteFilePaths(two_up)

for file in path_file:
    print(file, os.path.getsize(file))