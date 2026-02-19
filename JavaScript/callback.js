/* function calculator(a,b, callback) {
    return callback(a,b);
}

function add(x,y) {
    return x+y;
}

function product(x,y) {
    return x*y;
}

document.writeln(calculator(5,3,add), "<br>")
document.writeln(calculator(5,3, product)) */

function done() {
    document.writeln("Done", "<br>");
}
setTimeout(done, 1000);
document.writeln("are bhaiya chal ja", "<br>");

setTimeout(function() {
    document.writeln("Js is going on", "<br>");
},1000)
document.writeln("java already done")