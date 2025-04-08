package com.zaurtregulov;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDelete {
    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection= DriverManager.getConnection(DB_URL,USER,PWD);

            PreparedStatement statement= connection.prepareStatement(
                    "DELETE FROM students WHERE name=?"
            );

            statement.setString(1,"Zaur");
            int deletedRows=statement.executeUpdate();
            System.out.println("deletedRows: " +deletedRows);

            statement.close();


        } catch (SQLException e) {
          e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
