import { useEffect } from "react";

function Child() {

    useEffect(() => {
        console.log("are child aa gya");

        return () => {
            console.log("child delete ho gya")
        };
    }, []);

    return (
        <>
            <h3>I am child component</h3>
            <p>Open console and click toggle button</p>
        </>
    )
}

export default Child;