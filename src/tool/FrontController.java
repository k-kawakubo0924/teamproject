package tool;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, java.io.IOException {
        process(req, res);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, java.io.IOException {
        process(req, res);
    }

    private void process(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, java.io.IOException {
        try {
            String path = req.getServletPath(); // 例: "/login.do"
            String className = "scoremanager" + path.replace(".do", "Action");

            Class<?> c = Class.forName(className);
            Action action = (Action) c.getDeclaredConstructor().newInstance();
            String nextPage = action.execute(req, res);

            RequestDispatcher dispatcher = req.getRequestDispatcher(nextPage);
            dispatcher.forward(req, res);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

