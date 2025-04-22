package bean;

public class Student {
    private String no;
    private String name;
    private String entYear;
    private boolean isAttend;
    private String classNum;
    private School school;


    public Student() {
    }

    // no
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    // name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // entYear（入学年度）
    public String getEntYear() {
        return entYear;
    }

    public void setEntYear(String entYear) {
        this.entYear = entYear;
    }

    // isAttend（在学中かどうか）
    public boolean isAttend() {
        return isAttend;
    }

    public void setAttend(boolean isAttend) {
        this.isAttend = isAttend;
    }

    // classNum（クラス番号）
    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    // school（学校情報）
    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}