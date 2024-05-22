package org.example.springmvc.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;
import org.springframework.web.servlet.View;

public class MyCustomView implements View {
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType(getContentType());
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("<h1>Custom View Content</h1>");
        out.print("<p>my custom view haha</p>");
        out.print("</body><html>");
    }
}
