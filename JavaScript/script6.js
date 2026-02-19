/* function add() {
    a=10;
    b=20;
    c=a+b;
    document.writeln("Sum is: ", c);
}

add(); */

/* function add(a,b) {
    document.writeln("Sum is: ", a+b);
}

add(100,200); */

/* function add(a,b) {
    c=a+b;
    return c;
}

document.writeln(add(100,200)); */

/* var a = Number(prompt("Enter value of a: "))
var b = Number(prompt("Enter value of b: "))

function add(a,b) {
    c=a+b
    return c
}
var x = add(a,b)
document.writeln(x) */

/* function add(a) {
    for(var i = 0; i<a.length; i++) {
        a[i]=a[i]*a[i];
    }
    return a;
}
var x = [10,20,30,40,50]
// var w = add(x)
add(x)
// document.writeln(w)
document.writeln(x) */

/* function add(a) {
    a = a*a
}
var x = 10;
add(x) 
document.writeln(x) */

/* var sum = function (a, b) {
    c = a + b;
    return c;
}

document.writeln(sum(100,200)) */

/* var hello = function () {
    return "areee sun rahe ho na..."
}

function bye(x) {
    document.writeln(x)
}

bye(hello) */

/* var sum = (a, b) => a + b;
document.writeln(sum(10,20)) */

/* var msg = (a,b) => {
    document.writeln("welcome")
    return a+b
}
document.writeln(msg(100,200)) */

/* var name1 = (a) => a.toUpperCase();
document.writeln(name1("harshita")) */

var isPerfectNumber = (num) => {
    var sum = 0;

    for (var i = 1; i <= num / 2; i++) {
        if (num % i === 0) {
            sum += i;
        }
    }
    return sum === num;
}
var arr = [1,2,3,4,5,6]
document.writeln(arr.map(num => isPerfectNumber(num)).join(", "))