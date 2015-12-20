package com.jdbc.dbutils;

import com.jdbc.dbutils.domain.UserInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 孔轩志 on 2015/12/20.
 */
public class main {
    public static void main(String[] args) {
        JdbcUtils2 jdbc = new JdbcUtils2();
        jdbc.getConnection();

        String sql = "select * from stu";
        String sql1 = "insert into stu values(5,?,?)";
        List<Object> params = new ArrayList<Object>();
        params.add("吴芳");
        params.add("xiaowu");
        try {
            boolean result1 = jdbc.updateByPreparedStatement(sql1,params);
            System.out.println(result1);

            List<Map<String,Object>> result = jdbc.findMoreResult(sql, null);
            System.out.println(result);

            UserInfo model = jdbc.findSimpleRefResult(sql, null, UserInfo.class);
            System.out.println(model.toString());

            List<UserInfo> models = jdbc.findMoreRefResult(sql,null,UserInfo.class);
            System.out.println(models.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            jdbc.releaseConn();
        }
    }
}
