package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Student;
import dao.StudentDao;
import tool.Action;

public class StudentUpdateExecuteAction implements Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // リクエストパラメータの取得（フォームから送信されたデータ）
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String entYear = request.getParameter("admissionYear");
        String isAttendStr = request.getParameter("is_attend");
        String classNum = request.getParameter("class");
        String schoolCd = "oom";

        // 入力値の検証（必要に応じてバリデーション追加可能）

        // Booleanの変換
        boolean isAttend = "true".equals(isAttendStr) || "1".equals(isAttendStr) || "on".equals(isAttendStr);

        System.out.println(isAttend);

        // Student オブジェクトに詰め直す
        Student student = new Student();
        student.setNo(no);
        student.setName(name);
        student.setEntYear(entYear);
        student.setAttend(isAttend);
        student.setClassNum(classNum);

        System.out.println(student.getName());

        School school = new School();
        school.setCd(schoolCd);
        student.setSchool(school);
        System.out.println(school);
        // 更新処理実行
        StudentDao studentDao = new StudentDao();
        int updated = studentDao.updateStudent(student);

        System.out.println(updated);

        // 結果のセット（成功・失敗など）
        if (updated > 0) {
            request.setAttribute("message", "学生情報を更新しました。");
        } else {
            request.setAttribute("message", "学生情報の更新に失敗しました。");
        }

        request.setAttribute("admissionYear", entYear);
        request.setAttribute("studentId", no);

        // 完了後、学生一覧画面へ
        request.setAttribute("message","更新が完了しました。");
        return "/window/StudentUpdateResult.jsp";
    }
}
