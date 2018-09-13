/*
Time Limit: 10000/5000 MS (Java/Others)    Memory Limit: 65536/32768 K (Java/Others)
Total Submission(s): 60942    Accepted Submission(s): 16126


Problem Description
Have you ever played quoit in a playground? Quoit is a game in which flat rings are pitched at some toys, with all the toys encircled awarded.
In the field of Cyberground, the position of each toy is fixed, and the ring is carefully designed so it can only encircle one toy at a time. On the other hand, to make the game look more attractive, the ring is designed to have the largest radius. Given a configuration of the field, you are supposed to find the radius of such a ring.

Assume that all the toys are points on a plane. A point is encircled by the ring if the distance between the point and the center of the ring is strictly less than the radius of the ring. If two toys are placed at the same point, the radius of the ring is considered to be 0.


Input
The input consists of several test cases. For each case, the first line contains an integer N (2 <= N <= 100,000), the total number of toys in the field. Then N lines follow, each contains a pair of (x, y) which are the coordinates of a toy. The input is terminated by N = 0.


Output
For each test case, print in one line the radius of the ring required by the Cyberground manager, accurate up to 2 decimal places. 


Sample Input
2
0 0
1 1
2
1 1
1 1
3
-1.5 0
0 0
0 1.5
0


Sample Output
0.71
0.00
0.75
*/


#include<stdio.h>
#include<math.h>
#include<algorithm>
using namespace std;

//按照每个点x值由小到大进行排序,若x相同,则按照y由小到大进行排序,计算相邻两点的最短距离,即为len1.
//按照每个点y值由小到大进行排序,若y相同,则按照x由小到大进行排序,计算相邻两点的最短距离,即为len2.
//答案即为：min（len1,len2).

struct Point
{
	double x;
	double y;
}coor[100001];

bool cmp1(const Point a,const Point b)
{
	if(a.x < b.x)
		return true;
	if(a.x > b.x)
		return false;
	else
		return a.y < b.y;
}

bool cmp2(const Point a,const Point b)
{
	if(a.y < b.y)
		return true;
	if(a.y > b.y)
		return false;
	else
		return a.x < b.x;
}

double num(int i,int j)
{
	return sqrt(pow((coor[i].x - coor[j].x),2) + pow( (coor[i].y - coor[j].y),2)); //计算两点之间的距离 	
}

int main()
{
	double radius = 0; //定义半径  
	int i,N;
	while(scanf_s("%d",&N) && N != 0) //N大于2小于100000 
	{
		for(i = 1; i <= N; i++)
			scanf_s("%lf %lf",&coor[i].x , &coor[i].y);
		sort(coor+1,coor+N+1,cmp1);	//先排x轴 
		radius=num(1,2);
		for(i=2;i<N;i++)
		{
			if( radius>num(i,i+1) )
				radius=num(i,i+1);	
		}
		sort(coor+1,coor+N+1,cmp2);	//再排y轴 
		for(i=1;i<N;i++)
		{
			if( radius>num(i,i+1) ) 
				radius=num(i,i+1);	
		}
		printf("%.2f\n",radius/2);
	}
	return 0;
}

//#include<iostream>
//#include<cstdlib>
//#include<cmath>
//using namespace std;
//
//int main()
//{
//	int n;
//
//	while(cin >> n && n != 0)
//	{
//		double* x = new double[n];
//		double* y = new double[n];
//
//		for (int i = 0; i < n; i++)
//		{
//			cin >> x[i] >> y[i];
//		}
//
//		double t;
//		for (int i = 0; i < n; i++)
//		{
//			for (int j = i; j < n; j++)
//			{
//				if (x[i] > x[j])
//				{
//					t = x[i];x[i] = x[j];x[j] = t;
//					t = y[i];y[i] = y[j];y[j] = t;
//				}
//			}
//		}
//
//		double d = sqrt((x[0] - x[1]) * (x[0] - x[1]) + (y[0] - y[1]) * (y[0] - y[1]));
//
//		double r = d / 2.0;
//
//		printf("%.2f\n",r);
//
//	}
//
//	return 0;
//}