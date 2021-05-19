package oqg.qifei.entity;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/11 16:50
 * @Description
 */
public class Teacher {
    private Integer age;
    private String name;
    private List<School> school;
    private Student student;
    private List<TeachSkill> teachSkill;

    public Teacher(Integer age, String name, List<School> school) {
        this.age = age;
        this.name = name;
        this.school = school;
    }

    public void setSchool(List<School> school) {
        this.school = school;
    }

    public Teacher(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Teacher() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<School> getSchool() {
        return school;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<TeachSkill> getTeachSkill() {
        return teachSkill;
    }

    public void setTeachSkill(List<TeachSkill> teachSkill) {
        this.teachSkill = teachSkill;
    }

    public void startTeaching(TeachSkill teachSkill) {
        this.teachSkill.add(teachSkill);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", school=" + school +
                ", student=" + student +
                '}';
    }
}
