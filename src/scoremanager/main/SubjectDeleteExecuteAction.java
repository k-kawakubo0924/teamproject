package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import dao.SubjectDao;
import tool.Action;

public class SubjectDeleteExecuteAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        School school = (School) session.getAttribute("school");
        if (school == null) {
            school = new School();
            school.setCd("oom");       // DBに実際に存在するコードに合わせてください
            school.setName("仮の学校");  // 任意
            session.setAttribute("school", school);
        }

        String cd = request.getParameter("cd");
        if (cd == null || cd.isEmpty()) {
            return "/error.jsp";
        }

        SubjectDao dao = new SubjectDao();
        Subject subject = dao.getCd(cd, school);

        if (subject == null) {
            return "/error.jsp";
        }

        boolean deleted = dao.delete(subject);

        if (deleted) {
            // 削除成功なら一覧へ
            return "/window/SubjectDeleteResult.jsp";
        } else {
            // 削除失敗ならエラーへ
            return "/error.jsp";
        }
    }
}
