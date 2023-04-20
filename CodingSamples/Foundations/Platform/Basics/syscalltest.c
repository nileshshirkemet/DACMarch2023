#include <stdio.h>
#include <time.h>
#include <unistd.h>

//cross-platform function for delaying execution using C runtime
void __Delay(int seconds)
{
	clock_t future = clock() + seconds * CLOCKS_PER_SEC;

	while(clock() < future);
}

//Linux/x64 platform specific function for delaying execution using native syscall
void _Delay(int seconds)
{
	long interval[] = {seconds, 0};
	/*
	mov		rax, 35
	mov		rdi, interval
	syscall
	*/
	asm("syscall" :: "D"(interval), "a"(35));
}

//UNIX platform specific function for delaying execution using POSIX
void Delay(int seconds)
{
	usleep(1000000 * seconds);
}

int main(int argc, char* argv[])
{
	int n;

	for(n = 1; n < argc; ++n)
	{
		printf("Hello %s\n", argv[n]);
		Delay(n);
	}

	puts("Goodbye!");
}

