#include "worker.h"
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

int collection = 0;
pthread_mutex_t monitor = PTHREAD_MUTEX_INITIALIZER;

void* ProcessDonation(void* donor)
{
	int notes = rand() % 5 + 1;

	printf("Received %d from %s\n", 100 * notes, (char*)donor);
	pthread_mutex_lock(&monitor);
	collection = DoWork(collection, notes);
	pthread_mutex_unlock(&monitor);
}

int main(void)
{
	char* names[] = {"Jack", "Jill", "John", "Jane"};
	int i;
	pthread_t child[4];

	srand(getpid());
	for(i = 0; i < 4; ++i)
	{
		//ProcessDonation(names[i]);
		pthread_create(&child[i], NULL, ProcessDonation, names[i]);
	}
	for(i = 0; i < 4; ++i)
	{
		pthread_join(child[i], NULL);
	}
	printf("Total Amount Collected = %d\n", 100 * collection);
}

