package testcom.testmyapp.allclass;

public class Person {
    private String name;
    private String sex;
    private int age;
    private String date; /*date like 2021-01-01*/

    public Person() {
        }

    public Person(String name, String sex, int age, String date) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
