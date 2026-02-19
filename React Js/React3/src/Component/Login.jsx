import { useNavigate } from "react-router-dom";

function Login() {
    const navigate = useNavigate();

    const handleLogin = () => {
        navigate('/dashboard', {
            state : {
                username : 'harshita'
            }
        })
    };

    return (
        <div>
            <h2>Login page</h2>
            <button onClick={handleLogin}>Login</button>
        </div>
    )
}

export default Login;