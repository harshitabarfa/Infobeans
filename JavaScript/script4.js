/* var a = ['abc', 'xyz', 'www'];
document.writeln(a[0], "<br>")
document.writeln(a[1], "<br>")
document.writeln(a[2], "<br>")
document.writeln(a[3], "<br>")
document.writeln(a[-1], "<br>")

a[0] = "Harshita";
document.writeln(a[0], "<br>")
document.writeln(a, "<br>") */

/* var b = []
var a = new Array()
a[0] = 10
a[1] = "Harshita"
a[2] = "Barfa"
document.writeln(a)
document.writeln(a.length)
document.writeln(b.length) */

// var x = [10, 20, 30, 40]
/* document.writeln(x, "<br>")
x.push(90)

document.writeln(x, "<br>")
document.writeln(x.push(98), "<br>")
document.writeln(x) */

/* x.pop()
document.writeln(x) */

/* x.unshift(50)
document.writeln(x, "<br>")
document.writeln(x.unshift(655), "<br>")
document.writeln(x) */

/* document.writeln(x.shift(), "<br>")
document.writeln(x) */

/* document.writeln(x.indexOf(20))
document.writeln(x.indexOf(60)) */

// document.writeln(x.slice(1,4))

/* var a = [[10,20,30], [40,50,60], [70,80,90]]
document.writeln(a[0][2]) */

/* books = [];
input = prompt("Which operation you want to perform? :- add|list|exit")

while (input != 'exit') {
    if (input == 'add') {
        newBook = prompt("Enter book name: ")
        books.push(newBook)
    } else if (input == 'list') {
        document.writeln("List of books are: ")
        document.writeln(books, "<br>")
    } else {
        document.writeln("Invalid option!", "<br>")
    }
    input = prompt("Which operation you want to perform? :- add|list|exit")
}
document.writeln("Completed!", "<br>") */

// var a = [10, 20, 30, 40, 50]

/* for (var i = 0; i < a.length; i++) {
    document.writeln(a[i])
} */

i = 0
/* while (i < a.length) {
    document.writeln(a[i])
    i++
} */

/* do {
    document.writeln(a[i])
    i++
} while (i < a.length) */

/* var a = ['harshita', 'rest', 'tantion']
for(i of a) {
    document.writeln(i)
} */

/* var x  = [10,20,30,40,50]
x.forEach(a=>document.writeln(a)) */

var subjects = ['pyhton', 'react', 'java', 'c']

/* function display(y) {
    document.writeln("****** <br>")
    document.writeln(y, "<br>")
    document.writeln("****** <br>")
} */

/* subjects.forEach(function (y) {
    document.writeln("****** <br>")
    document.writeln(y, "<br>")
    document.writeln("****** <br>")
}) */

// subjects.forEach(alert)

/* subjects.splice(1,2)
document.writeln(subjects) */

/* subjects.splice(2,0,'view js', 'DSA')
document.writeln(subjects) */

var x = [1,2,3,4,5]
// var y = x.map(n=>n*2)
// var y = x.map(n=>n%2!=0)

var y = x.filter(n=>n%2==1)
document.writeln(x, "<br>")
document.writeln(y, "<br>")