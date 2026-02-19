import { Component } from "react";

class Life extends Component {
    constructor() {
        super()
        this.state = {
            name: 'harshita'
        }
        console.log("Constructor")
    }

    static getDerivedStateFromProps(props, state) {
        console.log("Get derived state from props")
        return null
    }

    componentDidMount() {
        console.log("Component did mount")
    }

    render() {
        console.log("Reder is called")

        return (
            <h1>Life cycle methods from mounting phase</h1>
        )
    }
}

export default Life