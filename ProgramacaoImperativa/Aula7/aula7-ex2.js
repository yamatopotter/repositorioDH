// 1 - true
let x=10;
let y="a";
console.log((y==="b")||(x>=10));

//2 - false
let a=3;
let b=8;
console.log(!( (a=="3") || (a===b) ) && !( (b !== 8) && (a <= b) ) );

//3 - false
let str = "";
let msg = "haha!";
let eBonito = "false";
console.log(!(str || msg) && eBonito);