package com.exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDAO {
    // Data Access Object (DAO)

    // 입력
    public boolean addDept(DeptDTO deptDTO) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean resultFlag = false;

        try {
            conn = DBUtil.getConnection();

            String sql = "insert into dept(deptno,dname,loc) values (?,?,?)";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, deptDTO.getDeptno());
            ps.setString(2, deptDTO.getDname());
            ps.setString(3, deptDTO.getLoc());

            int count = ps.executeUpdate();

            System.out.println(count + "건 입력했습니다.");

            if (count > 0) {
                resultFlag = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 2. 닫아준다.
            DBUtil.close(conn, ps);
            return resultFlag;
        }
    }

    // 수정
    public int updateDept (DeptDTO deptDTO) {
        // 매개변수로 받아올 값이 너무 많아요.. 그럴때.. 어떻게??? -- 가방처럼 값을 담을 객체를 만들어서 사용함.
        //VO(Value Object), DTO(Data Transfer Object), Model, Entity
        Connection conn = null;
        PreparedStatement ps = null;
        int resultCount = 0;

        try{
            conn = DBUtil.getConnection();

            String sql = "update dept set dname = ?, loc=? where deptno = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1,deptDTO.getDname());
            ps.setString(2,deptDTO.getLoc());
            ps.setInt(3,deptDTO.getDeptno());

            int count = ps.executeUpdate();

            System.out.println(count+"건 수정했습니다.");

            resultCount = count;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 2. 닫아준다.
            DBUtil.close(conn,ps);
        }
        return resultCount;
    }

    // 삭제
    public boolean deleteDept(int deptno) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean resultFlag = false;

        try {
            conn = DBUtil.getConnection();

            String sql = "delete from dept where deptno = ?";

            ps = conn.prepareStatement(sql);

            ps.setInt(1,deptno);

            int count = ps.executeUpdate();

            System.out.println(count+"건 삭제했습니다.");

            if(count > 0) {
                resultFlag = true;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn,ps);
        }
        return resultFlag;
    }

    // 한건 조회
    public DeptDTO getDept(int deptno) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DeptDTO deptDTO = null;

        try {
            conn = DBUtil.getConnection();

            String sql = "select * from dept where deptno = ?";

            ps = conn.prepareStatement(sql);

            ps.setInt(1,deptno);

            rs = ps.executeQuery();

            if(rs.next()) {
                deptDTO = new DeptDTO();
                deptDTO.setDeptno(rs.getInt(1));
                deptDTO.setDname(rs.getString(2));
                deptDTO.setLoc(rs.getString(3));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn,ps,rs);
        }
        return deptDTO;
    }

    // 모두 조회
    public List<DeptDTO> getAllDept() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DeptDTO> deptDTOList = new ArrayList<>();

        try {
            conn = DBUtil.getConnection();

            String sql = "select * from dept";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while(rs.next()) {
                DeptDTO deptDTO = new DeptDTO();
                deptDTO.setDeptno(rs.getInt(1));
                deptDTO.setDname(rs.getString(2));
                deptDTO.setLoc(rs.getString(3));
                deptDTOList.add(deptDTO);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn,ps,rs);
        }
        return deptDTOList;
    }

    // 조건에 맞는 조회...

}
