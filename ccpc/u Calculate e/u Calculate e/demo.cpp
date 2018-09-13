/*
Time Limit: 2000/1000 MS (Java/Others)    Memory Limit: 65536/32768 K (Java/Others)
Total Submission(s): 51136    Accepted Submission(s): 23484

Problem Description
A simple mathematical formula for e is

where n is allowed to go to infinity. This can actually yield very accurate approximations of e using relatively small values of n.

Output
Output the approximations of e generated by the above formula for the values of n from 0 to 9. The beginning of your output should appear similar to that shown below.

Sample Output
n e
- -----------
0 1
1 2
2 2.5
3 2.666666667
4 2.708333333
*/

#include <iostream>
#include <cmath>
#include <cstdio>
#include <iomanip>
using namespace std;

int factorial(int t)
{
    int result = 1;
    for(int i = 1; i <= t; i++)
    {
        result *= i;
    }
    return result;
}

int main()
{
    double e;
    cout << "n e\n" << "- -----------" << endl;
    cout << "0 1" << endl;
    cout << "1 2" << endl;
    cout << "2 2.5" << endl;
    e = 2.5;

    for(int i = 3; i <= 9; ++i)
    {
        e += 1.0 / factorial(i);

		printf("%d %.9f\n",i,e);
    }

    return 0;
}