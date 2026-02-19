// Nested Function :- A function defined inside another function is called anotehr function.

/* function outer() {
    document.writeln("This is outer! <br>");
    function inner() {
        document.writeln("This is inner!")
    }
    inner();
}
outer(); */

/* function outer() {
    var name = "Harshita";
    document.writeln("This is outer! <br>");
    function inner() {
        var age = 20;
        document.writeln("Name is: ", name, "<br>");
        document.writeln("Age is: ", age);
    }
    // document.writeln("Age is: ", age) error
    inner();
}
outer(); */


// Closure :- It is a function that allow access to variable of outer function even after they outer function has finished an execution.

/* function outer() {
    var name = "Harshita"
    document.writeln("This is outer! <br>");
    function inner() {
        document.writeln("Name is: ", name)
    }
    return inner;
}
let x = outer();
x() */

// Here in the above example outer function returns inner function. Here inner function forms a closure by retaining access to name, which is a variable in the scope of outer().
// Even though outer has completed execution inner has still has access to name variable due to the closure

/* function calculate() {
    var count = 0;
    function inc() {
        count++;
        document.writeln(count);
    }
    return inc;
}

let y = calculate()
y()
y()
y() */

// Closures provides way to encapsulate data.
// With the help of closure we can access outer function data after completeion of outer function.
// Closure is when a function is able tto remember and access its lexical scope even when that function is executing outside its lexical scope.

// In simple terms, functions have access to variables that were in their scope at the time of their creation. This is what we call the function's lexical scope. A closure is a function that retains access to these variables even after the outer function has finished executing. This is like the function has a memory of its original environment.
// Clousure allow a function to remember the enviroment in which it was created, even if that enviroment is no longer present.


// Currying :- It is a technique to transform a function that take multiple arguments into a series of function that take one argument at a time. In simple word currying allow to craete specialize function by partially applying arguments which are remember through closures.

/* function add(a) {
    function sum(b) {
        return a+b;
    }
    return sum;
}
let s = add(10)
document.writeln(s(200)) */

/* function add(a) {
    function sum(b) {
        function total(c) {
            return a+b+c;
        }
        return total;
    }
    return sum;
}
let s = add(10);
let t = s(20);
document.writeln(t(30)) */

// Currying is a functional programming technique where a function with multiple arguments is decomposed into a sequence of functions, each taking a single argument. This allows for the partial application of functions, enabling more flexible and reusable code.

// Reusability: Curried functions can be reused with different sets of arguments.
// Partial application: You can create new functions by fixing some arguments of the original function.

function volume(length) {
  return function (width) {
    return function (height) {
      return length * width * height;
    };
  };
}

let a = volume(1)
let b = a(2)
document.writeln(b(3))


// Advantages of closure

/* Provides data privacy by hiding variables

Helps maintain state between function calls

Reduces use of global variables

Makes code modular and reusable

Useful in callbacks and asynchronous programming */