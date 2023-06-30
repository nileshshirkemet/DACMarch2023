// console.log('File Testing');
console.log(document);
console.log(document.getElementById("x1"));

document.getElementById("x1").onclick = function(){
    // console.log('click working');
    // console.log(document.getElementById('m1'));
    var amount = document.getElementById('m1').value;
    console.log(amount);

    var roi = document.getElementById('m2').value;
    console.log(roi);

    var years = document.getElementById('m3').value;
    console.log(years);

    var SI = amount * roi * years / 100;
    console.log(SI);

    console.log(document.getElementById('y1'));

    document.getElementById('y1').innerText = `
        RESULT : <b>${SI}</b>
    `;

    document.getElementById('y1').innerHTML = `
        RESULT : <b>${SI}</b>
    `;
}