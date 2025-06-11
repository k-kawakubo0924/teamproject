package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;

public class SubjectDao extends DAO {

    /**
     * 指定されたコードと学校コードに該当する科目を取得
     */
    public Subject getCd(String cd, School school) {
        Subject subject = null;
        try (Connection con = getConnection()) {
            String sql = "SELECT * FROM subject WHERE cd=? AND school_cd=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cd);
            stmt.setString(2, school.getCd());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                subject = new Subject();
                subject.setCd(rs.getString("cd"));
                subject.setName(rs.getString("name"));
                subject.setSchool(school);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return subject;
    }

    /**
     * 科目を削除
     */
    public boolean delete(Subject subject) {
        try (Connection con = getConnection()) {
            String sql = "DELETE FROM subject WHERE cd=? AND school_cd=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, subject.getCd());
            stmt.setString(2, subject.getSchool().getCd());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 指定した学校コードのすべての科目を取得する
     */
    public List<Subject> getAll(String schoolCd) {
        List<Subject> list = new ArrayList<>();

        try (Connection con = getConnection()) {
            String sql = "SELECT * FROM subject WHERE school_cd = ? ORDER BY cd";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, schoolCd);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Subject subject = new Subject();
                subject.setCd(rs.getString("cd"));
                subject.setName(rs.getString("name"));

                School school = new School();
                school.setCd(rs.getString("school_cd"));
                subject.setSchool(school);

                list.add(subject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 科目を更新する
     */
    public boolean update(Subject subject) {
        try (Connection con = getConnection()) {
            String sql = "UPDATE subject SET name=? WHERE cd=? AND school_cd=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, subject.getName());
            stmt.setString(2, subject.getCd());
            stmt.setString(3, subject.getSchool().getCd());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 新規登録を行う
     */
    public boolean insert(Subject subject) {
        try (Connection con = getConnection()) {
            String sql = "INSERT INTO subject (cd, name, school_cd) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, subject.getCd());
            stmt.setString(2, subject.getName());
            stmt.setString(3, subject.getSchool().getCd());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 新規登録または更新を行う
     * すでに存在する場合は更新、存在しなければ登録する
     */
    public boolean save(Subject subject) {
        // 存在チェック
        Subject existing = getCd(subject.getCd(), subject.getSchool());
        if (existing == null) {
            // 新規登録
            return insert(subject);
        } else {
            // 更新
            return update(subject);
        }
    }
}
