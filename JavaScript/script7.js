/* function hello(name = "harshita") {
    return "hello " + name;
}
document.writeln(hello("janhvi"), "<br>")
document.writeln(hello()) */

/* function add(a= 10, b = 20) {
    return a+b;
}
document.writeln(add(100,200))
document.writeln(add(100))
document.writeln(add()) */

/* function add(a, b=10) {
    return a+b;
}
document.writeln(add(100,200))
document.writeln(add(100))
document.writeln(add()) */

/* function sum(...n) {
    document.writeln(n)
}
sum(1,2,3,4) */

/* function display(x,...n) {
    document.writeln(x)
    document.writeln(n)
}
display("deepika", 98,76,54, "<br>")
display("pari", 98,76,78,99,54) */

function hello(x, y = "harshita", ...n) {
    document.writeln(x)
    document.writeln(y)
    document.writeln(n)
}

hello("hello", "rashmika", 76, 54, 87, 66, "<br>")
hello("hello", "abc", 87)