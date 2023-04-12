	.include "console.i"

	.start	main
main:
	GetInt	askn

	mov	rbx, rax
	mov	rax, 1
	mov	rcx, 0

1:	inc	rcx
	mov	rdx, 10
	mul	rdx

	cmp	rax, rbx
	jle	1b

	mov	rax, rcx
	PutInt	tell

	ret

askn:	.string	"Positive Integer: "
tell:	.string	"Number of Digits = "

	.end

