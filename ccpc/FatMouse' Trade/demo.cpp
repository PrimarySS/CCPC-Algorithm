/*
Time Limit: 2000/1000 MS (Java/Others)    Memory Limit: 65536/32768 K (Java/Others)
Total Submission(s): 90259    Accepted Submission(s): 31266


Problem Description
FatMouse prepared M pounds of cat food, ready to trade with the cats guarding the warehouse 
containing his favorite food, JavaBean.
The warehouse has N rooms. The i-th room contains J[i] pounds of JavaBeans and requires F[i] 
pounds of cat food. FatMouse does not have to trade for all the JavaBeans in the room, 
instead, he may get J[i]* a% pounds of JavaBeans if he pays F[i]* a% pounds of cat food. 
Here a is a real number. Now he is assigning this homework to you: tell him the maximum 
amount of JavaBeans he can obtain.


Input
The input consists of multiple test cases. Each test case begins with a line containing two 
non-negative integers M and N. Then N lines follow, each contains two non-negative integers 
J[i] and F[i] respectively. The last test case is followed by two -1's. All integers are not 
greater than 1000.


Output
For each test case, print in a single line a real number accurate up to 3 decimal places, 
which is the maximum amount of JavaBeans that FatMouse can obtain.


Sample Input
5 3
7 2
4 3
5 2

20 3
25 18
24 15
15 10
-1 -1


Sample Output
13.333
31.500

*/

#include<iostream>
#include<cstdlib>
using namespace std;

int main()
{
	int  M,N;

	while (cin >> M >> N && M + N != -2)
	{
		double* a = new double[N];
		double* b = new double[N];
		double* y = new double[N];

		// 获得样例
		for (int i = 0; i < N; i++)
		{
			cin >> a[i];
			cin >> b[i];
			y[i] = a[i] / b[i];
		}

		// 快速排序a[i],b[i],y[i]
		double t;
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N - i -1; j++)
			{
				if (y[j + 1] > y[j] )
				{
					t = y[j];y[j] = y[j + 1];y[j + 1] = t;
					t = a[j];a[j] = a[j + 1];a[j + 1] = t;
					t = b[j];b[j] = b[j + 1];b[j + 1] = t;
				}
			}
		}

		// 获得最大值
		double sum = 0;
		for (int i = 0; i < N; i++)
		{
			if (b[i] >= M)
			{
				sum += a[i] / b[i] * M;
				break;
			}
			else
			{
				sum += a[i];
				M -= b[i];
			}
		}

		printf("%.3f\n",sum);
	}

	return 0;
}
