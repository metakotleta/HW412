import java.util.List;

public class Employee {

    private String lastName;
    private String firstName;
    private String age;
    private String sex;
    private String education;
    private String function;
    private String department;

    public Employee(List<String> empAccountingList) {
        this.lastName = empAccountingList.get(0);
        this.firstName = empAccountingList.get(1);
        this.age = empAccountingList.get(2);
        this.sex = empAccountingList.get(3);
        this.education = empAccountingList.get(4);
        this.function = empAccountingList.get(5);
        this.department = empAccountingList.get(6);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Фамилия:" + lastName +
                ", имя:" + firstName +
                ", возраст:" + age +
                ", пол:" + sex +
                ", образование:" + education +
                ", должность:" + function +
                ", отдел:" + department;
    }

}
