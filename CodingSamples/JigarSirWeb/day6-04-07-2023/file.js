document.getElementById("x1").onclick = function () {
    document.getElementById("x2").innerHTML = ''
    // console.log('Event Handling Working');
    //check XMLHttpRequest exist or NOT
    var xmlhttp = new XMLHttpRequest();
    console.log(xmlhttp);

    // xmlhttp.readyState cycle
    // xmlhttp.status method result http status code
    console.log(xmlhttp.readyState, xmlhttp.status); // 0 0

    //check upcoming status  will be checked by onreadystatechange event based on user action
    xmlhttp.onreadystatechange = function () {
        console.log(xmlhttp.readyState, xmlhttp.status);
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            console.log('Get Values From APIS');
            console.log(typeof xmlhttp.responseText);
            console.log(xmlhttp.responseText);

            //convert api data which is json format into javascript object

            /// DOM MANIPUATE STARTS
            var result = JSON.parse(xmlhttp.responseText); // converts data from JSON To Javascript Object Or Array

            console.log(typeof result);
            console.log(result);
            // lets prepare a div 
            result.forEach(function (Values) {
                // console.log(Math.random());
                var div = document.createElement("div")
                div.className = "col-xl-3"
                var h2 = document.createElement("h2")
                var p = document.createElement("p")
                var img = document.createElement("img")
                h2.innerHTML = Values.price
                p.innerHTML = Values.title
                img.src = Values.image

                div.append(img)
                div.append(h2)
                div.append(p)
                document.getElementById("x2").append(div)
                console.log(Values);
            })
            /// DOM MANIPUATE END  

        }
    }

    var categoryname = document.getElementById("x3").value

    //open() method will help us to connect from client to server or apis
    xmlhttp.open("get", `https://fakestoreapi.com/products/category/${categoryname}`); // from 0 to 1

    xmlhttp.send() // from 1 to 2

    /*
        readyState
        0 => no request initialized by user
        1 => request has been setup with server side lang or apis
        2 => send a request to the server, so server can do the operation
        3 => request it is in process on server side
        4 => request cycle is completed , data is avaiable to javascript and can be handled in responseText
    */
}