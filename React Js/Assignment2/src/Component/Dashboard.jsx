import { useLocation, useNavigate } from "react-router-dom";
import { useEffect } from "react";

function Dashboard() {
    const location = useLocation();
    const navigate = useNavigate();

    useEffect(() => {
        if (!location.state) {
            navigate("/login", { replace: true });
        }
    }, [location.state, navigate]);

    if (!location.state) return null;

    const { username, role } = location.state;

    const handleLogout = () => {
        navigate("/login", { replace: true });
    };

    return (
        <div>
            <h2>Dashboard</h2>

            <h3>Welcome {username}</h3>
            <p>Role: {role}</p>

            {role === "Faculty" && (
                <button>Upload Marks</button>
            )}

            {role === "Student" && (
                <button>View Results</button>
            )}

            <br /><br />

            <button onClick={handleLogout}>Logout</button>
        </div>
    );
}

export default Dashboard;