#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(void)
{
	pid_t child;

	printf("Welcome from process<%d/%d>\n", getpid(), getppid());
	//fork starts a new child process which is a copy of its parent
	//process returning pid of this child in the parent process but
	//zero in the newly started child process
	child = fork(); 
	//any code from her onwards will run in parent as well as child
	//printf("Result of fork = %d\n", child);
	if(child == 0)
	{
		//this code will only execute in child
		//execl executes specified command-line as a new process by replacing
		//the image of current process and using its process-id
		execl("./greet", "Greeter", "Mother", "Father", "Sister", NULL);
	}
	else
	{
		//this code will only execute in parent
		waitpid(child, NULL, 0); //wait for child to exit
		printf("Goodbye from process<%d/%d>\n", getpid(), getppid());
	}
}

