package com.zaurtregulov;

import java.sql.*;
import java.util.Scanner;

public class JDBCUpdate {
    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection= DriverManager.getConnection(DB_URL,USER,PWD);

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter name: ");
            String entredName=scanner.nextLine();

//            Statement statement=connection.createStatement();
//            String sqlQuery="UPDATE students SET avg_grade=5.2"+
//                    "WHERE name='"+entredName+"'";
//            statement.executeUpdate(sqlQuery);
//
//            statement.close();


            PreparedStatement statement= connection.prepareStatement(
                    "UPDATE students SET avg_grade=7.5 WHERE name=?");
            statement.setString(1,entredName);
            statement.executeUpdate();

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
