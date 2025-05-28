package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Student;
import dao.StudentDao;
import tool.Action;

public class StudentCreateAction implements Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.setCharacterEncoding("UTF-8");

        String admissionYear = request.getParameter("admission_year");
        String studentNumber = request.getParameter("student_number");
        System.out.println("studentNumber=" + studentNumber);
        String name = request.getParameter("name");
        String className = request.getParameter("class");

        Student student = new Student();
        student.setNo(studentNumber);
        student.setName(name);
        student.setEntYear(admissionYear);
        student.setClassNum(className);
        student.setAttend(true);

        School school = new School();
        school.setCd("01");
        student.setSchool(school);

        StudentDao dao = new StudentDao();
        int result = dao.insertStudent(student);

        if (result > 0) {
            // 登録成功時、一覧表示のアクションを呼び出す
            return "student-list.action";
        } else {
            // 登録失敗時は再入力画面へ戻す
            request.setAttribute("error", "登録に失敗しました。");
            return "student/StudentCreate.jsp";
        }
    }
}
