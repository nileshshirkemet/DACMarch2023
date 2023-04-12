	.include "console.i"

	.start	print
print:
	PutMsg	greet
	ret

greet:	.string	"Hello World!\n"

	.end


