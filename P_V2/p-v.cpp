#include <STDIO.H>     
     
 #define N 10     
     
 typedef int semaphore;  /* 信号量是一种特殊的整型变量 */    
      
  semaphore mutex=1;     /* 互斥访问 */    
  semaphore empty=N;     /* 记录缓冲区中空的槽数 */    
  semaphore full=0;      /* 记录缓冲区中满的槽数*/    
     
  semaphore buf[N];      /* 有N个槽数的缓冲区buf[N]，并实现循环缓冲队列 */    
  semaphore front=0, rear=0;    
      
   void p(semaphore *x)  /* p操作 */    
  {    
     *x=(*x)-1;    
  }    
     
  void v(semaphore *y)   /* v操作 */    
  {    
     *y=(*y)+1;    
  }    
     
   void produce_item(int *item_ptr)    
  {    
     /*printf("produce an item\n");*/    
     *item_ptr='m';      /* 'm' is "man满" */    
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
     buf[rear]='k';      /* 'k' is "kong空" */    
     printf("  so the buf[%d] changed to empty--%c\n", rear, buf[rear]);    
 }    
 void consume_item(int y)    
 {    
     printf("cosume the item :the screem print %c\n", y);    
 }    
     
 void producer(void);    
 void consumer(void);    
     
 /* 生产者 */    
 void producer(void)    
 {    
     int item;    
     
     while(1){    
         produce_item(&item);    
         p(&empty);          /* 递减空槽数 */    
         p(&mutex);          /* 进入临界区 */    
         enter_item(item);   /* 将一个新的数据项放入缓冲区 */    
         v(&mutex);          /* 离开临界区 */    
         v(&full);           /* 递增满槽数 */    
         if(full==N)         /* 若缓冲区满的话，唤醒消费者进程 */    
             consumer();    
     }     
 }    
     
 /* 消费者 */    
 void consumer(void)    
 {    
     int get_item;    
     
     while(1){    
             p(&full);           /* 递减满槽数 */    
             p(&mutex);          /* 进入临界区 */    
             remove_item(&get_item); /* 从缓冲区中取走一个数据项 */    
             v(&mutex);          /* 离开临界区 */    
             v(&empty);          /* 递增空槽数 */    
             consume_item(get_item); /* 对数据项进行操作（消费）*/    
             if(empty==N)        /* 若缓冲区全空的话，唤生产者进程 */    
                 producer();             
     }    
  }    
     
  /* 调用生产者－消费者进程实现进程间同步 */    
  main()    
 {    
     producer();    
     
     return 0;    
 }
