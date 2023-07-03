$("button").click(function(){
   // alert()
 var email = $("#x1").val()
 var password = $("#x2").val()
 console.log(email);
 console.log(password);

 var passregularexp = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@\-#]).{4,8}$/

 var emailregularexp = /^([a-zA-Z0-9]([a-zA-Z0-9_\.]+)?[a-zA-Z0-9])@([a-zA-Z0-9\-]+)\.([a-zA-Z]{2,})(\.[a-zA-Z]{2,})?$/

 if(!emailregularexp.test(email)){
    $("#message").html("email id invalid")
 }
 else if(!passregularexp.test(password)){
    $("#message").html("password invalid")

 }
 else{
    $("#message").html("OK")
 }
})