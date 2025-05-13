package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.ClassNum;
import bean.School;

public class ClassNumDao extends DAO {

    // 🔹 学校ごとのクラス一覧を取得
    public List<ClassNum> getClassNumsBySchool(String schoolCd) throws Exception {
        List<ClassNum> list = new ArrayList<>();

        Connection conn = getConnection();
        try {
            String sql = "SELECT * FROM class_num WHERE school_cd = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, schoolCd);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ClassNum cn = new ClassNum();
                cn.setClassNum(rs.getString("class_num"));

                // 学校情報をセット（SchoolのBeanが必要）
                School s = new School();
                s.setCd(rs.getString("school_cd"));
                cn.setSchool(s);

                list.add(cn);
            }

        } finally {
            conn.close();
        }

        return list;
    }

    // 🔹 クラスの追加
    public boolean insertClassNum(ClassNum cn) throws Exception {
        Connection conn = getConnection();
        try {
            String sql = "INSERT INTO class_num (class_num, school_cd) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cn.getClassNum());
            stmt.setString(2, cn.getSchool().getCd());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } finally {
            conn.close();
        }
    }

    // 🔹 クラスの削除
    public boolean deleteClassNum(String classNum, String schoolCd) throws Exception {
        Connection conn = getConnection();
        try {
            String sql = "DELETE FROM class_num WHERE class_num = ? AND school_cd = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, classNum);
            stmt.setString(2, schoolCd);

            int rows = stmt.executeUpdate();
            return rows > 0;

        } finally {
            conn.close();
        }
    }
}
