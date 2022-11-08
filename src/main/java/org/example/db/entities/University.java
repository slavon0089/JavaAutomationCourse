package org.example.db.entities;

public class University {

    private int university_id;
    private String uni_name;
    private String address;

    public University(int university_id, String uni_name, String address) {
        this.university_id = university_id;
        this.uni_name = uni_name;
        this.address = address;
    }

    public int getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(int university_id) {
        this.university_id = university_id;
    }

    public String getUni_name() {
        return uni_name;
    }

    public void setUni_name(String uni_name) {
        this.uni_name = uni_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "University{" +
                "university_id=" + university_id +
                ", uni_name='" + uni_name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
