package vn.ht.phonebook.module;

import java.util.Date;

public class Phonebook {
    private String phone;
    private String groupPhonebook;
    private String fullName;
    private String gender;
    private String address;
    private String birthdate;
    private String email;

    public Phonebook() {
    }

    public Phonebook( String phone, String groupPhonebook, String fullName, String gender, String address, String birthdate, String email) {
        this.phone = phone;
        this.groupPhonebook = groupPhonebook;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.birthdate = birthdate;
        this.email = email;
    }

    public Phonebook(String record) {
        String[] fields = record.split(",");
        phone = fields[0];
        groupPhonebook = fields[1];
        fullName = fields[2];
        gender = fields[3];
        address = fields[4];
        birthdate = fields[5];
        email = fields[6];

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGroupPhonebook() {
        return groupPhonebook;
    }

    public void setGroupPhonebook(String groupPhonebook) {
        this.groupPhonebook = groupPhonebook;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return phone + "," + groupPhonebook + "," + fullName + "," + gender + "," + address + "," + birthdate + "," + email;
    }
}
