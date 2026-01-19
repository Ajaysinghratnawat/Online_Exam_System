package com.ajay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ajay.dto.Student;
import com.ajay.util.DBConnection;

public class StudentDAO {

    // Register Student
    public boolean registerStudent(Student s) {
        boolean status = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO student(name,email,password) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPassword());

            int i = ps.executeUpdate();
            if (i > 0) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // Login Student
    public Student loginStudent(String email, String password) {
        Student s = null;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM student WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
