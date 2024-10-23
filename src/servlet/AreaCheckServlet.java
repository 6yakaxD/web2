package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Point;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        ArrayList<Point> history = (ArrayList<Point>) session.getAttribute("history");
        if (history == null) {
            history = new ArrayList<>();
        }

        //startTime
        long startTime = System.nanoTime();
        //x
        String xStr = req.getParameter("x");
        BigDecimal xBigDecimal = new BigDecimal(xStr);
        xBigDecimal = xBigDecimal.setScale(2, RoundingMode.HALF_UP);
        double x = xBigDecimal.doubleValue();
        //y
        String yStr = req.getParameter("y");
        BigDecimal yBigDecimal = new BigDecimal(yStr);
        yBigDecimal = yBigDecimal.setScale(2, RoundingMode.HALF_UP);
        double y = yBigDecimal.doubleValue();
        //r
        String rStr = req.getParameter("r");
        BigDecimal rBigDecimal = new BigDecimal(rStr);
        rBigDecimal = rBigDecimal.setScale(2, RoundingMode.HALF_UP);
        double r = rBigDecimal.doubleValue();
        //endTime
        long endTime = System.nanoTime();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //dateTime
        String formattedDateTime = now.format(formatter);
        Point point = new Point(x, y, r, formattedDateTime, (((endTime - startTime) / 1_000_000.0) + " ms"));

        history.add(point);
        session.setAttribute("history", history);

        String key = req.getParameter("key");
        if ("svg".equals(key)) {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<tr><td>" + point.getX() + "</td><td>" + point.getY() + "</td><td>" + point.getR() + "</td><td>" + point.getStatus() + "</td><td>" + point.getLocalTime() + "</td><td>" + point.getExecutionTime() + "</td></tr>");
            out.close();
        } else if ("btn".equals(key)) {
            req.getRequestDispatcher("/result.jsp").forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid key parameter");
        }

    }
}