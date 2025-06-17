package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Subject;
import dao.SubjectDao;
import tool.Action;

public class SubjectListAction implements Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        try {
            SubjectDao subjectDao = new SubjectDao();

            // セッションからschoolを取得し、nullチェック
            School school = (School) req.getSession().getAttribute("school");
            String schoolCd;
            if (school == null) {
                // セッションにschoolがない場合の仮の学校コード
                schoolCd = "oom";
            } else {
                schoolCd = school.getCd();
            }

            List<Subject> subjectList = subjectDao.getAll(schoolCd);
            System.out.println("取得件数: " + (subjectList == null ? 0 : subjectList.size()));

            req.setAttribute("subjectList", subjectList);

            return "/window/SubjectList.jsp";

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "科目一覧の取得に失敗しました。");
            return "/window/error.jsp";
        }
    }
}
