import "./Login.css";

function Login() {
    return (
        <div className="login-bg">
            <div className="login-box">

                <div className="avatar">
                    <img
                        src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png"
                        alt="user"
                    />
                </div>

                <h2>LOGIN WINDOW</h2>

                <input
                    type="email"
                    placeholder="Your Email Address"
                />

                <input
                    type="password"
                    placeholder="Your Password"
                />

                <div className="terms">
                    <input type="checkbox" />
                    <label htmlFor="terms">
                        Agree With <u>Terms & Condition</u>
                    </label>
                </div>

                <button>Login</button>

            </div>
        </div>
    );
}

export default Login;