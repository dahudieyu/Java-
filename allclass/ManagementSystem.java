package testcom.testmyapp.allclass;

import java.util.ArrayList;
import java.util.List;

public class ManagementSystem {
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();

    // 学生类
    private static class Student {
        private String id;
        private String name;
        private int age;

        public Student(String id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("学号: %s, 姓名: %s, 年龄: %d", id, name, age);
        }
    }

    // 获取菜单文本（供网络传输使用）
    public String getMenuText() {
        return """
                ========== 学生管理系统 ==========
                1. 添加学生信息
                2. 查看学生列表
                3. 修改学生信息
                4. 删除学生信息
                5. 查询学生信息
                6. 统计学生数量
                0. 退出系统
                ===============================
                请输入您的选择(0-6):""";
    }

    // 处理用户选择
    public String processChoice(int choice, String... params) {
        switch (choice) {
            case 1:
                return addStudent(params[0], params[1], Integer.parseInt(params[2]));
            case 2:
                return getStudentList();
            case 3:
                return updateStudent(params[0], params[1], Integer.parseInt(params[2]));
            case 4:
                return deleteStudent(params[0]);
            case 5:
                return searchStudent(params[0]);
            case 6:
                return getStudentCount();
            case 0:
                return "感谢使用学生管理系统，再见！";
            default:
                return "输入无效，请重新输入！";
        }
    }

    private String addStudent(String id, String name, int age) {
        students.add(new Student(id, name, age));
        return "学生信息添加成功！";
    }

    private String getStudentList() {
        if (students.isEmpty()) {
            return "当前没有学生信息！";
        }
        StringBuilder sb = new StringBuilder("--- 学生列表 ---\n");
        for (Student s : students) {
            sb.append(s).append("\n");
        }
        return sb.toString();
    }

    private String updateStudent(String id, String newName, int newAge) {
        for (Student s : students) {
            if (s.id.equals(id)) {
                s.name = newName;
                s.age = newAge;
                return "学生信息修改成功！";
            }
        }
        return "未找到该学生！";
    }

    private String deleteStudent(String id) {
        if (students.removeIf(s -> s.id.equals(id))) {
            return "学生信息删除成功！";
        }
        return "未找到该学生！";
    }

    private String searchStudent(String id) {
        for (Student s : students) {
            if (s.id.equals(id)) {
                return "查询结果: " + s;
            }
        }
        return "未找到该学生！";
    }

    private String getStudentCount() {
        return "当前学生总数: " + students.size();
    }
}
