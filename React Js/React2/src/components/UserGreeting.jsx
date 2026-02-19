import { Component, useState } from "react";

/* class UserGreeting extends Component {
    constructor() {
        super();

        this.state = {
            isLoggedIn: false
        }
    }

    render() {
        if (this.state.isLoggedIn) {
            return (
                <div>Welcome User</div>
            )
        } else {
            return (
                <div>Please Logged In</div>
            )
        }
    }
} */

/* function UserGreeting() {
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    if(isLoggedIn) {
        return (
            <div>Welcome user</div>
        ); 
    } else {
        return (
            <div>Please Logged In</div>
        );
    }
} */

/* class UserGreeting extends Component {
    constructor() {
        super();

        this.state = {
            isLoggedIn: true3
        }
    }

    render() {
        let message;
        if (this.state.isLoggedIn) {
            return (
                message = <div>Welcome User</div>
            )
        } else {
            return (
                message = <div>Please Logged In</div>
            )
        }
        return message;
    }
} */

/* class UserGreeting extends Component {
    constructor() {
        super();

        this.state = {
            isLoggedIn: true
        }
    }

    render() {
        return (
            this.state.isLoggedIn?<div>Welcome user</div>:<div>Please Logged In</div>
        )
    }
} */

/* function UserGreeting() {
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    return (
        <div>
            {isLoggedIn ? <h2>Welcome User</h2> : <h2>Please Logges In</h2> }

            <button onClick={() => setIsLoggedIn(!isLoggedIn)}> {isLoggedIn ? "Logout" : "Login"} </button>
        </div>
    )
} */

class UserGreeting extends Component {
    constructor() {
        super();

        this.state = {
            isLoggedIn: true
        }
    }

    render() {
        return (
            this.state.isLoggedIn && <div>Welocome user</div>
        )
    }
}

export default UserGreeting