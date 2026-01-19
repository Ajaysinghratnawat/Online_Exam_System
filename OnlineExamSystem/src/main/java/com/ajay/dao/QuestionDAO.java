package com.ajay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ajay.dto.Question;
import com.ajay.util.DBConnection;

public class QuestionDAO {
	
	public boolean addQuestion(Question q) {
	    boolean status = false;
	    try {
	        Connection con = DBConnection.getConnection();
	        String sql = "INSERT INTO question(question,option1,option2,option3,option4,correct_option) VALUES(?,?,?,?,?,?)";
	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, q.getQuestion());
	        ps.setString(2, q.getOption1());
	        ps.setString(3, q.getOption2());
	        ps.setString(4, q.getOption3());
	        ps.setString(5, q.getOption4());
	        ps.setInt(6, q.getCorrectOption());

	        int i = ps.executeUpdate();
	        if (i > 0) {
	            status = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return status;
	}


    // Fetch all questions
    public static List<Question> getAllQuestions() {
        List<Question> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM question";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Question q = new Question();
                q.setqId(rs.getInt("q_id"));
                q.setQuestion(rs.getString("question"));
                q.setOption1(rs.getString("option1"));
                q.setOption2(rs.getString("option2"));
                q.setOption3(rs.getString("option3"));
                q.setOption4(rs.getString("option4"));
                q.setCorrectOption(rs.getInt("correct_option"));

                list.add(q);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Question getQuestionById(int id) {
        Question q = null;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM question WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                q = new Question();
            }
        } catch(Exception e) { e.printStackTrace(); }
        return q;
    }

    public void updateQuestion(Question q) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE questions SET question=?, option1=?, option2=?, option3=?, option4=?, correct_option=? WHERE id=?"
            );
            ps.setString(1, q.getQuestion());
            ps.setString(2, q.getOption1());
            ps.setString(3, q.getOption2());
            ps.setString(4, q.getOption3());
            ps.setString(5, q.getOption4());
            ps.setInt(6, q.getCorrectOption());
            ps.setInt(7, q.getqId());
            ps.executeUpdate();
        } catch(Exception e) { e.printStackTrace(); }
    }

    public void deleteQuestion(int id) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM question WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch(Exception e) { e.printStackTrace(); }
    }

}
