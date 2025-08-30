package com.practice.algo.ds;

import java.util.*;

/**
 * team maintains the employee directory
 * -> there are groups and departments.
 * -> find the closest parent group given target set of employees.
 */
public class CommonGroupAtlassian {

    Map<String, String> map = new HashMap<>();

    String commonGroupName = "";

    public String findCommonGroup(TreeNode root, Set<String> employeeNames) {
        //basic validations
        if (root == null) {
            return "";
        }
        validate(employeeNames);

        // DFS
        dfs(root, employeeNames);
        return commonGroupName;
    }

    private static void validate(Set<String> employeeNames) {
        if (employeeNames == null || employeeNames.isEmpty()) {
            throw new RuntimeException("Minimum 2 employees should be in the input");
        }
        if (employeeNames.size() == 1) {
            throw new RuntimeException("Minimum 2 employees should be in the input");
        }
    }

    public int dfs(TreeNode node, Set<String> employeeNames) { // [mona, lisa]
        if (!commonGroupName.isEmpty()) {
            return 0;
        }
        int countOfEmployeesFromSubDepartments = 0;
        for (TreeNode subDepartment : node.subDepartments) {// 1
            countOfEmployeesFromSubDepartments = countOfEmployeesFromSubDepartments +
                    dfs(subDepartment, employeeNames);
            if (!commonGroupName.isEmpty()) {
                return 0;
            }
        }
        int countOfEmployeeInCurrNode = 0;
        for (String employeeName : node.employeeNames) {
            if (employeeNames.contains(employeeName)) {
                countOfEmployeeInCurrNode++;
            }
        }
        if (countOfEmployeeInCurrNode + countOfEmployeesFromSubDepartments == employeeNames.size()) {
            commonGroupName = node.departmentName;
        }
        return countOfEmployeeInCurrNode + countOfEmployeesFromSubDepartments;
    }


    public static class TreeNode {
        String departmentName;
        List<TreeNode> subDepartments;
        List<String> employeeNames;

        public TreeNode(String departmentName) {
            this.departmentName = departmentName;
            this.subDepartments = new ArrayList<>();
            this.employeeNames = new ArrayList<>();
        }

        public void addSubDepartment(TreeNode subDepartment) {
            this.subDepartments.add(subDepartment);
        }

        public void addEmployees(String name) {
            this.employeeNames.add(name);
        }
    }

    public static void main(String[] s) {
        TreeNode hr = new TreeNode("HR");
        hr.addEmployees("Mona");
        hr.addEmployees("Spring");

        TreeNode engg = new TreeNode("ENGG");
        TreeNode be = new TreeNode("BE");
        TreeNode fe = new TreeNode("FE");

        be.addEmployees("Alice");
        be.addEmployees("Bob");
        fe.addEmployees("Lisa");
        fe.addEmployees("Marley");

        engg.addSubDepartment(be);
        engg.addSubDepartment(fe);

        engg.addEmployees("Tom");
        TreeNode c = new TreeNode("Company");
        c.addSubDepartment(hr);
        c.addSubDepartment(engg);

        CommonGroupAtlassian commonGroupAtlassian = new CommonGroupAtlassian();
        Set<String> targetEmp = new HashSet<>();
        targetEmp.add("Lisa");
        targetEmp.add("Tom");

        String commonGName = commonGroupAtlassian.findCommonGroup(c, targetEmp);

        System.out.println(commonGName);
    }
}
