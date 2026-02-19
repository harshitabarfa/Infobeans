import React, { useState } from "react";

const StudentRegistrationForm = () => {
    const [formData, setFormData] = useState({
        firstName: "",
        lastName: "",
        email: "",
        mobile: "",
        gender: "",
        dob: { day: "", month: "", year: "" },
        address: "",
        city: "",
        pinCode: "",
        state: "",
        country: "",
        hobbies: {
            drawing: false,
            singing: false,
            dancing: false,
            sketching: false,
            others: ""
        },
        qualification: [],
        course: ""
    });

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;

        if (name in formData.hobbies) {
            setFormData({
                ...formData,
                hobbies: { ...formData.hobbies, [name]: type === "checkbox" ? checked : value }
            });
        } else if (["day", "month", "year"].includes(name)) {
            setFormData({
                ...formData,
                dob: { ...formData.dob, [name]: value }
            });
        } else if (type === "checkbox") {
            const updatedQualification = checked
                ? [...formData.qualification, value]
                : formData.qualification.filter((q) => q !== value);
            setFormData({ ...formData, qualification: updatedQualification });
        } else {
            setFormData({ ...formData, [name]: value });
        }
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log("Form Data:", formData);
        alert("Form Submitted! Check console for data.");
    };

    const handleReset = () => {
        setFormData({
            firstName: "",
            lastName: "",
            email: "",
            mobile: "",
            gender: "",
            dob: { day: "", month: "", year: "" },
            address: "",
            city: "",
            pinCode: "",
            state: "",
            country: "",
            hobbies: { drawing: false, singing: false, dancing: false, sketching: false, others: "" },
            qualification: [],
            course: ""
        });
    };

    return (
        <div style={{ backgroundColor: "red", padding: "20px", color: "white" }}>
            <h2 style={{ textAlign: "center", textDecoration: "underline" }}>
                Student Registration Form Using React
            </h2>
            <form onSubmit={handleSubmit}>
                <table>
                    <tbody>
                        <tr>
                            <td>First Name</td>
                            <td>
                                <input
                                    type="text"
                                    name="firstName"
                                    value={formData.firstName}
                                    maxLength="50"
                                    onChange={handleChange}
                                    required
                                />
                                <span>(Max 50 Characters Allowed)</span>
                            </td>
                        </tr>

                        <tr>
                            <td>Last Name</td>
                            <td>
                                <input
                                    type="text"
                                    name="lastName"
                                    value={formData.lastName}
                                    maxLength="50"
                                    onChange={handleChange}
                                    required
                                />
                                <span>(Max 50 Characters Allowed)</span>
                            </td>
                        </tr>

                        <tr>
                            <td>Email ID</td>
                            <td>
                                <input
                                    type="email"
                                    name="email"
                                    value={formData.email}
                                    onChange={handleChange}
                                    required
                                />
                            </td>
                        </tr>

                        <tr>
                            <td>Mobile Number</td>
                            <td>
                                <input
                                    type="text"
                                    name="mobile"
                                    value={formData.mobile}
                                    maxLength="10"
                                    onChange={handleChange}
                                    required
                                />
                                <span>(10 Digits Allowed)</span>
                            </td>
                        </tr>

                        <tr>
                            <td>Gender</td>
                            <td>
                                <label>
                                    <input
                                        type="radio"
                                        name="gender"
                                        value="Male"
                                        checked={formData.gender === "Male"}
                                        onChange={handleChange}
                                    />{" "}
                                    Male
                                </label>
                                <label>
                                    <input
                                        type="radio"
                                        name="gender"
                                        value="Female"
                                        checked={formData.gender === "Female"}
                                        onChange={handleChange}
                                    />{" "}
                                    Female
                                </label>
                            </td>
                        </tr>

                        <tr>
                            <td>Date of Birth (DOB)</td>
                            <td>
                                <select name="day" value={formData.dob.day} onChange={handleChange}>
                                    <option value="">Day</option>
                                    {[...Array(31)].map((_, i) => (
                                        <option key={i + 1} value={i + 1}>
                                            {i + 1}
                                        </option>
                                    ))}
                                </select>
                                <select name="month" value={formData.dob.month} onChange={handleChange}>
                                    <option value="">Month</option>
                                    {[...Array(12)].map((_, i) => (
                                        <option key={i + 1} value={i + 1}>
                                            {i + 1}
                                        </option>
                                    ))}
                                </select>
                                <select name="year" value={formData.dob.year} onChange={handleChange}>
                                    <option value="">Year</option>
                                    {Array.from({ length: 100 }, (_, i) => 2026 - i).map((year) => (
                                        <option key={year} value={year}>
                                            {year}
                                        </option>
                                    ))}
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td>Address</td>
                            <td>
                                <textarea
                                    name="address"
                                    value={formData.address}
                                    onChange={handleChange}
                                ></textarea>
                            </td>
                        </tr>

                        <tr>
                            <td>City</td>
                            <td>
                                <input
                                    type="text"
                                    name="city"
                                    value={formData.city}
                                    maxLength="50"
                                    onChange={handleChange}
                                />
                            </td>
                        </tr>

                        <tr>
                            <td>Pin Code</td>
                            <td>
                                <input
                                    type="text"
                                    name="pinCode"
                                    value={formData.pinCode}
                                    maxLength="6"
                                    onChange={handleChange}
                                />
                            </td>
                        </tr>

                        <tr>
                            <td>State</td>
                            <td>
                                <input
                                    type="text"
                                    name="state"
                                    value={formData.state}
                                    maxLength="50"
                                    onChange={handleChange}
                                />
                            </td>
                        </tr>

                        <tr>
                            <td>Country</td>
                            <td>
                                <input type="text" name="country" value={formData.country} onChange={handleChange} />
                            </td>
                        </tr>

                        <tr>
                            <td>Hobbies</td>
                            <td>
                                <label>
                                    <input
                                        type="checkbox"
                                        name="drawing"
                                        checked={formData.hobbies.drawing}
                                        onChange={handleChange}
                                    />{" "}
                                    Drawing
                                </label>
                                <label>
                                    <input
                                        type="checkbox"
                                        name="singing"
                                        checked={formData.hobbies.singing}
                                        onChange={handleChange}
                                    />{" "}
                                    Singing
                                </label>
                                <label>
                                    <input
                                        type="checkbox"
                                        name="dancing"
                                        checked={formData.hobbies.dancing}
                                        onChange={handleChange}
                                    />{" "}
                                    Dancing
                                </label>
                                <label>
                                    <input
                                        type="checkbox"
                                        name="sketching"
                                        checked={formData.hobbies.sketching}
                                        onChange={handleChange}
                                    />{" "}
                                    Sketching
                                </label>
                                <label>
                                    Others:
                                    <input
                                        type="text"
                                        name="others"
                                        value={formData.hobbies.others}
                                        maxLength="50"
                                        onChange={handleChange}
                                    />
                                </label>
                            </td>
                        </tr>

                        <tr>
                            <td>Qualification</td>
                            <td>
                                {[
                                    "High School(10th)",
                                    "Higher School(12th)",
                                    "Graduation(Bachelors)",
                                    "Post Graduation(Masters)",
                                    "Phd"
                                ].map((qual) => (
                                    <label key={qual}>
                                        <input
                                            type="checkbox"
                                            name="qualification"
                                            value={qual}
                                            checked={formData.qualification.includes(qual)}
                                            onChange={handleChange}
                                        />{" "}
                                        {qual}
                                    </label>
                                ))}
                            </td>
                        </tr>

                        <tr>
                            <td>Course Applied For</td>
                            <td>
                                {[
                                    "BCA(Bachelor of Computer Applications)",
                                    "B.Com(Bachelor of Commerce)",
                                    "B.Sc(Bachelor of Science)",
                                    "BA(Bachelor of Arts)",
                                    "MCA(Master of Computer Applications)",
                                    "M.Com(Master of Commerce)",
                                    "M.Sc(Master of Science)",
                                    "MA(Master of Arts)"
                                ].map((course) => (
                                    <label key={course}>
                                        <input
                                            type="radio"
                                            name="course"
                                            value={course}
                                            checked={formData.course === course}
                                            onChange={handleChange}
                                        />{" "}
                                        {course}
                                    </label>
                                ))}
                            </td>
                        </tr>

                        <tr>
                            <td colSpan="2" style={{ textAlign: "center" }}>
                                <button type="submit">Submit</button>
                                <button type="button" onClick={handleReset}>
                                    Reset
                                </button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
    );
};

export default StudentRegistrationForm;