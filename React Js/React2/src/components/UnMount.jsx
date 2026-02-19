import { useState } from "react";
import Child from "./Child";

function UnMount() {
    const [show, setShow] = useState(true);

    return (
        <div>
            <h2>Clean up unmount</h2>

            <button onClick={() => setShow(! show)}>{show ? "Hide child" : "Show child"}</button>

            {show && <Child />}
        </div>
    );
}

export default UnMount;