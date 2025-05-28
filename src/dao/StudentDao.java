package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;

public class StudentDao extends DAO{

    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;



        try {
            // DB接続（直書き）
            conn = getConnection();

            // SQL文（studentとschoolをJOIN）
            String sql = "SELECT s.no, s.name, s.ent_year, s.is_attend, s.class_num, sc.cd, sc.name AS school_name " +
                         "FROM student s " +
                         "JOIN school sc ON s.school_cd = sc.cd";

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

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
        } catch (SQLException e) {
            // SQL例外が発生した場合のログ出力
//            logger.log(Level.SEVERE, "データベース操作中にエラーが発生しました。", e);
            throw new RuntimeException("データベース操作中にエラーが発生しました。", e);
        } catch (Exception e) {
            // その他の例外が発生した場合
//            logger.log(Level.SEVERE, "不明なエラーが発生しました。", e);
            throw new RuntimeException("不明なエラーが発生しました。", e);
        } finally {
            // リソースのクローズ
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
//                logger.log(Level.WARNING, "リソースのクローズに失敗しました。", e);
            }
        }

        return list;
    }

    public int insertStudent(Student student) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;

        try {
            conn = getConnection();  // Exception も発生する可能性あり
            String sql = "INSERT INTO student (no, name, ent_year, is_attend, class_num, school_cd) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, student.getNo());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getEntYear());
            stmt.setBoolean(4, student.isAttend());
            stmt.setString(5, student.getClassNum());
            stmt.setString(6, student.getSchool().getCd());

            result = stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("SQL実行中にエラーが発生しました。", e);
        } catch (Exception e) {
            // getConnection() で例外が出た場合に対応
            throw new RuntimeException("データベース接続に失敗しました。", e);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                // ログなどに出すのが望ましい
            }
        }

        return result;
    }
}
