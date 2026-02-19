import { useState } from "react"

function User() {
    const [user, setUser] = useState({name : "Harshita", age : 20, address : "Indore"})

    return (
        <>
        <h2>Name: {user.name}</h2>
        <h2>Age : {user.age}</h2>
        <h2>Address : {user.address}</h2>
        <button onClick={() =>setUser({...user, age:21})}>Update age</button>
        </>
    )
}
export default User