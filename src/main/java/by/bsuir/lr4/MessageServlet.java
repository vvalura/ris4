package by.bsuir.lr4;


import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "messagesServlet", value = "/messages")
public class MessageServlet extends HttpServlet {

    @EJB
    private MessageProducer messageProducer;


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        response.setContentType("text/html");
        String message = request.getParameter("message");

        messageProducer.sendMessage(message);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("in.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("in.jsp");
        requestDispatcher.forward(request, response);
    }
}