#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>

void End(void)
{
	puts("Goodbye!");
}

void Run(int seed)
{
	int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	int m;

	if(seed < 0)
		exit(23); //raise(SIGUSR1);

	printf("Month [1-12]: ");
	scanf("%d", &m);
	printf("Amount: %d\n", seed / days[m]);
}

void MainHandler(int signo)
{
	switch(signo)
	{
		case SIGFPE:
			puts("Invalid arithmetic operation");
			break;
		case SIGSEGV:
			puts("Invalid memory access");
			break;
		default:
			puts("");
	}

	exit(signo);
}

int main(void)
{
	struct sigaction act = {MainHandler};

	sigaction(SIGFPE, &act, NULL);
	sigaction(SIGSEGV, &act, NULL);
	sigaction(SIGINT, &act, NULL);
	puts("Welcome User.");
	atexit(End);
	Run(13020);
	return 17;
}

