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
            String entYearStr = student.getEntYear();
            if (entYearStr != null && !entYearStr.trim().isEmpty()) {
                stmt.setInt(3, Integer.parseInt(entYearStr));
            } else {
                throw new IllegalArgumentException("入学年度が未入力です。");
            }

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

    public boolean existsStudent(String studentNo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            String sql = "SELECT COUNT(*) FROM student WHERE no = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentNo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            throw new RuntimeException("学生番号の重複チェック中にエラーが発生しました。", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                // ログ出力など
            }
        }

        return false;
    }
    /**
     * 【追加メソッド】学生情報を更新するメソッド
     * @param student 更新する学生情報を持つStudentオブジェクト
     * @return 更新件数（成功すれば1）
     */
    public int updateStudent(Student student) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;

        try {
            conn = getConnection();  // DB接続

            // 更新用SQL文。no（学生番号）を条件に各カラムを更新
            String sql = "UPDATE student SET name = ?, ent_year = ?, is_attend = ?, class_num = ?, school_cd = ? WHERE no = ?";
            stmt = conn.prepareStatement(sql);

            // パラメータセット
            stmt.setString(1, student.getName());

            String entYearStr = student.getEntYear();
            if (entYearStr != null && !entYearStr.trim().isEmpty()) {
                stmt.setInt(2, Integer.parseInt(entYearStr));
            } else {
                throw new IllegalArgumentException("入学年度が未入力です。");
            }

            stmt.setBoolean(3, student.isAttend());
            stmt.setString(4, student.getClassNum());
            stmt.setString(5, student.getSchool().getCd());

            // WHERE句の条件（更新対象の学生番号）
            stmt.setString(6, student.getNo());

            // SQL実行（更新件数を返す）
            result = stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("学生情報の更新中にエラーが発生しました。", e);
        } catch (Exception e) {
            throw new RuntimeException("データベース接続に失敗しました。", e);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                // クローズ失敗時はログなどに記録推奨
            }
        }

        return result;
    }
    public Student findByNo(String no) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Student student = null;

        try {
            conn = getConnection();
            String sql = "SELECT s.no, s.name, s.ent_year, s.is_attend, s.class_num, sc.cd, sc.name AS school_name " +
                         "FROM student s JOIN school sc ON s.school_cd = sc.cd WHERE s.no = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, no);
            rs = stmt.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setNo(rs.getString("no"));
                student.setName(rs.getString("name"));
                student.setEntYear(rs.getString("ent_year"));
                student.setAttend(rs.getBoolean("is_attend"));
                student.setClassNum(rs.getString("class_num"));

                School school = new School();
                school.setCd(rs.getString("cd"));
                school.setName(rs.getString("school_name"));
                student.setSchool(school);
            }
        } catch (Exception e) {
            throw new RuntimeException("1件取得中にエラー", e);
        } finally {
            try { if (rs != null) rs.close(); if (stmt != null) stmt.close(); if (conn != null) conn.close(); } catch (SQLException e) {}
        }

        return student;
    }



}
