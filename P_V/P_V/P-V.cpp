//pv�������������������߾�������
//author:leaf
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <semaphore.h>

#define M 32             /*������Ŀ*/

#define P(x)     sem_wait(&x)
#define V(x)    sem_post(&x)

int in = 0;         /*�����߷��ò�Ʒ��λ��*/
int out = 0;             /*������ȡ��Ʒ��λ��*/

int buff[M] = { 0 };     /*�����ʼ��Ϊ0�� ��ʼʱû�в�Ʒ*/

sem_t empty_sem;         /*ͬ���ź�����������ʱ��ֹ�����߷Ų�Ʒ*/
sem_t full_sem;         /*ͬ���ź�������û��Ʒʱ��ֹ����������*/
pthread_mutex_t mutex; /*�����ź����� һ��ֻ��һ���̷߳��ʻ���*/

					   /*
					   *output the buffer
					   */
void print()
{
	int i;
	for (i = 0; i < M; i++)
		printf("%d ", buff[i]);
	printf("\n");
}

/*
*producer
*/
void *producer()
{
	for (;;)
	{
		sleep(1);

		P(empty_sem);
		pthread_mutex_lock(&mutex);

		in = in % M;
		printf("(+)produce a product. buffer:");

		buff[in] = 1;
		print();
		++in;

		pthread_mutex_unlock(&mutex);
		V(full_sem);
	}
}

/*
*consumer
*/
void *consumer()
{
	for (;;)
	{
		sleep(2);

		P(full_sem);
		pthread_mutex_lock(&mutex);

		out = out % M;
		printf("(-)consume a product. buffer:");

		buff[out] = 0;
		print();
		++out;

		pthread_mutex_unlock(&mutex);
		V(empty_sem);
	}
}

void sem_mutex_init()
{
	/*
	*semaphore initialize
	*/
	int init1 = sem_init(&empty_sem, 0, M);
	int init2 = sem_init(&full_sem, 0, 0);
	if ((init1 != 0) && (init2 != 0))
	{
		printf("sem init failed \n");
		exit(1);
	}
	/*
	*mutex initialize
	*/
	int init3 = pthread_mutex_init(&mutex, NULL);
	if (init3 != 0)
	{
		printf("mutex init failed \n");
		exit(1);
	}

}
int main()
{
	pthread_t id1;
	pthread_t id2;
	int i;
	int ret;

	sem_mutex_init();

	/*create the producer thread*/
	ret = pthread_create(&id1, NULL, producer, NULL);
	if (ret != 0)
	{
		printf("producer creation failed \n");
		exit(1);
	}

	/*create the consumer thread*/
	ret = pthread_create(&id2, NULL, consumer, NULL);
	if (ret != 0)
	{
		printf("consumer creation failed \n");
		exit(1);
	}

	pthread_join(id1, NULL);
	pthread_join(id2, NULL);

	exit(0);
}
