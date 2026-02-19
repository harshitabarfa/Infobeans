import { useState } from "react";

function Counter2() {
    const initialCount=0;
    const [count, setCount]=useState(initialCount)

    const incrementFive = ()=>{
        for(let i =0; i<5; i++) {
            setCount(prevCount=>prevCount+1)
        }
    }

    return(
        <>
        Count : {count}
        <button onClick={incrementFive}>Increment five</button>
        <button onClick={()=>setCount(count+1)}>Increment</button>
        <button onClick={()=>setCount(initialCount)}>Reset</button>
        <button onClick={()=>setCount(count-1)}>Decrement</button>
        </>
    )
}
export default Counter2;