package com.ajay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ajay.dto.Result;
import com.ajay.util.DBConnection;

public class ResultDAO {

    // Save Result
    public boolean saveResult(Result r) {
        boolean status = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO result(student_id,score,total) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, r.getStudentId());
            ps.setInt(2, r.getScore());
            ps.setInt(3, r.getTotal());

            int i = ps.executeUpdate();
            if (i > 0) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
