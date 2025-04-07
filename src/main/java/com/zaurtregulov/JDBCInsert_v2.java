package com.zaurtregulov;

import java.sql.*;

public class JDBCInsert_v2 {
    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        Connection connection = null;
        Student student = new Student("Leo", "Farrel", 8.4);
        try {
            connection= DriverManager.getConnection(DB_URL,USER,PWD);
            Statement statement=connection.createStatement();
            String sqlQuery="INSERT INTO students(name, surname, avg_grade) VALUES" +
                    "('" +
                    student.getName() +
                    "', '"+
                    student.getSurname() +
                    "', "+
                    student.getAvgGrade()+
                    ")";
//"INSERT INTO students(name, surname, avg_grade) VALUES ('Leo','Farrel', 8.4)");

//            String sqlQuery="INSERT INTO students(name, surname, avg_grade) VALUES" +
//                    "('Julia','Dean',8.7)";



            statement.executeUpdate(sqlQuery);

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
