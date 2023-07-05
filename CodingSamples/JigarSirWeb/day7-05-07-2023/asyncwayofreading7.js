var fs = require("fs")
console.log(1);
console.log(2);
fs.readFile("./dummy.txt","utf-8" , (err,content)=>{
     console.log(content);
})
console.log(3);
