package org.example.db.entities;

public class Group {

    private int group_id;

    private String group_name;

    private int university_id;

    public Group(int group_id, String group_name, int university_id) {
        this.group_id = group_id;
        this.group_name = group_name;
        this.university_id = university_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public int getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(int university_id) {
        this.university_id = university_id;
    }

    @Override
    public String toString() {
        return "Group{" +
                "group_id=" + group_id +
                ", group_name='" + group_name + '\'' +
                ", university_id=" + university_id +
                '}';
    }
}
