package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import dao.SubjectDao;
import tool.Action;

public class SubjectDeleteAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        School school = (School) session.getAttribute("school");
        if (school == null) {
            school = new School();
            school.setCd("oom");
            school.setName("仮の学校");
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

        request.setAttribute("subject", subject);

        // 削除確認画面に遷移
        return "/window/SubjectDelete.jsp";
    }
}
