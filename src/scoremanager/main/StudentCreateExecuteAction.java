package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Student;
import dao.StudentDao;
import tool.Action;

public class StudentCreateExecuteAction implements Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.setCharacterEncoding("UTF-8");

        String admissionYear = request.getParameter("admission_year");
        System.out.println("DEBUG: admissionYear=" + admissionYear);
        String studentNumber = request.getParameter("student_number");
        System.out.println("studentNumber=" + studentNumber);
        String name = request.getParameter("name");
        String className = request.getParameter("class");

        // ここにチェックを追加
        if (admissionYear == null || admissionYear.trim().isEmpty()) {
            request.setAttribute("error", "入学年度を選択してください。");
            return "student/StudentCreate.jsp";
        }

        // 必要なら他の入力チェックも追加
        if (studentNumber == null || studentNumber.trim().isEmpty()) {
            request.setAttribute("error", "学生番号を入力してください。");
            return "student/StudentCreate.jsp";
        }
        if (name == null || name.trim().isEmpty()) {
            request.setAttribute("error", "氏名を入力してください。");
            return "student/StudentCreate.jsp";
        }

        StudentDao dao = new StudentDao();
        if (dao.existsStudent(studentNumber)) {
        	request.setAttribute("error","この学生番号は既に登録されています。");
        	return "student/StudentCreate.jsp";
        }

        Student student = new Student();
        student.setNo(studentNumber);
        student.setName(name);
        student.setEntYear(admissionYear);
        student.setClassNum(className);
        student.setAttend(true);

        School school = new School();
        school.setCd("oom");
        student.setSchool(school);


        int result = dao.insertStudent(student);

        if (result > 0) {
            // 登録成功時、一覧表示のアクションを呼び出す
            return "window/StudentCreateResult.jsp";
        } else {
            // 登録失敗時は再入力画面へ戻す
            request.setAttribute("error", "登録に失敗しました。");
            return "student/StudentCreate.jsp";
        }
    }
}
