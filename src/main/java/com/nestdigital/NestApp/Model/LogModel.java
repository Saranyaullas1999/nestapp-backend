package com.nestdigital.NestApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "log")
public class LogModel {

    @Id
    @GeneratedValue

    private int id;
    private int emp_id;
    private int login_sec_id;
    private int logout_sec_id;
    private String login_time;
    private String logout_time;
    private int status;

    public LogModel() {
    }

    public LogModel(int id, int emp_id, int login_sec_id, int logout_sec_id, String login_time, String logout_time, int status) {
        this.id = id;
        this.emp_id = emp_id;
        this.login_sec_id = login_sec_id;
        this.logout_sec_id = logout_sec_id;
        this.login_time = login_time;
        this.logout_time = logout_time;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getLogin_sec_id() {
        return login_sec_id;
    }

    public void setLogin_sec_id(int login_sec_id) {
        this.login_sec_id = login_sec_id;
    }

    public int getLogout_sec_id() {
        return logout_sec_id;
    }

    public void setLogout_sec_id(int logout_sec_id) {
        this.logout_sec_id = logout_sec_id;
    }

    public String getLogin_time() {
        return login_time;
    }

    public void setLogin_time(String login_time) {
        this.login_time = login_time;
    }

    public String getLogout_time() {
        return logout_time;
    }

    public void setLogout_time(String logout_time) {
        this.logout_time = logout_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}


