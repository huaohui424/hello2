package com.util;

import java.sql.*;

public class Utils {
    private static Connection connection;
    private static  String url="jdbc:mysql://localhost:3306/demo";
    private static String username="root";
    private static String password="root";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){return connection;}

    public static int deleteDept(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = null;
        int n = 0;
        preparedStatement = connection.prepareStatement(sql);
        n = preparedStatement.executeUpdate();
        return n;
    }
}
