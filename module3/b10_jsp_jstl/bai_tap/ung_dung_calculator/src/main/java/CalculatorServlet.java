import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.InputMismatchException;

@WebServlet(name = "CalculatorServlet", urlPatterns ={"", "/calculate"})
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstNum = Integer.parseInt(request.getParameter("firstNumber"));
        double secondNum = Integer.parseInt(request.getParameter("secondNumber"));
        String operator = request.getParameter("operator");
        String err = "";
        double result = 0;
        try {
            switch (operator) {
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                case "*":
                    result = firstNum * secondNum;
                    break;
                case "/":
                    result = firstNum / secondNum;
                    break;
                default:
                    break;
            }
        } catch (ArithmeticException e) {
            err  ="Không chia cho 0";
        } catch (InputMismatchException e){
            err = "Nhập sai định dạng";
        } catch (Exception e) {
            err = "Đã có lỗi xảy ra";
        }

        request.setAttribute("firstNumber", firstNum);
        request.setAttribute("secondNumber", secondNum);
        request.setAttribute("result", result);
        request.setAttribute("operator",operator);
        request.setAttribute("err",err);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
