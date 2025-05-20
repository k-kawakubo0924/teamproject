package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.School;
import bean.Subject;

public class SubjectDao extends DAO {
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
}