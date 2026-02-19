import React, { useState } from "react";

const Register = () => {
    const [formData, setFormData] = useState({
        firstname: "",
        middlename: "",
        lastname: "",
        course: "",
        gender: "",
        phone: "",
        address: "",
        email: "",
        password: "",
        confirmPassword: "",
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        // You can handle form submission here
        console.log("Form Data Submitted:", formData);
    };

    return (
        <div style={{ backgroundColor: "#87CEEB", padding: "20px", maxWidth: "500px", margin: "20px auto" }}>
            <h2>Registration Page</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Firstname: </label>
                    <input type="text" name="firstname" value={formData.firstname} onChange={handleChange} />
                </div>
                <div>
                    <label>Middlename: </label>
                    <input type="text" name="middlename" value={formData.middlename} onChange={handleChange} />
                </div>
                <div>
                    <label>Lastname: </label>
                    <input type="text" name="lastname" value={formData.lastname} onChange={handleChange} />
                </div>
                <div>
                    <label>Course: </label>
                    <select name="course" value={formData.course} onChange={handleChange}>
                        <option value="">Course</option>
                        <option value="React">React</option>
                        <option value="Angular">Angular</option>
                        <option value="Vue">Vue</option>
                    </select>
                </div>
                <div>
                    <label>Gender: </label>
                    <div>
                        <input type="radio" name="gender" value="Male" onChange={handleChange} /> Male
                    </div>
                    <div>
                        <input type="radio" name="gender" value="Female" onChange={handleChange} /> Female
                    </div>
                    <div>
                        <input type="radio" name="gender" value="Other" onChange={handleChange} /> Other
                    </div>
                </div>
                <div>
                    <label>Phone: </label>
                    <input type="text" name="phone" value={formData.phone} onChange={handleChange} placeholder="+91" />
                </div>
                <div>
                    <label>Address: </label>
                    <textarea name="address" value={formData.address} onChange={handleChange}></textarea>
                </div>
                <div>
                    <label>Email: </label>
                    <input type="email" name="email" value={formData.email} onChange={handleChange} />
                </div>
                <div>
                    <label>Password: </label>
                    <input type="password" name="password" value={formData.password} onChange={handleChange} />
                </div>
                <div>
                    <label>Re-type password: </label>
                    <input type="password" name="confirmPassword" value={formData.confirmPassword} onChange={handleChange} />
                </div>
                <div style={{ marginTop: "10px" }}>
                    <button type="submit">Submit</button>
                </div>
            </form>
        </div>
    );
};

export default Register;
