import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Login() {
    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        username: "",
        password: "",
        role: ""
    });

    const [errors, setErrors] = useState({});

    const handleChange = (e) => {
        const { name, value } = e.target;

        setFormData({
            ...formData,
            [name]: value
        });

        setErrors({
            ...errors,
            [name]: "",
            credentials: ""
        });
    };

    const validate = () => {
        let newErrors = {};

        if (!formData.username) {
            newErrors.username = "Username is required";
        } else if (formData.username.length < 4) {
            newErrors.username = "Username must be at least 4 characters";
        }

        if (!formData.password) {
            newErrors.password = "Password is required";
        } else if (formData.password.length < 6) {
            newErrors.password = "Password must be at least 6 characters";
        }

        if (!formData.role) {
            newErrors.role = "Please select a role";
        }

        if (
            formData.username !== "admin" ||
            formData.password !== "admin123"
        ) {
            newErrors.credentials = "Invalid username or password";
        }

        setErrors(newErrors);
        return Object.keys(newErrors).length === 0;
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        if (validate()) {
            navigate("/dashboard", {
                state: {
                    username: formData.username,
                    role: formData.role
                }
            });
        }
    };

    return (
        <div>
            <h2>College Portal Login</h2>

            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    name="username"
                    placeholder="Username"
                    value={formData.username}
                    onChange={handleChange}
                />
                {errors.username && (
                    <p style={{ color: "red" }}>{errors.username}</p>
                )}

                <input
                    type="password"
                    name="password"
                    placeholder="Password"
                    value={formData.password}
                    onChange={handleChange}
                />
                {errors.password && (
                    <p style={{ color: "red" }}>{errors.password}</p>
                )}

                <select
                    name="role"
                    value={formData.role}
                    onChange={handleChange}
                >
                    <option value="">Select Role</option>
                    <option value="Student">Student</option>
                    <option value="Faculty">Faculty</option>
                </select>
                {errors.role && (
                    <p style={{ color: "red" }}>{errors.role}</p>
                )}

                {errors.credentials && (
                    <p style={{ color: "red" }}>{errors.credentials}</p>
                )}

                <button type="submit">Login</button>
            </form>
        </div>
    );
}

export default Login;  