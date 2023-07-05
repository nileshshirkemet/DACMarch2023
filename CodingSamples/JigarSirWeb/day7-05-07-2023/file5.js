//how to create server using node.js
const xyz = require("http")
// console.log(xyz , typeof xyz);
const server = xyz.createServer((a , b)=>{
     console.log(typeof a , typeof b);
}) 
console.log(server);
server.listen(8000)