import { Component } from "react"

class Form extends Component {
    constructor() {
        super();

        this.state = {
            username: ''
        }
    }

    handleUserNameChange = (event) => {
        this.setState(
            {
                username: event.target.value
            }
        )
    }

    render() {
        return (
            <form>
                <div>
                    <label>Enter user name</label>
                    <input type="text" value={this.state.username} onChange={this.handleUserNameChange} />
                </div>
                {/* <h3>Entered Username: {this.state.username}</h3> */}
            </form>
        )
    }
}

export default Form