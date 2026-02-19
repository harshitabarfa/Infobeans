function validateForm() {
    let valid = true;

    let name = document.getElementById("customerName");
    if (name.value.trim() === "" || !/^[A-Za-z ]+$/.test(name.value)) {
        document.getElementById("nameError").innerText = "Enter valid name";
        valid = false;
    } else document.getElementById("nameError").innerText = "";

    let order = document.getElementById("orderId");
    if (!/^[A-Za-z0-9]{8}$/.test(order.value)) {
        document.getElementById("orderError").innerText = "Order ID must be 8 characters";
        valid = false;
    } else document.getElementById("orderError").innerText = "";

    let email = document.getElementById("email");
    if (!/^\S+@\S+\.\S+$/.test(email.value)) {
        document.getElementById("emailError").innerText = "Invalid email";
        valid = false;
    } else document.getElementById("emailError").innerText = "";

    let product = document.getElementById("productName");
    if (product.value.trim() === "" || !/^[A-Za-z ]+$/.test(product.value)) {
        document.getElementById("productError").innerText = "Invalid product name";
        valid = false;
    } else document.getElementById("productError").innerText = "";

    if (!document.querySelector('input[name="rating"]:checked')) {
        document.getElementById("ratingError").innerText = "Select rating";
        valid = false;
    } else document.getElementById("ratingError").innerText = "";

    let type = document.getElementById("feedbackType");
    if (type.value === "") {
        document.getElementById("typeError").innerText = "Select feedback type";
        valid = false;
    } else document.getElementById("typeError").innerText = "";

    let msg = document.getElementById("message");
    if (msg.value.length < 20 || msg.value.length > 500) {
        document.getElementById("messageError").innerText = "20–500 characters required";
        valid = false;
    } else document.getElementById("messageError").innerText = "";

    if (!document.querySelector('input[name="recommend"]:checked')) {
        document.getElementById("recommendError").innerText = "Select an option";
        valid = false;
    } else document.getElementById("recommendError").innerText = "";

    return valid;
}