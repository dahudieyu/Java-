package testcom.testmyapp.allclass;


public class Student extends Person {
    private String id;
    private String s_class;
    private String major;
    private String degree;
    private double credits;

    public Student() {
    }

    public Student(String name, String sex, int age, String date, String id, String s_class, String major, String degree, double credits) {
               super(name, sex, age, date);
               this.id = id;
               this.s_class = s_class;
               this.major = major;
               this.degree = degree;
               this.credits = credits;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getS_class() {
        return s_class;
    }

    public void setS_class(String s_class) {
        this.s_class = s_class;
    }
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + super.getName() + // 调用继承的public方法
                ", sex=" + super.getSex() +
                ", age=" + super.getAge() +
                ", date=" + super.getDate() +
                ", id=" + id +
                ", s_class=" + s_class +
                ", major=" + major +
                ", degree=" + degree +
                ", credits=" + credits +
                '}';
    }       

}
