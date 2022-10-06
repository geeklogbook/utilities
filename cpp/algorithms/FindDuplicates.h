#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

bool hasDuplicates(vector <int> &vec, int k)
{
    unordered_map<int, int> map;


    for(int i = 0; i < vec.size(); i++)
    {
        if(map.find(vec[i]) != map.end()){
            if(i - map[vec[i]] <= k){
                return true;
            }
        }
        map[vec[i]] = i;
    }
    return false;
}

void findDuplicates()
{
    vector<int> vec = {5, 6, 8, 2, 4, 6, 9};
    int k = 4;

    if(hasDuplicates(vec,k)){
        cout << "Duplicates found";
    }
    else
    {
        cout << "No duplicates found";
    }
}
