import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslationServlet", urlPatterns = "/translate")
public class TranslationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        Map<String,String > dictionary = new HashMap<>();
        dictionary.put("cat","con mèo");
        dictionary.put("dog","con chó");
        dictionary.put("animal","động vật");
        dictionary.put("computer", "máy tính");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        String search = request.getParameter("txtSearch");

        String result = dictionary.get(search);
        if(result != null) {
            writer.println(search + " nghĩa là " + result);
        } else {
            writer.println("not found");
        }
        writer.println("</html>");
    }
}
