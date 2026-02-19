import { useState } from "react"

function LargeForm() {
    const [name, setName] = useState("")
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [gender, setGender] = useState("")
    const [agree, setAgree] = useState(false)
    const [country, setCountry] = useState("")
    const [bio, setBio] = useState("")
    const [submitted, setSubmitted] = useState(false);

    const handleSubmit = (e) => {
        e.preventDefault()
        setSubmitted(true)
    }

    return (
        <>
            <form onSubmit={handleSubmit}>
                <h2>Registration page</h2>

                <div>
                    <label>Name:</label>
                    <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
                </div>

                <div>
                    <label>Email:</label>
                    <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
                </div>

                <div>
                    <label>Password:</label>
                    <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
                </div>

                <div>
                    <label>Gender:</label>
                    <input type="radio" name="gender" value="Male" onChange={(e) => setGender(e.target.value)} /> Male

                    <input type="radio" name="gender" value="Female" onChange={(e) => setGender(e.target.value)} /> Female
                </div>

                <div>
                    <label>Country:</label>
                    <select value={country} onChange={(e) => setCountry(e.target.value)}>
                        <option value="">Select</option>
                        <option value="India">India</option>
                        <option value="USA">USA</option>
                        <option value="UK">UK</option>
                    </select>
                </div>

                <div>
                    <label>Bio:</label>
                    <textarea value={bio} onChange={(e) => setBio(e.target.value)} />
                </div>

                <div>
                    <input type="checkbox" checked={agree} onChange={(e) => setAgree(e.target.checked)} />
                    <label>I agree to terms and condition</label>
                </div>

                <button type="submit">Register</button>
            </form>

            {submitted && (
                <div>
                    <h3>Submitted Data</h3>
                    <p>Name: {name}</p>
                    <p>Email: {email}</p>
                    <p>Password: {password}</p>
                    <p>Gender: {gender}</p>
                    <p>Country: {country}</p>
                    <p>Bio: {bio}</p>
                    <p>Agreed: {agree ? "Yes" : "No"}</p>
                </div>

            )}
        </>
    )
}

export default LargeForm