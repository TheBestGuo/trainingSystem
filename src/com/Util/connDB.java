package com.Util;
import java.sql.*;
import java.util.Properties;

public class connDB {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    private static Properties pr = new Properties();
    private connDB() {}
    static{
        try{
            pr.load(connDB.class.getClassLoader().getResourceAsStream("dbLoad.properties"));
            driver=pr.getProperty("driver");
            url=pr.getProperty("url");
            user=pr.getProperty("user");
            password=pr.getProperty("password");
            Class.forName(driver);
        }catch(Exception e){
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }

    public static void free(ResultSet rs,PreparedStatement pstmt,Statement st,Connection conn){
        try{
            if(rs!=null)rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(st!=null)st.close();
            }catch(SQLException e){e.printStackTrace();}
            finally{
                try {
                    if(pstmt!=null)pstmt.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }finally {
                    if(conn!=null)
                        try{conn.close();}
                        catch(SQLException e){e.printStackTrace();}
                }
            }
        }

    }
}
