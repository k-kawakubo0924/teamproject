package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;

public class SchoolDao {

    public List<School> findAll() throws Exception {
        List<School> list = new ArrayList<>();

        // H2 データベースへ接続（直書き）
        Connection conn = DriverManager.getConnection(
            "jdbc:h2:~/teamproject", "sa", ""
        );

        String sql = "SELECT cd, name FROM school";

        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            School school = new School();
            school.setCd(rs.getString("cd"));
            school.setName(rs.getString("name"));
            list.add(school);
        }

        // リソースを閉じる
        rs.close();
        stmt.close();
        conn.close();

        return list;
    }
}
