package com.exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
    public static void main(String[] args) {
        // 1. 필요한 객체를 선언한다.
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            // 3. 접속
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3307/tekitexam";
            String user = "rjsgud1956";
            String password = "root1234";

            conn = DriverManager.getConnection(dbUrl,user,password);
            conn.setAutoCommit(false);

            // 4. 쿼리작성
              String sql = "insert into dept(deptno,dname,loc) values (?,?,?)";
//            String sql = "insert into dept(deptno,dname,loc) values (60,'개발부','서울')";
//            sql = "update dept set dname = '홍보부' where deptno = 60";

            ps = conn.prepareStatement(sql);

            ps.setInt(1,90);
            ps.setString(2,"식품부");
            ps.setString(3,"양주");

            // 5. 실행.
            int count = ps.executeUpdate();

            System.out.println(count+"건 입력했습니다.");

            conn.commit(); // autocommit false이면 commit 해줘야한다.
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // 2. 닫아준다.
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
