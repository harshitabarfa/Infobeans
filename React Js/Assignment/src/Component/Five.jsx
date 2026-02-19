import React, { useState } from 'react';

const Five = () => {
    const [formData, setFormData] = useState({
        name: '',
        age: '',
        email: '',
        course: ''
    });

    const [submittedData, setSubmittedData] = useState(null);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevState) => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        setSubmittedData(formData);
        setFormData({ name: '', age: '', email: '', course: '' });
    };

    return (
        <div>
            <h2>Student Registration Form</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Name:</label>
                    <input
                        type="text"
                        name="name"
                        value={formData.name}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Age:</label>
                    <input
                        type="number"
                        name="age"
                        value={formData.age}
                        onChange={handleChange}
                        required
                    />
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
                </div>
                <div>
                    <label>Course:</label>
                    <select
                        name="course"
                        value={formData.course}
                        onChange={handleChange}
                        required
                    >
                        <option value="">Select Course</option>
                        <option value="React">React</option>
                        <option value="Java">Java</option>
                        <option value="Python">Python</option>
                    </select>
                </div>
                <button type="submit">Submit</button>
            </form>

            {submittedData && (
                <div>
                    <h3>Entered Details:</h3>
                    <p>Name: {submittedData.name}</p>
                    <p>Age: {submittedData.age}</p>
                    <p>Email: {submittedData.email}</p>
                    <p>Course: {submittedData.course}</p>
                </div>
            )}
        </div>
    );
};

export default Five
