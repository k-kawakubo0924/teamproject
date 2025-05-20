package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Subject;
import dao.SubjectDao;

public class SubjectDeleteExecuteAction {
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String cd = req.getParameter("subjectId");
        School school = (School) req.getSession().getAttribute("school");

        Subject subject = new Subject();
        subject.setCd(cd);
        subject.setSchool(school);

        SubjectDao dao = new SubjectDao();
        boolean result = dao.delete(subject);

        if (result) {
            res.sendRedirect("index.jsp"); // 削除成功後のリダイレクト
        } else {
            req.setAttribute("error", "削除に失敗しました。");
            req.getRequestDispatcher("/jsp/deleteSubject.jsp").forward(req, res);
        }
    }
}
