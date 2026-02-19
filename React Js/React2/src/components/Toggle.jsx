import { useState } from "react";

function Toggle() {
    const [isOn, setIsOn] = useState(false);
    return (
        <>
            <h1>{isOn ? "ON" : "OFF"}</h1>
            <button onClick={() => setIsOn(!isOn)}>Toggle</button>
        </>
    )
}
export default Toggle