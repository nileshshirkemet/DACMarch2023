	.include "console.i"

	.start main
main:
	GetInt	askl
	mov	rsi, rax	#rsi=M
	GetInt	asku
	mov	rdi, rax	#rdi=N
	cmp	rsi, rdi
	jg	done	#control will be transferred to done if
			#rsi is greater than rdi
	mov	rax, rsi
	sub	rax, 1
	mov	rcx, rax
	add	rcx, 1	
	mul	rcx	
	mov	rcx, 2	
	div	rcx
	mov	rsi, rax	#rsi=sum from 1 to M-1

	mov	rax, rdi
	mov	rcx, rax
	add	rcx, 1	
	mul	rcx	
	mov	rcx, 2	
	div	rcx		#rax=sum from 1 to N
	sub	rax, rsi

	PutInt	tell
done:	ret

askl:	.string	"Lower Limit: "
asku:	.string	"Upper Limit: "
tell:	.string	"Sum of Integers = "

	.end



