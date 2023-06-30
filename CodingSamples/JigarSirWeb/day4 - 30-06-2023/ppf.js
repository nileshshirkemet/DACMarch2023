// console.log('file testing');

console.log( isNaN('gdgdfgdfg') );

//Refer a Named Function
document.getElementById('m1').onclick = myfunc;

function myfunc(){
    // console.log('CLICK');
    var amount = document.getElementById('x1').value;
    var roi = document.getElementById('x2').value;
    var years = document.getElementById('x3').value;

    console.log(amount,roi,years);

    if(amount=="" || roi==""){
        document.getElementById('p1').innerHTML = 'Values Required';
    }
    else if(amount<0 || roi<0){
        document.getElementById('p1').innerHTML = 'Values Must Be +ve';
    }
    else if( isNaN(amount) || isNaN(roi) ){
        document.getElementById('p1').innerHTML = 'Values Must Be Number'; 
    }
    else{
        var i=1;
        var openingBalance = 0;

        var amount = parseInt(amount);
        var roi = parseFloat(roi);

        while(i<=years){
            var interest = (openingBalance + amount) * roi/100;
            interest = Math.round(interest);

            var closingBalance = openingBalance + amount+interest;

            console.log(i , openingBalance , amount,interest,closingBalance);

            // DOM Structure Manipulation ( Creation or Deletion)
            var trTag = document.createElement('tr');
            console.log(trTag , typeof trTag);

            var td1 = document.createElement('td');
            console.log(td1 , typeof td1);

            td1.innerHTML = i;

            var td2= document.createElement('td');
            td2.innerHTML = openingBalance;

            var td3= document.createElement('td');
            td3.innerHTML = amount;

            var td4= document.createElement('td');
            td4.innerHTML = interest;

            var td5= document.createElement('td');
            td5.innerHTML = closingBalance;

            trTag.append(td1);
            trTag.append(td2);
            trTag.append(td3);
            trTag.append(td4);
            trTag.append(td5);

            document.getElementById('result').append(trTag);
            i++;
            openingBalance=closingBalance;
        }
    }
    
}
