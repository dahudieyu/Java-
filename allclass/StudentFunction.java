package testcom.testmyapp.allclass;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

import testcom.testmyapp.allinterface.Student_Interface;


public class StudentFunction implements Student_Interface {
    Student s = new Student();
    private Scanner scanner = new Scanner(System.in); // 类级别Scanner
    private static final String FILE_PATH = "students.txt";

    public String addStudnet() {
        System.out.println("请输入学生信息：");

        System.out.print("姓名：");
        s.setName(scanner.nextLine());

        System.out.print("性别：");
        s.setSex(scanner.nextLine());

        System.out.print("年龄：");
        s.setAge(scanner.nextInt());
        scanner.nextLine(); // 消耗换行符

        System.out.print("出生日期(yyyy-MM-dd): ");
        s.setDate(scanner.nextLine());

        System.out.print("学号：");
        s.setId(scanner.nextLine());

        System.out.print("班级：");
        s.setS_class(scanner.nextLine());

        System.out.print("专业：");
        s.setMajor(scanner.nextLine());

        System.out.print("学位：");
        s.setDegree(scanner.nextLine());

        System.out.print("学分(满绩4.0):");
        s.setCredits(scanner.nextDouble());
        scanner.nextLine(); // 消耗换行符

        if (saveToFile(s)) {
            return "Student added successfully";
        } else {
            return "Student added failed";
        }

    }

    public String getStudentList() {
        readFromFile();
        return "Student list displayed successfully";
    }

    public String deleteStudent() {
        // 可以根据输入的学号或者姓名来删除 如果有重名的则会将重名的同学输出 在输入学号进行删除
        Boolean Judge = true;
        while (Judge) {
        System.out.println("请选择删除方式：");
        System.out.println("1.按学号删除");
        System.out.println("2.按姓名删除");
            
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
            if (choice == 1) {
                System.out.print("请输入学号：");
                String id = scanner.nextLine();
                if (deleteById(id)) {
                } else {
                    System.out.println("删除失败！");
                }
            } else if (choice == 2) {
                System.out.print("请输入姓名：");
                String name = scanner.nextLine();
                if (deleteByName(name)) {
                } else {
                    System.out.println("删除失败！");
                }

                return "Student deleted successfully";
            }

           
        }
       

        return "Student deleted successfully";
    }

    public String updateStudent() {
        // 可以根据输入的学号进行修改
        System.out.print("请输入学号：");
        String id = scanner.nextLine();
        Student student = findById(id);

        if (student == null) {
            return "Student not found";
        }
        //输出该学生信息
        System.out.println("该学生信息如下：");
        System.out.println("╔══════════╗");
        System.out.printf("║ %-12s: %-15s ║\n", "姓名", student.getName());
        System.out.printf("║ %-12s: %-15s ║\n", "性别", student.getSex());
        System.out.printf("║ %-12s: %-15s ║\n", "年龄", student.getAge());
        System.out.printf("║ %-12s: %-15s ║\n", "出生日期", student.getDate());
        System.out.printf("║ %-12s: %-15s ║\n", "学号", student.getId());
        System.out.printf("║ %-12s: %-15s ║\n", "班级", student.getS_class());
        System.out.printf("║ %-12s: %-15s ║\n", "专业", student.getMajor());
        System.out.printf("║ %-12s: %-15s ║\n", "学位", student.getDegree());
        System.out.printf("║ %-12s: %-15s ║\n", "学分", student.getCredits());
        System.out.println("╚══════════╝");
        

        System.out.println("请输入修改信息：");
        System.out.print("姓名(留空不修改)：");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            student.setName(name);
        }

        System.out.print("性别(留空不修改)：");
        String sex = scanner.nextLine();
        if (!sex.isEmpty()) {
            student.setSex(sex);
        }

        System.out.print("年龄(留空不修改)：");
        String input_age = scanner.nextLine();
        if (!input_age.isEmpty()) {
            int age = Integer.parseInt(input_age); // 使用 Integer.parseInt() 方法
            student.setAge(age); // 假设方法名是 setAge，而不是 setCredits
        }

        System.out.print("出生日期(yyyy-MM-dd)(留空不修改)：");
        String date = scanner.nextLine();
        if (!date.isEmpty()) {
            student.setDate(date);
        }

        System.out.print("班级(留空不修改)：");
        String s_class = scanner.nextLine();
        if (!s_class.isEmpty()) {
            student.setS_class(s_class);
        }

        System.out.print("专业(留空不修改)：");
        String major = scanner.nextLine();
        if (!major.isEmpty()) {
            student.setMajor(major);
        }

        System.out.print("学位(留空不修改)：");
        String degree = scanner.nextLine();
        if (!degree.isEmpty()) {
            student.setDegree(degree);
        }

        System.out.print("学分(满绩4.0)(留空不修改)：");
        String input_credits = scanner.nextLine();
        if (!input_credits.isEmpty()) {
            double credits = Double.parseDouble(input_credits);
            student.setCredits(credits);
        }


        if (saveToFileWithoutAppend(student, id)) {
        } else {
            return "Student updated failed";
        }
        
        return "Student updated successfully";
    }

    public String searchStudent() {
        // 可以根据输入的学号或者姓名来来搜索 如果有重名的则会将重名的同学输出 
    
        System.out.println("请选择搜索方式：");
        System.out.println("1.按学号搜索");
        System.out.println("2.按姓名搜索");
        
        int choice = -1;
        while (choice == -1) {
            try {
                choice = Integer.parseInt(System.console().readLine());
                if (choice >= 0 && choice <= 6) {
                    if (choice == 0) {
                        break;
                    } else {
                        break;
                    }
                }
                System.out.println("请输入0-6的数字！");
            } catch (NumberFormatException e) {
                System.out.println("输入无效（必须为数字），请重新输入：");
            }
        }
        
        if (choice == 1) {
            System.out.print("请输入学号：");
            String id = scanner.nextLine();
            Student student = findById(id);
            if (student == null) {
                return "Student not found";
            }
            System.out.println("该学生信息如下：");
            System.out.println("╔══════════╗");
            System.out.printf("║ %-12s: %-15s ║\n", "姓名", student.getName());
            System.out.printf("║ %-12s: %-15s ║\n", "性别", student.getSex());
            System.out.printf("║ %-12s: %-15s ║\n", "年龄", student.getAge());
            System.out.printf("║ %-12s: %-15s ║\n", "出生日期", student.getDate());
            System.out.printf("║ %-12s: %-15s ║\n", "学号", student.getId());
            System.out.printf("║ %-12s: %-15s ║\n", "班级", student.getS_class());
            System.out.printf("║ %-12s: %-15s ║\n", "专业", student.getMajor());
            System.out.printf("║ %-12s: %-15s ║\n", "学位", student.getDegree());
            System.out.printf("║ %-12s: %-15s ║\n", "学分", student.getCredits());
            System.out.println("╚══════════╝");            
        } else if (choice == 2) {
            System.out.print("请输入姓名：");
            String name = scanner.nextLine();
            printStudentsByName(name);
        }

        return "Student searched successfully";
    }


    private boolean saveToFile(Student student) {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            out.println(student.toString());
            out.write(s.toString() + "\n");
            return true;
        } catch (IOException e) {
            System.err.println("保存学生信息失败: " + e.getMessage());
            return false;
        }
    }

    private boolean saveToFileWithoutAppend(Student student, String studentId) {
        List<String> keptLines = new ArrayList<>();
        boolean found = false;

        try (Scanner in = new Scanner(new FileReader(FILE_PATH))) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.contains("id=" + studentId + ",")) {
                    found = true;
                    keptLines.add(student.toString()); // 替换为更新后的学生信息
                    continue;
                } else if (line.endsWith("id=" + studentId + "}")) {
                    found = true;
                    keptLines.add(student.toString()); // 替换为更新后的学生信息
                    continue;
                }
                keptLines.add(line); // 保留其他行
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        if (!found) {
            return false; // 没有找到目标 id
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (String line : keptLines) {
                out.println(line);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }    

    private void readFromFile() {
        try (Scanner in = new Scanner(new FileReader(FILE_PATH))) {
            int count = 0;
            while (in.hasNextLine()) {
                Student student = parseStudent(in.nextLine());
                System.out.println("\n╔══════════════════════════════╗");
                System.out.printf("║ %-28s ║\n", "学生档案 #" + (++count));
                System.out.println("╠══════════════════════════════╣");
                System.out.printf("║ %-12s: %-15s ║\n", "姓名", student.getName());
                System.out.printf("║ %-12s: %-15s ║\n", "学号", student.getId());
                System.out.printf("║ %-12s: %-15s ║\n", "专业", student.getMajor());
                System.out.printf("║ %-12s: %-15s ║\n", "班级", student.getS_class());
                System.out.println("╚══════════════════════════════╝");
            }
            System.out.printf("\n✨ 共检索到 %d 名学生信息 ✨\n", count);
        } catch (IOException e) {
            System.err.println("读取失败: " + e.getMessage());
        }

    }

    private Student parseStudent(String line) {
        // 示例：解析格式 "Student{name=张三, sex=男, age=20, ...}"
        String[] parts = line.substring(line.indexOf("{") + 1, line.indexOf("}"))
                .split(", ");

        Map<String, String> map = new HashMap<>();
        for (String part : parts) {
            String[] keyValue = part.split("=");
            if (keyValue.length == 2) {
                map.put(keyValue[0], keyValue[1]);
            }
        }

        return new Student(
                map.get("name"),
                map.get("sex"),
                Integer.parseInt(map.get("age")),
                map.get("date"),
                map.get("id"),
                map.get("s_class"),
                map.get("major"),
                map.get("degree"),
                Double.parseDouble(map.get("credits")));
    }

    public void processChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println(addStudnet());
                break;
            case 2:
                System.out.println(getStudentList());
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

   
    private boolean deleteById(String id) {
        List<String> keptLines = new ArrayList<>();
        boolean found = false;

        try (Scanner in = new Scanner(new FileReader(FILE_PATH))) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.contains("id=" + id + ",")) {
                    found = true; // 找到需要删除的行
                    continue; // 不保留该行
                } else if (line.endsWith("id=" + id + "}")) {
                    found = true;
                    continue;
                }
                keptLines.add(line); // 保留其他行
            }
        } catch (IOException e) {
            System.err.println("读取文件失败: " + e.getMessage());
            return false;
        }

        if (!found) {
            return false; // 没有找到目标 id
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (String line : keptLines) {
                out.println(line);
            }
            return true;
        } catch (IOException e) {
            System.err.println("写入文件失败: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deleteByName(String name) {
        // 先打印出所有同名学生列表
        printStudentsByName(name);
        // 让用户选择要删除的ID
        System.out.print("输入要删除的学生ID（输入cancel放弃）: ");
        String input = scanner.nextLine();
        if (!"cancel".equalsIgnoreCase(input)) {
            return deleteById(input);
        }        
        
        return false;
    }

    public void printStudentsByName(String name) {
        System.out.println("【同名学生列表】");
        try {
            long matchCount = Files.lines(Paths.get(FILE_PATH))
                    .filter(line -> {
                        // 提取name字段的值
                        String pattern = "name=" + name + "[,}]";
                        return line.matches(".*" + pattern + ".*");
                    })
                    .peek(System.out::println)
                    .count();

            if (matchCount == 0) {
                System.out.println("未找到姓名包含 \"" + name + "\" 的学生");
            }
        } catch (IOException e) {
            System.err.println("读取失败: " + e.getMessage());
        }
    }

    private Student findById(String id) {
        try (Scanner in = new Scanner(new FileReader(FILE_PATH))) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.contains("id=" + id + ",") || line.endsWith("id=" + id + "}")) {
                    return parseStudent(line);
                }
            }
        } catch (IOException e) {
            System.err.println("读取文件失败: " + e.getMessage());
        }
        return null;
    }
    

}