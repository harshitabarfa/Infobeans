import React, { Component } from 'react';

class Third extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: '',
            email: ''
        };
    }

    handleChange = (e) => {
        const { name, value } = e.target;
        this.setState({ [name]: value })
    };

    render() {
        const { name, email } = this.state;

        return (
            <div>
                <form>
                    <div>
                        <label>Name:</label>
                        <input
                            type="text"
                            name="name"
                            value={name}
                            onChange={this.handleChange}
                        />
                    </div>
                    <div>
                        <label>Email:</label>
                        <input
                            type="email"
                            name="email"
                            value={email}
                            onChange={this.handleChange}
                        />
                    </div>
                </form>

                <h3>Entered Information:</h3>
                <p>Name: {name}</p>
                <p>Email: {email}</p>
            </div>
        );
    }
}

export default Third