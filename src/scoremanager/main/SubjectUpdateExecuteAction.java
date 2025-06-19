package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Subject;
import dao.SubjectDao;
import tool.Action;

public class SubjectUpdateExecuteAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // ログイン中の学校情報を取得
        School school = (School) request.getSession().getAttribute("school");
        if (school == null) {
            school = new School();
            school.setCd("oom"); // ← 実際に存在する school_cd を指定
            request.getSession().setAttribute("school", school);
        }
        // パラメータ取得
        String cd = request.getParameter("cd");
        String name = request.getParameter("name");

        // 入力チェック（ここでは簡易的に）
        if (cd == null || name == null || name.trim().isEmpty()) {
            request.setAttribute("error", "科目名を入力してください。");
            return "SubjectUpdate.jsp";
        }

        // DAO経由で科目を取得し、更新
        SubjectDao dao = new SubjectDao();
        Subject subject = dao.getCd(cd, school);

        if (subject == null) {
            request.setAttribute("error", "該当する科目が見つかりません。");
            return "SubjectUpdate.jsp";
        }

        subject.setName(name);
        boolean updated = dao.update(subject);

        if (updated) {
            return "/window/SubjectUpdateResult.jsp"; // 成功した場合の遷移先
        } else {
            request.setAttribute("error", "更新に失敗しました。");
            return "SubjectUpdate.jsp";
        }
    }
}
