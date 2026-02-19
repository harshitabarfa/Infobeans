import React, { useState } from "react";

function Seven() {
    const [formData, setFormData] = useState({
        fullName: "",
        username: "",
        email: "",
        phone: "",
        gender: "",
        dob: "",
        bio: "",
        profilePic: null,
    });

    const [errors, setErrors] = useState({});
    const [preview, setPreview] = useState(null);

    const handleChange = (e) => {
        const { name, value, files } = e.target;
        setFormData({
            ...formData,
            [name]: files ? files[0] : value,
        });
    };

    const validate = () => {
        let newErrors = {};

        if (!formData.fullName)
            newErrors.fullName = "Full Name is required";
        else if (!/^[A-Za-z ]+$/.test(formData.fullName))
            newErrors.fullName = "Letters only";

        if (!formData.username)
            newErrors.username = "Username is required";
        else if (!/^[^\s]{5,15}$/.test(formData.username))
            newErrors.username = "5–15 characters, no spaces";

        if (!formData.email)
            newErrors.email = "Email is required";
        else if (!/^\S+@\S+\.\S+$/.test(formData.email))
            newErrors.email = "Invalid email format";

        if (!formData.phone)
            newErrors.phone = "Phone is required";
        else if (!/^\d{10}$/.test(formData.phone))
            newErrors.phone = "Must be exactly 10 digits";

        if (!formData.gender)
            newErrors.gender = "Gender is required";

        if (!formData.dob) {
            newErrors.dob = "Date of Birth is required";
        } else {
            const age =
                new Date().getFullYear() -
                new Date(formData.dob).getFullYear();
            if (age < 18) newErrors.dob = "Must be at least 18 years old";
        }

        if (formData.bio.length > 200)
            newErrors.bio = "Bio must be under 200 characters";

        setErrors(newErrors);
        return Object.keys(newErrors).length === 0;
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        if (validate()) {
            setPreview(formData);
            setFormData({
                fullName: "",
                username: "",
                email: "",
                phone: "",
                gender: "",
                dob: "",
                bio: "",
                profilePic: null,
            });
            setErrors({});
        }
    };

    return (
        <div>
            <h2>Profile Update Form</h2>

            <form onSubmit={handleSubmit}>
                <input
                    name="fullName"
                    placeholder="Full Name"
                    value={formData.fullName}
                    onChange={handleChange}
                />
                <p>{errors.fullName}</p>

                <input
                    name="username"
                    placeholder="Username"
                    value={formData.username}
                    onChange={handleChange}
                />
                <p>{errors.username}</p>

                <input
                    name="email"
                    placeholder="Email"
                    value={formData.email}
                    onChange={handleChange}
                />
                <p>{errors.email}</p>

                <input
                    name="phone"
                    placeholder="Phone"
                    value={formData.phone}
                    onChange={handleChange}
                />
                <p>{errors.phone}</p>

                <div>
                    Gender:
                    <label>
                        <input
                            type="radio"
                            name="gender"
                            value="Male"
                            onChange={handleChange}
                        /> Male
                    </label>
                    <label>
                        <input
                            type="radio"
                            name="gender"
                            value="Female"
                            onChange={handleChange}
                        /> Female
                    </label>
                    <label>
                        <input
                            type="radio"
                            name="gender"
                            value="Other"
                            onChange={handleChange}
                        /> Other
                    </label>
                </div>
                <p>{errors.gender}</p>

                <input
                    type="date"
                    name="dob"
                    value={formData.dob}
                    onChange={handleChange}
                />
                <p>{errors.dob}</p>

                <input
                    type="file"
                    name="profilePic"
                    onChange={handleChange}
                />

                <textarea
                    name="bio"
                    placeholder="Bio (max 200 chars)"
                    value={formData.bio}
                    onChange={handleChange}
                />
                <p>{errors.bio}</p>

                <button type="submit">Update Profile</button>
            </form>

            {preview && (
                <div>
                    <h3>Updated Profile Preview</h3>
                    <p><b>Name:</b> {preview.fullName}</p>
                    <p><b>Username:</b> {preview.username}</p>
                    <p><b>Email:</b> {preview.email}</p>
                    <p><b>Phone:</b> {preview.phone}</p>
                    <p><b>Gender:</b> {preview.gender}</p>
                    <p><b>DOB:</b> {preview.dob}</p>
                    <p><b>Bio:</b> {preview.bio}</p>
                </div>
            )}
        </div>
    );
}

export default Seven