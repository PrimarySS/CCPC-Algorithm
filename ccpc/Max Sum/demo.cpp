/*
Time Limit: 2000/1000 MS (Java/Others)    Memory Limit: 65536/32768 K (Java/Others)
Total Submission(s): 280205    Accepted Submission(s): 66521


Problem Description
Given a sequence a[1],a[2],a[3]......a[n], your job is to calculate the max sum of a sub-sequence. 
For example, given (6,-1,5,4,-7), the max sum in this sequence is 6 + (-1) + 5 + 4 = 14.


Input
The first line of the input contains an integer T(1<=T<=20) which means the number of test cases. 
Then T lines follow, each line starts with a number N(1<=N<=100000), then N integers followed(all 
the integers are between -1000 and 1000).


Output
For each test case, you should output two lines. The first line is "Case #:", # means the number of 
the test case. The second line contains three integers, the Max Sum in the sequence, the start 
position of the sub-sequence, the end position of the sub-sequence. If there are more than one result, 
output the first one. Output a blank line between two cases.


Sample Input
2
5 6 -1 5 4 -7
7 0 6 -1 1 -6 7 -5


Sample Output
Case 1:
14 1 4

Case 2:
7 1 6
*/


#include<iostream>
#include<cstdlib>
using namespace std;

int main()
{
	int n,m,now,max,before,x,start,end;
	int a = 1;

	cin >> n;

	while (n--)
	{
		cin >> m;
		for (int i = 1; i <= m; i++)
		{
			cin >> now;

			if (i == 1)	// ��ʼ��
			{
				max = before = now;		// max����֮ǰ����������ͣ�before�洢Ŀǰ�ڶ�������ǰ�����ĺͣ�now������������  
				x = start = end = 1;	// x������ʱ�洢before�����ĺ͵���ʼλ�ã���before>maxʱ������sλ�ã�s��e�������͵�start��endλ�� 
			}
			else
			{
				if (now > now + before)		// ���֮ǰ�洢�ĺͼ������ڵ����ݱ����ڵ�����С���ͰѴ洢�ĺͻ������ڵ����ݣ���֮��˵�������ڵ���������ֱ�Ӽ���
				{
					before = now;
					x = i;		// Ԥ���λ��Ҫ���� 
				}
				else before += now;		
			}
			if (before > max)	// ��֮ǰ����������ͽ��бȽϣ�������ڣ�λ�ú����ݾ�Ҫ����
			{
				max = before;
				start = x;
				end = i;
			}
		}
		cout << "Case " << a++ << ":\n" << max << " " << start << " " << end << endl;
		if(n)cout << endl;
	}

	return 0;
}

#include<stdio.h>
int main()
{
    int i,ca=1,t,s,e,n,x,now,before,max;
    scanf_s("%d",&t);
    while(t--)
    {
       scanf_s("%d",&n);
       for(i=1;i<=n;i++)
       {
         scanf_s("%d",&now);
         if(i==1)//��ʼ�� 
         {
            max=before=now;//max����֮ǰ����������ͣ�before�洢Ŀǰ�ڶ�������ǰ�����ĺͣ�now������������  
            x=s=e=1;//x������ʱ�洢before�����ĺ͵���ʼλ�ã���before>maxʱ������sλ�ã�s��e�������͵�start��endλ�� 
         }
         else {
             if(now>now+before)//���֮ǰ�洢�ĺͼ������ڵ����ݱ����ڵ�����С���ͰѴ洢�ĺͻ������ڵ����ݣ���֮��˵�������ڵ���������ֱ�Ӽ��� 
             {
                before=now;
                x=i;//Ԥ���λ��Ҫ���� 
             }       
             else before+=now;
              }
         if(before>max)//��֮ǰ����������ͽ��бȽϣ�������ڣ�λ�ú����ݾ�Ҫ���� 
           max=before,s=x,e=i;
       }
       printf("Case %d:\n%d %d %d\n",ca++,max,s,e);
       if(t)printf("\n"); 
    }
    return 0;
}
