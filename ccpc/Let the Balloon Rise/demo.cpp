/*
Problem Description
Contest time again! How excited it is to see balloons floating around. 
But to tell you a secret, the judges' favorite time is guessing the most popular problem. 
When the contest is over, they will count the balloons of each color and find the result.

This year, they decide to leave this lovely job to you. 
 

Input
Input contains multiple test cases. Each test case starts with a number N 
(0 < N <= 1000) -- the total number of balloons distributed. 
The next N lines contain one color each. The color of a balloon is a string of up to 15 
lower-case letters.

A test case with N = 0 terminates the input and this test case is not to be processed.
 

Output
For each case, print the color of balloon for the most popular problem on a single line. 
It is guaranteed that there is a unique solution for each test case.
 

Sample Input
5
green
red
blue
red
red
3
pink
orange
pink
0
 

Sample Output
red
pink
*/

#include<iostream>
#include<string>
#include<cstdlib>
using namespace std;

int main()
{
	int n;
	
	while (cin >> n)
	{
		if(n == 0)break;

		string* a = new string[n];
		int* b = new int[n];

		for (int i = 0; i < n; i++)		// 输入操作
		{
			cin >> a[i];
			b[i] = 0;
		}

		for (int i = 0; i < n; i++)		// 统计出现次数
		{
			for (int j = i; j < n; j++)
			{
				if (a[i] == a[j])
				{
					b[i]++;
				}
			}
		}

		int max = -1;
		int maxi;
		for (int i = 0; i < n; i++)		// 获得最大值得下标
		{
			if (b[i] > max)
			{
				max = b[i];
				maxi = i;	// 保存最大值的下标
			}
		}

		cout << a[maxi] << endl;
	}

	return 0;
}
