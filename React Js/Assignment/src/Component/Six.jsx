import React, { useState } from 'react';

const Six = () => {
    const [formData, setFormData] = useState({
        firstName: '',
        lastName: '',
        username: '',
        email: '',
        password: '',
        confirmPassword: '',
        phoneNumber: '',
        gender: '',
        dateOfBirth: '',
        website: '',
        termsAccepted: false,
    });

    const [errors, setErrors] = useState({});
    const [submittedData, setSubmittedData] = useState(null);

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;
        setFormData((prevState) => ({
            ...prevState,
            [name]: type === 'checkbox' ? checked : value,
        }));
    };

    const validateForm = () => {
        const newErrors = {};

        if (!formData.firstName || !/^[A-Za-z]+$/.test(formData.firstName)) {
            newErrors.firstName = 'First name is required and must only contain letters.';
        }

        if (!formData.lastName || !/^[A-Za-z]+$/.test(formData.lastName)) {
            newErrors.lastName = 'Last name is required and must only contain letters.';
        }

        if (!formData.username || formData.username.length < 5 || formData.username.length > 15 || /\s/.test(formData.username)) {
            newErrors.username = 'Username is required, 5–15 characters, and no spaces allowed.';
        }

        if (!formData.email || !/^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/.test(formData.email)) {
            newErrors.email = 'Email is required and must be a valid email format.';
        }

        if (
            !formData.password ||
            formData.password.length < 8 ||
            !/[A-Z]/.test(formData.password) ||
            !/[a-z]/.test(formData.password) ||
            !/[0-9]/.test(formData.password) ||
            !/[!@#$%^&*(),.?":{}|<>]/.test(formData.password)
        ) {
            newErrors.password = 'Password is required, minimum 8 characters, and must contain at least one uppercase letter, one lowercase letter, one number, and one special character.';
        }

        if (formData.password !== formData.confirmPassword) {
            newErrors.confirmPassword = 'Confirm Password must match Password.';
        }

        if (!formData.phoneNumber || !/^\d{10}$/.test(formData.phoneNumber)) {
            newErrors.phoneNumber = 'Phone number is required and must be exactly 10 digits.';
        }

        if (!formData.gender) {
            newErrors.gender = 'Gender is required.';
        }

        const dob = new Date(formData.dateOfBirth);
        const age = new Date().getFullYear() - dob.getFullYear();
        if (!formData.dateOfBirth || age < 18) {
            newErrors.dateOfBirth = 'You must be at least 18 years old.';
        }

        if (formData.website && !/^https?:\/\/[^\s]+$/.test(formData.website)) {
            newErrors.website = 'Website must be a valid URL (optional).';
        }

        if (!formData.termsAccepted) {
            newErrors.termsAccepted = 'You must accept the terms and conditions.';
        }

        setErrors(newErrors);
        return Object.keys(newErrors).length === 0;
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        if (validateForm()) {
            setSubmittedData(formData);
            setFormData({
                firstName: '',
                lastName: '',
                username: '',
                email: '',
                password: '',
                confirmPassword: '',
                phoneNumber: '',
                gender: '',
                dateOfBirth: '',
                website: '',
                termsAccepted: false,
            });
        }
    };

    return (
        <div>
            <h2>Signup Form</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>First Name:</label>
                    <input
                        type="text"
                        name="firstName"
                        value={formData.firstName}
                        onChange={handleChange}
                        required
                    />
                    {errors.firstName && <p style={{ color: 'red' }}>{errors.firstName}</p>}
                </div>

                <div>
                    <label>Last Name:</label>
                    <input
                        type="text"
                        name="lastName"
                        value={formData.lastName}
                        onChange={handleChange}
                        required
                    />
                    {errors.lastName && <p style={{ color: 'red' }}>{errors.lastName}</p>}
                </div>

                <div>
                    <label>Username:</label>
                    <input
                        type="text"
                        name="username"
                        value={formData.username}
                        onChange={handleChange}
                        required
                    />
                    {errors.username && <p style={{ color: 'red' }}>{errors.username}</p>}
                </div>

                <div>
                    <label>Email:</label>
                    <input
                        type="email"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                        required
                    />
                    {errors.email && <p style={{ color: 'red' }}>{errors.email}</p>}
                </div>

                <div>
                    <label>Password:</label>
                    <input
                        type="password"
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                        required
                    />
                    {errors.password && <p style={{ color: 'red' }}>{errors.password}</p>}
                </div>

                <div>
                    <label>Confirm Password:</label>
                    <input
                        type="password"
                        name="confirmPassword"
                        value={formData.confirmPassword}
                        onChange={handleChange}
                        required
                    />
                    {errors.confirmPassword && <p style={{ color: 'red' }}>{errors.confirmPassword}</p>}
                </div>

                <div>
                    <label>Phone Number:</label>
                    <input
                        type="text"
                        name="phoneNumber"
                        value={formData.phoneNumber}
                        onChange={handleChange}
                        required
                    />
                    {errors.phoneNumber && <p style={{ color: 'red' }}>{errors.phoneNumber}</p>}
                </div>

                <div>
                    <label>Gender:</label>
                    <label>
                        <input
                            type="radio"
                            name="gender"
                            value="Male"
                            checked={formData.gender === 'Male'}
                            onChange={handleChange}
                        />{' '}
                        Male
                    </label>
                    <label>
                        <input
                            type="radio"
                            name="gender"
                            value="Female"
                            checked={formData.gender === 'Female'}
                            onChange={handleChange}
                        />{' '}
                        Female
                    </label>
                    <label>
                        <input
                            type="radio"
                            name="gender"
                            value="Other"
                            checked={formData.gender === 'Other'}
                            onChange={handleChange}
                        />{' '}
                        Other
                    </label>
                    {errors.gender && <p style={{ color: 'red' }}>{errors.gender}</p>}
                </div>

                <div>
                    <label>Date of Birth:</label>
                    <input
                        type="date"
                        name="dateOfBirth"
                        value={formData.dateOfBirth}
                        onChange={handleChange}
                        required
                    />
                    {errors.dateOfBirth && <p style={{ color: 'red' }}>{errors.dateOfBirth}</p>}
                </div>

                <div>
                    <label>Website (optional):</label>
                    <input
                        type="url"
                        name="website"
                        value={formData.website}
                        onChange={handleChange}
                    />
                    {errors.website && <p style={{ color: 'red' }}>{errors.website}</p>}
                </div>

                <div>
                    <label>
                        <input
                            type="checkbox"
                            name="termsAccepted"
                            checked={formData.termsAccepted}
                            onChange={handleChange}
                            required
                        />
                        I accept the Terms & Conditions
                    </label>
                    {errors.termsAccepted && <p style={{ color: 'red' }}>{errors.termsAccepted}</p>}
                </div>

                <button type="submit">Submit</button>
            </form>

            {submittedData && (
                <div>
                    <h3>Entered Details:</h3>
                    <p>First Name: {submittedData.firstName}</p>
                    <p>Last Name: {submittedData.lastName}</p>
                    <p>Username: {submittedData.username}</p>
                    <p>Email: {submittedData.email}</p>
                    <p>Phone Number: {submittedData.phoneNumber}</p>
                    <p>Gender: {submittedData.gender}</p>
                    <p>Date of Birth: {submittedData.dateOfBirth}</p>
                    <p>Website: {submittedData.website || 'N/A'}</p>
                </div>
            )}
        </div>
    );
};

export default Six