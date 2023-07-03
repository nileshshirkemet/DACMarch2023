$(".x1").mouseover(function(){
    var answer = $(this).attr("src")
     console.log(answer);
     var answer1 = answer.replace("128/128","832/832")
     console.log(answer1);
     $("#x2").attr("src", answer1)
})