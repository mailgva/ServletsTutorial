package com.gorbatenko.servletstutorial;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Simple servlet that demonstrates Error handling.
 *
 * @author Eugene Suleimanov
 */

public class ErrorDemo extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer code = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String errorMssage = (String) request.getAttribute("javax.servlet.error.message");
        String exceptionType = (String) request.getAttribute("javax.servlet.error.exception_type");
        String requestURI = (String) request.getAttribute("javax.servlet.error.request_uri");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        String exception = (String) request.getAttribute("javax.servlet.error.exception");



        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String title = "Error Handling";
        String docType = "<!DOCTYPE html>";

        writer.println(docType + "<html>" +
                "<head>" +
                "<title>" + title + "</title>" +
                "</head>" +
                "<body>");

        writer.println("<h1>Error information</h1>");
        writer.println("Code: " + code + "<br/>");
        writer.println("Error Message: " + errorMssage + "<br/>");
        writer.println("Exception Type: " + exceptionType + "<br/>");
        writer.println("Request URI: " + requestURI + "<br/>");
        writer.println("Servlet Name: " + servletName + "<br/>");
        writer.println("Exception: " + exception + "<br/>");

        writer.println("</body>");
        writer.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

