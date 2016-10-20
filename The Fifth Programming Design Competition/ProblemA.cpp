#include<iostream.h>
class student{
public:
	int num;
	int c;
};
int main(){
	int M=0,N=0,k=0,i=0;
	while(cin>>M>>N){
		k=0;
	/*while(1){
	   cin>>M;
	   if(M>=1&&M<=100)
		   break;
	   }
	while(1){
		cin>>N;
		if(N>=1&&N<=M)
			break;
	}*/
	student *s;
	s=new student[M];
	for(i=0;i<M;i++){
		s[i].num=i+1;
		while(1){
		    cin>>s[i].c;
		if(s[i].c>=0&&s[i].c<=10)
			break;
		}
	}
	for(i=0;i<N;){
		for(int j=0;j<M;j++){
			if(s[j].c==k){
				i++;
				if(i==N+1)
					break;
				if(i<N)
				cout<<s[j].num<<" ";
				else
					cout<<s[j].num<<endl;
			}
		}
		k++;
	}
	}

	return 0;
}
