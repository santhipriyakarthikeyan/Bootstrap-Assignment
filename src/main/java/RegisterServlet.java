

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private Map<String, String> userCredentials; // In-memory storage for user credentials
	public void init() {
        // Initialize the userCredentials in the init() method
        userCredentials = new HashMap<>();
    } 

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Retrieve user input from the registration form
        String username = request.getParameter("username");
        
        String password = request.getParameter("password");

     
		// Store user data in the in-memory map
        userCredentials.put(username, password);

        // Set userCredentials in the application scope (ServletContext)
        getServletContext().setAttribute("userCredentials", userCredentials);

        // For demonstration purposes, print the user data
        System.out.println("User Registered - Username: " + username);

        // Redirect to a success page after registration
        response.sendRedirect("registration_success.html");
	}

}
