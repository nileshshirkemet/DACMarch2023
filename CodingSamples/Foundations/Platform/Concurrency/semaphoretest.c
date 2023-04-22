#include "worker.h"
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <semaphore.h>
#include <sys/wait.h>
#include <sys/mman.h>

sem_t* guard;

void HandleJob(int jno)
{
	sem_wait(guard);
	printf("Process<%d> has accepted job<%d>\n", getpid(), jno);
	DoWork(0, jno);
	printf("Process<%d> has finished job<%d>\n", getpid(), jno);
	sem_post(guard);
}

int main(void)
{
	int i;
	
	guard = mmap(NULL, sizeof(sem_t), PROT_READ | PROT_WRITE, MAP_SHARED | MAP_ANONYMOUS, -1, 0);
	sem_init(guard, 1, 3);

	for(i = 1; i <= 5; ++i)
	{
		if(fork() == 0)
		{
			HandleJob(10 * i);
			exit(i);
		}
	}

	while(wait(NULL) > 0);

	sem_destroy(guard);
	munmap(guard, sizeof(sem_t));
}

