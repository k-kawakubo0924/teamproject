package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;

public class StudentDao {

    public List<Student> findAll() throws Exception {
        List<Student> list = new ArrayList<>();

        // DB接続（直書き）
        Connection conn = DriverManager.getConnection(
            "jdbc:h2:~/teamproject", "sa", ""
        );

        // SQL文（studentとschoolをJOIN）
        String sql = "SELECT s.no, s.name, s.ent_year, s.is_attend, s.class_num, sc.cd, sc.name AS school_name " +
                     "FROM student s " +
                     "JOIN school sc ON s.school_cd = sc.cd";

        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Student student = new Student();
            student.setNo(rs.getString("no"));
            student.setName(rs.getString("name"));
            student.setEntYear(rs.getString("ent_year"));
            student.setAttend(rs.getBoolean("is_attend"));
            student.setClassNum(rs.getString("class_num"));

            School school = new School();
            school.setCd(rs.getString("cd"));
            school.setName(rs.getString("school_name"));

            student.setSchool(school);

            list.add(student);
        }

        rs.close();
        stmt.close();
        conn.close();

        return list;
    }
}
