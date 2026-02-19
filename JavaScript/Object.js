/* var student = {
    id:101,
    name:'harshita',
    salary:50000
}
console.log(student)
console.log(typeof(student))

console.log(student['name'])
console.log(student.salary) */

/* var student = {

}
student['firstname'] = 'harshita'
student.lastname = 'barfa'

console.log(student.firstname)
console.log(student.lastname) */

/* var student = {
    id : 101,
    name : 'harshita',
    salary : 50000
}

for(x in student) {
    console.log(x)
    console.log(student[x])
} */

function show() {
    console.log("Show method call")
    console.log("This is display function")
    console.log(this.id + " and " + this.name)
}

var student = {
    id: 101,
    name: 'harshita',

    /* display:function() {
        console.log("This is display function")
        // console.log(id + " and " + name) // Error
    } */
    display: show
}
student.display();