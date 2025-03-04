package gr.aueb.cf.schoolapp.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;

public class DBUtil {

    private static final BasicDataSource ds = new BasicDataSource();
    private static Connection connection;

    static {
        ds.setUrl("jdbc:mysql://localhost:3306/school7dbpro?serverTimezone=UTC");
        ds.setUsername("user7pro");
        ds.setPassword(System.getenv("PASSWD_USER7"));
    }

    private DBUtil(){

    }
}
