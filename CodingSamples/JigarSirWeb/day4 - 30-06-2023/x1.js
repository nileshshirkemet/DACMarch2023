// console.log('file tested');
// console.log(document);

//DOM Method
console.log(document.getElementById("btn"));
//Dom Event Handler
// document.getElementById('btn').onclick =function(){
//     console.log('tested');
// }

document.getElementById('btn').onclick = ()=>{
    // console.log('tested');
    // console.log(document.getElementById('m1'));

    //DOM Property
    var rec = document.getElementById('m1').value;
    console.log(rec);
    
    var ans = rec * 9/5 + 32;
    console.log(ans);

    console.log(document.getElementById('p1'));

    //DOM Property: innerHTML --- Content Manipulation
    document.getElementById('p1').innerHTML = ans;
    // style 
    document.getElementById('p1').style.background = 'tomato'
}