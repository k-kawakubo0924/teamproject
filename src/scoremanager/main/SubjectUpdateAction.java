package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import dao.SubjectDao;
import tool.Action;

public class SubjectUpdateAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // セッション取得を一度だけに修正
        HttpSession session = request.getSession();
        School school = (School) session.getAttribute("school");  // 修正: ここを session から取得するように

        if (school == null) {
            school = new School();
            school.setCd("oom"); // 実際のDBに登録されている school_cd を指定してください
            session.setAttribute("school", school);
        }

        // パラメータから科目コードを取得
        String cd = request.getParameter("cd");

        // Daoで該当科目を取得
        SubjectDao dao = new SubjectDao();
        Subject subject = dao.getCd(cd, school);

        // JSPに渡す
        request.setAttribute("subject", subject);

        // 編集画面に遷移
        return "/window/SubjectUpdate.jsp";
    }
}
