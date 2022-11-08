package org.example.db.entities;

public class Student {
    private int student_id;
    private String student_name;
    private String BIRTHDAY;
    private double AVERAGEMARK;
    private int group_id;
    private int BONUS;


    public Student(int student_id, String student_name, String BIRTHDAY, double AVERAGEMARK, int group_id, int BONUS) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.BIRTHDAY = BIRTHDAY;
        this.AVERAGEMARK = AVERAGEMARK;
        this.group_id = group_id;
        this.BONUS = BONUS;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {this.student_id = student_id;}

    public String getStudent_name() {return student_name;}

    public void setStudent_name(String student_name) {this.student_name = student_name;}

    public String getBIRTHDAY() {return BIRTHDAY;}

    public void setBIRTHDAY(String BIRTHDAY) {this.BIRTHDAY = BIRTHDAY;}

    public double getAVERAGEMARK() {return AVERAGEMARK;}

    public void setAVERAGEMARK(double AVERAGEMARK) {this.AVERAGEMARK = AVERAGEMARK;}

    public int getGroup_id() {return group_id;}

    public void setGroup_id(int group_id) {this.group_id = group_id;}

    public int getBONUS() {return BONUS;}

    public void setBONUS(int BONUS) {this.BONUS = BONUS;}

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", BIRTHDAY='" + BIRTHDAY + '\'' +
                ", AVERAGEMARK=" + AVERAGEMARK +
                ", group_id=" + group_id +
                ", BONUS=" + BONUS +
                '}';
    }
}
