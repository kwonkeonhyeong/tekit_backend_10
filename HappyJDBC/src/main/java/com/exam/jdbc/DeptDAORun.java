package com.exam.jdbc;

import java.util.List;

public class DeptDAORun {
    public static void main(String[] args) {
        DeptDAO deptDAO = new DeptDAO();
        DeptDTO deptDTO = new DeptDTO();

        deptDTO.setDeptno(110);
        deptDTO.setDname("lion");
        deptDTO.setLoc("대구");
        boolean resultFlag = deptDAO.addDept(deptDTO);

        if(resultFlag) {
            System.out.println("입력성공!!");
        } else {
            System.out.println("입력 실패!!");
        }

        DeptDTO deptDTO2 = new DeptDTO();

        deptDTO2.setDeptno(90);
        deptDTO2.setDname("lion");
        deptDTO2.setLoc("서울");
        int resultCount = deptDAO.updateDept(deptDTO2);
        System.out.println(resultCount);


//        deptDAO.deleteDept(100);
        deptDAO.deleteDept(110);
        System.out.println(deptDAO.getDept(90).toString());

        List<DeptDTO> allDept = deptDAO.getAllDept();
        allDept.forEach(dto -> System.out.println(dto.toString()));
    }
}
