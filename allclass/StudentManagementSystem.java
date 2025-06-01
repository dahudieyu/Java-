package testcom.testmyapp.allclass;

public class StudentManagementSystem {
    // 获取菜单文本（供网络传输使用）
    public String getMenuText() {
        return """
                ========== 学生管理系统 ==========
                1. 添加学生信息
                2. 查看学生列表
                3. 修改学生信息
                4. 删除学生信息
                5. 查询学生信息
                0. 退出系统
                ===============================
                请输入您的选择(0-6):""";
    }

    StudentFunction sf = new StudentFunction();

    // 处理用户选择
    public String processChoice(int choice) {
       
        switch (choice) {
            case 1:
                return sf.addStudnet();
            case 2:
                return sf.getStudentList();
            case 3:
                return sf.updateStudent();
            case 4:
                return sf.deleteStudent();
            case 5:
                return sf.searchStudent();
            case 0:
                return "感谢使用学生管理系统，再见！";
            default:
                return "输入无效，请重新输入！";
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        String menuText = sms.getMenuText();
        System.out.println("欢迎使用学生管理系统！");

        Boolean Judge = true;
        while (Judge) {
            System.out.println(menuText);
            int choice = -1;
            while (Judge) {
                try {
                    choice = Integer.parseInt(System.console().readLine());
                    if (choice >= 0 && choice <= 6) {
                        if (choice == 0) {
                            Judge = false;
                            break;
                        } else {
                            Judge = true;
                        }
                        break;
                    }
                        Judge = false;
                    System.out.println("请输入0-6的数字！");
                } catch (NumberFormatException e) {
                    System.out.println("输入无效（必须为数字），请重新输入：");
                }
            }

            String result = sms.processChoice(choice);
            System.out.println(result);
        }
    }

}
 