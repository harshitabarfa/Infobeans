import { useParams } from "react-router-dom";

function User() {

    const { id } = useParams();

    return (
        <>
            <h1>Welcome to user page</h1>
            <h1>Id of a user is : {id}</h1>
        </>
    )
}

export default User;