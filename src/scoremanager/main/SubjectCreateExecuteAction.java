package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Subject;
import dao.SubjectDao;
import tool.Action;

public class SubjectCreateExecuteAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");

        // フォームから送られたデータを取得
        String cd = request.getParameter("cd");
        String name = request.getParameter("name");

        // セッションから学校情報を取得
        School school = (School) request.getSession().getAttribute("school");

        // Subjectインスタンスを作成してセット
        Subject subject = new Subject();
        subject.setCd(cd);
        subject.setName(name);
        subject.setSchool(school);

        // DAOを使って保存
        SubjectDao dao = new SubjectDao();
        boolean success = dao.save(subject);

        // 成功していれば一覧画面にリダイレクト、失敗時はエラーメッセージなどをセット
        if (success) {
            return "SubjectList.action";
        } else {
            request.setAttribute("error", "登録に失敗しました。");
            return "window/subjectCreate.jsp";
        }
    }
}
