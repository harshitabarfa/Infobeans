import { useLocation, useNavigate } from "react-router-dom";

function Dashboard() {
    const navigate = useNavigate();
    const location = useLocation();

    const username = location.state?.username||"Guest";

    return (
        <div>
            <h2>Welcome to dashboard</h2>
            <p>Current path is : {location.pathname}</p>
            <p>Welcome {username}</p>
            <button onClick={() => navigate(-1)}>Go Back</button>
        </div>
    )
}

export default Dashboard;