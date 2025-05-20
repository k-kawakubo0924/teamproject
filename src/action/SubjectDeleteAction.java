package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Subject;
import dao.SubjectDao;

public class SubjectDeleteAction {
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String cd = req.getParameter("cd");

        // 仮の学校情報をセッションから取得
        School school = (School) req.getSession().getAttribute("school");

        SubjectDao dao = new SubjectDao();
        Subject subject = dao.getCd(cd, school);

        req.setAttribute("subject", subject);
        req.getRequestDispatcher("/jsp/deleteSubject.jsp").forward(req, res);
    }
}
