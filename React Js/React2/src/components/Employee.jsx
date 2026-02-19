function Employee({name="Harshita"}) {
    return (
        <>
        <h1>Employee Details</h1>
        <h2>Name is {name}</h2>
        </>
    )
}

// class component

/* import { Component } from "react";

class Employee extends Component {
    render() {
        return (
            <>
            <h1>Name is {this.props.name}</h1>
            </>
        )
    }
} */

export default Employee