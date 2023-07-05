//how to read file in node in both sync AND ASYNC mode
const fs = require("fs")
// console.log(fs);
console.log(1);
console.log(2);
var answer = fs.readFileSync("./dummy.txt", "utf-8")
console.log(answer);
console.log(3);