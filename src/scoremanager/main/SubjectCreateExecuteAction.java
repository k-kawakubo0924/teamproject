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

        try {
            // セッションから学校コードを取得
            School school = (School) request.getSession().getAttribute("school");
            String schoolCd;
            if (school == null) {
                schoolCd = "oom"; // 仮の学校コード
                school = new School();
                school.setCd(schoolCd);
            } else {
                schoolCd = school.getCd();
            }

            // フォームから科目コードと科目名を取得
            String subjectCode = request.getParameter("cd");
            String subjectName = request.getParameter("name");

            // Subjectオブジェクトにセット
            Subject subject = new Subject();
            subject.setCd(subjectCode);
            subject.setName(subjectName);
            subject.setSchool(school);

            // DAOを使って登録
            SubjectDao dao = new SubjectDao();
            boolean success = dao.insert(subject);

            if (!success) {
                System.out.println("Insert failed for subject: " + subject.getCd() + ", " + subject.getName());
                request.setAttribute("errorMessage", "科目登録に失敗しました。");
                return "/window/error.jsp";
            }

            // 登録成功したら科目一覧画面へリダイレクト
            return "window/SubjectCreateResult.jsp";

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "科目登録に失敗しました。（例外）");
            return "/window/error.jsp";
        }
    }
}
