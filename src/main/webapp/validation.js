// Form validation logic
document.getElementById("registrationForm").addEventListener("submit", function(event) {
    const username = document.getElementById("username").value.trim();
    const email = document.getElementById("email").value.trim();

    if (username === "" || email === "" || password==="") {
        alert("Please fill in all fields.");
        event.preventDefault();
    } else if (!isValidEmail(email)) {
        alert("Please enter a valid email address.");
        event.preventDefault();
    }
});

// Function to validate email format
function isValidEmail(email) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}
