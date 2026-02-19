import { Component } from "react";

class Message extends Component {
    constructor() {
        super();

        this.state = {
            message : 'hey guys how are you'
        }
    }

    changeMessage =()=> {
       // message : 'thanks guys'
       this.setState({
        message : 'thanks guys'
       })
    }

    render() {
        return (
            <>
            <h1>Message is: {this.state.message}</h1>
            <button onClick={this.changeMessage}>Change Message</button>
            </>
        )
    }
}

export default Message