	.include "console.i"

	.start main
main:
	GetInt	ask1
	mov	rdi, rax
	GetInt	ask2
	mov	rsi, rax
	call	GCD
	PutInt	tell
	ret

ask1:	.string "First Positive Integer : "
ask2:	.string	"Second Positive Integer: "
tell:	.string "G.C.D = "

	.end
