package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Student;
import dao.SchoolDao;
import dao.StudentDao;
import tool.Action;

public class StudentUpdateAction implements Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // パラメータから学生番号を取得
        String no = request.getParameter("no");

        // 学生リストから該当学生を探す
        StudentDao studentDao = new StudentDao();
        List<Student> studentList = studentDao.findAll();
        Student student = null;
        for (Student s : studentList) {
            if (s.getNo().equals(no)) {
                student = s;
                break;
            }
        }

        if (student == null) {
            throw new Exception("該当する学生が見つかりません。");
        }

        // 学校一覧を取得
        SchoolDao schoolDao = new SchoolDao();
        List<School> schoolList = schoolDao.findAll();

        // JSPに渡すデータをセット
        request.setAttribute("student", student);
        request.setAttribute("schoolList", schoolList);

        // 更新フォーム画面へ
        return "/window/StudentUpdate.jsp";
    }
}
