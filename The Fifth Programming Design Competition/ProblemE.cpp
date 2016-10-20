#include<iostream>
#include<iomanip>
using namespace std;

int main(){
	int N=0;
	int i;
	int max=0;
	int min=101;
	double sum=0;
	while(1)
	{
	 max=0;
	 min=101;
	 sum=0;
	    cin>>N;
		if(N==0)
			break;
	    if(N>=5&&N<=20)
		{
	        int *array;
			array=new int[N];
			for(i=0;i<N;i++)
			{
				while(1)
				{
				    cin>>array[i];
					if(array[i]>=0&&array[i]<=100)
						break;
				}
			}
			for(i=0;i<N;i++)
			{
				if(max<array[i])
					max=array[i];
				if(min>array[i])
					min=array[i];
				sum=sum+array[i];
			}
			sum=sum-max-min;
			sum=sum/(N-2);
			cout<<setiosflags(ios::fixed)<<setprecision(2)<<sum<<endl;
		}
		else 
			continue;
	}
	return 0;
}