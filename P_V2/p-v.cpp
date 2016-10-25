#include <STDIO.H>     
     
 #define N 10     
     
 typedef int semaphore;  /* �ź�����һ����������ͱ��� */    
      
  semaphore mutex=1;     /* ������� */    
  semaphore empty=N;     /* ��¼�������пյĲ��� */    
  semaphore full=0;      /* ��¼�����������Ĳ���*/    
     
  semaphore buf[N];      /* ��N�������Ļ�����buf[N]����ʵ��ѭ��������� */    
  semaphore front=0, rear=0;    
      
   void p(semaphore *x)  /* p���� */    
  {    
     *x=(*x)-1;    
  }    
     
  void v(semaphore *y)   /* v���� */    
  {    
     *y=(*y)+1;    
  }    
     
   void produce_item(int *item_ptr)    
  {    
     /*printf("produce an item\n");*/    
     *item_ptr='m';      /* 'm' is "man��" */    
  }    
     
  void enter_item(int x)    
  {    
     front=(front+1)%N;    
     buf[front]=x;           
     printf("enter_item %c to buf[%d]\n", buf[front], front);    
  }    
     
 void remove_item(int *yy)    
 {    
     rear=(rear+1)%N;    
     printf("remove_item %c from buf[%d]", buf[rear], rear);    
     *yy=buf[rear];    
     buf[rear]='k';      /* 'k' is "kong��" */    
     printf("  so the buf[%d] changed to empty--%c\n", rear, buf[rear]);    
 }    
 void consume_item(int y)    
 {    
     printf("cosume the item :the screem print %c\n", y);    
 }    
     
 void producer(void);    
 void consumer(void);    
     
 /* ������ */    
 void producer(void)    
 {    
     int item;    
     
     while(1){    
         produce_item(&item);    
         p(&empty);          /* �ݼ��ղ��� */    
         p(&mutex);          /* �����ٽ��� */    
         enter_item(item);   /* ��һ���µ���������뻺���� */    
         v(&mutex);          /* �뿪�ٽ��� */    
         v(&full);           /* ���������� */    
         if(full==N)         /* �����������Ļ������������߽��� */    
             consumer();    
     }     
 }    
     
 /* ������ */    
 void consumer(void)    
 {    
     int get_item;    
     
     while(1){    
             p(&full);           /* �ݼ������� */    
             p(&mutex);          /* �����ٽ��� */    
             remove_item(&get_item); /* �ӻ�������ȡ��һ�������� */    
             v(&mutex);          /* �뿪�ٽ��� */    
             v(&empty);          /* �����ղ��� */    
             consume_item(get_item); /* ����������в��������ѣ�*/    
             if(empty==N)        /* ��������ȫ�յĻ����������߽��� */    
                 producer();             
     }    
  }    
     
  /* ���������ߣ������߽���ʵ�ֽ��̼�ͬ�� */    
  main()    
 {    
     producer();    
     
     return 0;    
 }
