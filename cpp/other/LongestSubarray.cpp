#include <iostream>
#include <algorithm>

using namespace std;

void printSubArray(int arr[], int i, int j)
{
    cout << "{ ";
    for (int k = i; k < j; k++)
    {
        cout << arr[k] << ", ";
    }
    cout << arr[j] << "}";
}

void findLongestSubArray(int arr[], int n)
{

    int max_len = 1;
    int ending_index = 0;
    int curr_len = 1;

    for (int i = 1; i < n; i++)
    {
        if (arr[i] * arr[i - 1] < 0)
        {
            curr_len++;

            if (curr_len > max_len)
            {
                max_len = curr_len;
                ending_index = i;
            }
        }
        else
        {
            curr_len = 1;
        }
    }
    cout << "The longest alternating subarray is: ";
    printSubArray(arr, (ending_index - max_len + 1), ending_index);
};

int main()
{
    int arr[] = {1, -2, 6, 4, -3, 2, -4, -3};
    int n = sizeof(arr) / sizeof(arr[0]);

    findLongestSubArray(arr, n);

    return 0;
};