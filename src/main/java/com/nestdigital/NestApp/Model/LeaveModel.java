package com.nestdigital.NestApp.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leaveform")
public class LeaveModel {

    @Id
    @GeneratedValue
    private int id;
    private int emp_id;
    private String type;
    private String apply_date;
    private String date;
    private int duration;
    private String reason;
    private int status;

    public LeaveModel() {
    }

    public LeaveModel(int id, int emp_id, String type, String apply_date, String date, int duration, String reason, int status) {
        this.id = id;
        this.emp_id = emp_id;
        this.type = type;
        this.apply_date = apply_date;
        this.date = date;
        this.duration = duration;
        this.reason = reason;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getApply_date() {
        return apply_date;
    }

    public void setApply_date(String apply_date) {
        this.apply_date = apply_date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
