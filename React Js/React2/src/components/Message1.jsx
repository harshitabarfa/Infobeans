import { useState } from "react";

function Message1() {
    const[message, setMessage] = useState('Welcome guys')

    const changeMessage = () => {
        setMessage('Thanks guys')
    }

    return (
        <>
        <h1>{message}</h1>
        <button onClick={changeMessage}>Change Message</button>
        </>
    )
}
export default Message1