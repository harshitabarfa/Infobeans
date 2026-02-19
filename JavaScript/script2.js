/* var x = parseInt(prompt("Enter a number"))

if(x%2==0)
    alert("Number is even")
else
    alert("Number is odd") */

/* for(var i = 1; i<=10; i++)
{
    console.log(i)
} */

var x = 1
/* while (x <= 10) {
    console.log(x);
    x++;
} */

/* do {
    console.log(x);
    x++;
} while (x <= 10); */

var n = parseInt(prompt("Enter a number:"));
/* var isPrime = true;

if (n < 2) {
    isPrime = false;
}

for (var i = 2; i < n; i++) {
    if (n % i === 0) {
        isPrime = false;
        break;
    }
}

if (isPrime) {
    console.log(n + " is Prime");
} else {
    console.log(n + " is Not Prime");
} */

var sum = 0;
/* for (; n>0; n = Math.floor(n/10)) {
    var d = n%10;
    sum += d;
}
console.log(sum) */

for (var i = 1; i < n; i++) {
    if (n % i == 0) {
        sum += i;
    }
}

if (sum == n) {
    console.log("Number is perfect")
}
else {
    console.log("Number is not perfect")
}