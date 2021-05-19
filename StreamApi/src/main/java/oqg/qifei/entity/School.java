package oqg.qifei.entity;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/14 9:11
 * @Description
 */
public class School {
    private Integer members;
    private String name;
    private Boolean isPrivate;

    public School() {
    }

    public School(Integer members, String name) {
        this.members = members;
        this.name = name;
    }

    public School(Integer members, String name, Boolean isPrivate) {
        this.members = members;
        this.name = name;
        this.isPrivate = isPrivate;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    @Override
    public String toString() {
        return "School{" +
                "members=" + members +
                ", name='" + name + '\'' +
                ", isPrivate=" + isPrivate +
                '}';
    }
}
