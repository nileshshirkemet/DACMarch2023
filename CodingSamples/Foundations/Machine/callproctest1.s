	.include "console.i"

	.start main
main:
	GetInt	askl
	mov	rsi, rax	
	GetInt	asku
	mov	rdi, rax
	cmp	rsi, rdi
	jg	done	
		
	mov	rax, rsi
	sub	rax, 1
	call	Compute		#push return address (of next instruction) 
				#and jump to instruction addressed by Compute
	mov	rsi, rax

	mov	rax, rdi
	call	Compute
	sub	rax, rsi

	PutInt	tell
done:	ret

Compute:
	mov	rcx, rax
	inc	rcx	
	mul	rcx		
	shr	rax
	ret		#pop the return address and jump to that address

askl:	.string	"Lower Limit: "
asku:	.string	"Upper Limit: "
tell:	.string	"Sum of Integers = "

	.end



