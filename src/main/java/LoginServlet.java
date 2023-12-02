

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private Map<String, String> userCredentials; // In-memory storage for login credentials

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 // Retrieve username and password from the login form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Retrieve userCredentials from the ServletContext (ensure it's populated by RegistrationServlet)
        userCredentials = (Map<String, String>) getServletContext().getAttribute("userCredentials");

        // Check if the entered credentials exist in the userCredentials map
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            // Authentication successful
            // For demonstration, simply printing a success message
            System.out.println("Login successful for user: " + username);
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            // Redirect to a success page or perform further actions (e.g., user session management)
            response.sendRedirect("welcome.jsp?username");
        } else {
            // Authentication failed
            // For demonstration, simply printing an error message
            System.out.println("Login failed for user: " + username);

            // Redirect back to the login page with an error message
            response.sendRedirect("login.html?error=1");
        }
	}

}
