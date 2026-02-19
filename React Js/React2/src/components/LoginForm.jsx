import { useEffect, useState } from "react";

function LoginForm() {

    const [form, setForm] = useState({
        username: "",
        email: "",
        password: "",
        confirmPassword: ""
    });

    const [errors, setErrors] = useState({});
    const [isFormValid, setIsFormValid] = useState(false);

    const validate = () => {
        let newErrors = {};
        let isValide = true;

        if (!form.username.trim()) {
            newErrors.username = "Username is Required";
            isValide = false;
        }

        if (!form.email.includes("@")) {
            newErrors.email = " Email must contain @";
            isValide = false;
        }

        if (form.password.length < 6) {
            newErrors.password = "Password Must be at least 6 Character";
            isValide = false;
        }

        if (form.password !== form.confirmPassword) {
            newErrors.confirmPassword = "Password do not match";
            isValide = false;
        }

        setErrors(newErrors);
        return isValide;
    };

    useEffect(() => {
        setIsFormValid(validate());
    }, [form]);

    const handleSubmit = (e) => {
        e.preventDefault();

        if (validate()) {
            alert("Signup Successful !");
            console.log("Form Data :", form);

            setForm({
                username: "",
                email: "",
                password: "",
                confirmPassword: ""
            });

            setErrors({});
            setIsFormValid(false);
        }
    };

    return (
        <div style={{ width: "300px", margin: "auto" }}>
            <h2>SignUp Form </h2>

            <form onSubmit={handleSubmit}>
                <div>
                    <input type="text" placeholder="Username"
                        value={form.username}
                        onChange={(e) =>
                            setForm({ ...form, username: e.target.value })
                        } />
                    <p style={{ color: "red" }}>{errors.username}</p>
                </div>

                <div>
                    <input type="text" placeholder="Email"
                        value={form.email}
                        onChange={(e) =>
                            setForm({ ...form, email: e.target.value })
                        } />
                    <p style={{ color: "red" }}>{errors.email}</p>
                </div>

                <div>
                    <input type="password" placeholder="Password"
                        value={form.password}
                        onChange={(e) =>
                            setForm({ ...form, password: e.target.value })
                        } />
                    <p style={{ color: "red" }}>{errors.password}</p>
                </div>

                <div>
                    <input type="password" placeholder="Confirm Password"
                        value={form.confirmPassword}
                        onChange={(e) =>
                            setForm({ ...form, confirmPassword: e.target.value })
                        } />
                    <p style={{ color: "red" }}>{errors.confirmPassword}</p>
                </div>

                <button type="submit" disabled={!isFormValid}>SignUp</button>
            </form>
        </div>
    );
}

export default LoginForm