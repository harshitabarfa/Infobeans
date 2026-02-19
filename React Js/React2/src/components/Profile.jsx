import { useState } from "react"

function Profile() {
    const [name, setName] = useState("harshita")
    const [address, setAddress] = useState("indore")

    return (
        <>
        Name is {name} <br />
        City is {address}
        </>
    )
}

export default Profile