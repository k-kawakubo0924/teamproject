package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDao;
import tool.Action;


public class StudentListAction implements Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        try {
            // StudentDao を使って学生一覧を取得
            StudentDao studentDao = new StudentDao();
            List<Student> studentList = studentDao.findAll();

            // リクエストスコープにデータをセット
            req.setAttribute("studentList", studentList);

            // 表示用JSPへフォワード
            return "/window/StudentList.jsp";

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "学生一覧の取得に失敗しました。");
            return "error.jsp";  // エラーページがない場合は一時的に studentList.jsp にしてもOK
        }
    }
}
