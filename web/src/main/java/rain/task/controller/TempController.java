package rain.task.controller;

import common.Common;
import rain.beans.SimpleBean;
import raing.common.servise.ComputeService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebServlet("/hello")
public class TempController extends HttpServlet {
    @EJB(name = "SimpleEJB")
    private SimpleBean simpleBean;
    @EJB
    private ComputeService computeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.println("<html><body>");
        out.println("<p>Servlet says hey.</p>");
        Common common = new Common();
        out.println("<p>" + common.sayHello() + "</p>");
        out.println("<p>" + simpleBean.sayHello() + "</p>");
        out.println("<p> For array [3,2,1,1,2,3]  </p>");
        out.println("<p>" + computeService.computeVolumeOfWater(new int[]{3,2,1,1,2,3}) + "</p>");

        out.println("</body></html>");
        out.flush();
    }
}
