import { useState } from "react";

function Counter1() {
    const[count, setCount] = useState(0)

    return(
        <>
        <p>Count-{count}</p>
        <button onClick={()=>setCount(count+1)}>Click here</button>
        </>
    )
}
export default Counter1