package testcom.testmyapp.allclass;

public class Teacher extends Person {
    private int id;
    private String subject;
    private String department;
    private String salary;
    private int[] guide_students_id;

    public Teacher(String name, String sex, int age, String date, int id, String subject, String department,
            String salary, int[] guide_students_id) {
        super(name, sex, age, date);
        this.id = id;
        this.subject = subject;
        this.department = department;
        this.salary = salary;
        this.guide_students_id = guide_students_id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int[] getGuide_students_id() {
        return guide_students_id;
    }

    public void setGuide_students_id(int[] guide_students_id) {
        this.guide_students_id = guide_students_id;
    }

}
