package com.nestdigital.NestApp.Controller;


import com.nestdigital.NestApp.Model.LeaveModel;
import com.nestdigital.NestApp.dao.LeaveDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {

    @Autowired
    public LeaveDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addleave",consumes = "application/json",produces = "application/json")
    public String AddLeave(@RequestBody LeaveModel leave)
    {
        DateTimeFormatter dt =DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentdate = String.valueOf(dt.format(now));
        leave.setApply_date(currentdate);
        System.out.println(leave.toString());
        dao.save(leave);
        return "{Status:'Success'}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/view",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>> ViewSingle(@RequestBody LeaveModel leave){
        return (List<Map<String, String>>) dao.viewSingle(leave.getEmp_id());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewall")
    public List<Map<String,String>> ViewAll()
    {
        return (List<Map<String, String>>) dao.ViewAll();
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewstatus",consumes = "application/json",produces = "application/json")
    public String ChangeLeaveStatus(@RequestBody LeaveModel leave){
        dao.ChangeStatus(leave.getId(),leave.getStatus());
        return "{Status:'Success'}";
    }


}
