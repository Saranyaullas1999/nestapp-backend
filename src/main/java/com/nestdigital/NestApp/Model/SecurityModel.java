package com.nestdigital.NestApp.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "security")
public class SecurityModel {

    @Id
    @GeneratedValue

    private int id;
    private String name;
    private int sec_code;
    private String password;
    private String place;
    private String phone;
    private String doj;

    public SecurityModel() {
    }

    public SecurityModel(int id, String name, int sec_code, String password, String place, String phone, String doj) {
        this.id = id;
        this.name = name;
        this.sec_code = sec_code;
        this.password = password;
        this.place = place;
        this.phone = phone;
        this.doj = doj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSec_code() {
        return sec_code;
    }

    public void setSec_code(int sec_code) {
        this.sec_code = sec_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }
}
