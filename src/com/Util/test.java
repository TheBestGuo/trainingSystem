package com.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class test {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    public void test123() {
        try {
            conn = connDB.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM admin;");
            rs = pstmt.executeQuery();
            if(rs.next())
            {
                System.out.println("oxxxxxxx!");
            }
        }catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
}
