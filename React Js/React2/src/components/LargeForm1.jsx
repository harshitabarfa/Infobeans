import { useState } from "react";

function LargeForm1() {
    const [formdata, setFormData] = useState({
        username: "",
        password: ""
    })

    const handleSubmit = (e) => {
        e.preventDefault()
        alert("from submitted")
        alert(`username: ${formdata.username} and password: ${formdata.password}`)
    }

    return (
        <form onSubmit={handleSubmit}>
            <label>Enter user name</label>
            <input type="text" value={formdata.username} onChange={(e) => setFormData({ ...formdata, username: e.target.value })} />

            <br />
            <label>Enter password</label>
            <input type="password" value={formdata.password} onChange={(e) => setFormData({ ...formdata, password: e.target.value })} />

            <br />
            <button type="submit">Login</button>
        </form>
    )
}

export default LargeForm1