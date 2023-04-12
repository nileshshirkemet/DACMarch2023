	.include "console.i"

	.start main
main:
	GetInt	asku			#direct addressing

	mov	rsi, rax	
	sub	rsi, 1		
	mov	rdi, offset days	#immediate addressing	
	mov	rax, [rdi+8*rsi]	#indirection
	mov	rcx, rax	
	add	rcx, 1		
	mul	rcx		
	mov	rcx, 2	
	div	rcx		

	PutInt	tell
	ret

asku:	.string	"Month[1-12]: "
tell:	.string	"Total Amount = "
days:	.quad	31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31	

	.end



