import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long startTime = System.nanoTime();

        String xStr = req.getParameter("x");
        BigDecimal xBigDecimal = new BigDecimal(xStr);
        xBigDecimal = xBigDecimal.setScale(2, RoundingMode.HALF_UP);
        double x = xBigDecimal.doubleValue();

        String yStr = req.getParameter("y");
        BigDecimal yBigDecimal = new BigDecimal(yStr);
        yBigDecimal = yBigDecimal.setScale(2, RoundingMode.HALF_UP);
        double y = yBigDecimal.doubleValue();

        String rStr = req.getParameter("r");
        BigDecimal rBigDecimal = new BigDecimal(rStr);
        rBigDecimal = rBigDecimal.setScale(2, RoundingMode.HALF_UP);
        double r = rBigDecimal.doubleValue();

        var point = new Point(x, y, r);
        long endTime = System.nanoTime();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        resp.setContentType("text/html;charset=UTF-8");
        StringBuilder htmlResponse = new StringBuilder();
        htmlResponse.append("<tr>");
        htmlResponse.append("<td>").append(x).append("</td>");
        htmlResponse.append("<td>").append(y).append("</td>");
        htmlResponse.append("<td>").append(r).append("</td>");
        htmlResponse.append("<td>").append(point.getStatus()).append("</td>");
        htmlResponse.append("<td>").append(formattedDateTime).append("</td>");
        htmlResponse.append("<td>").append((endTime - startTime) / 1e6).append(" ms").append("</td>");
        htmlResponse.append("</tr>");

        try (PrintWriter writer = resp.getWriter()) {
            writer.write(htmlResponse.toString());
        }
    }
}