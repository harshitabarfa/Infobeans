import { useState } from "react";

function InputExample() {
    const [name, setName] = useState("");

    return (
        <>
            <input type="text" onChange={(e) => setName(e.target.value)} />
            <h2>My name is : {name}</h2>
        </>
    )
}
export default InputExample