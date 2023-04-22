#include "worker.h"
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

void HandleJob(int jno)
{
	printf("Thread<%lx> has accepted job<%d>\n", pthread_self(), jno);
	DoWork(0, jno);
	printf("Thread<%lx> has finished job<%d>\n", pthread_self(), jno);
}

void* ChildFunc(void* arg)
{
	HandleJob(30);
}

int main(void)
{
	pthread_t child;

	pthread_create(&child, NULL, ChildFunc, NULL);
	HandleJob(20);
	pthread_join(child, NULL); //current (main) thread waits for child to exit 
}

