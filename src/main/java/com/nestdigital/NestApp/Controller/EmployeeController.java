package com.nestdigital.NestApp.Controller;


import com.nestdigital.NestApp.Model.EmployeeModel;
import com.nestdigital.NestApp.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao dao;



    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemp",consumes = "application/json",produces = "application/json")
    public String AddEmployee(@RequestBody EmployeeModel admin)
    {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentdate = String.valueOf(dt.format(now));
        admin.setJoin_date(currentdate);
        System.out.println(admin.toString());
        dao.save(admin);
        return "{Status:'Success}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchemp",consumes = "application/json",produces = "application/json")
    public List<EmployeeModel> SearchEmployee(@RequestBody EmployeeModel admin){
        return (List<EmployeeModel>) dao.searchEmployee(admin.getName(),admin.getEmp_code());
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/editemp",consumes = "application/json",produces = "application/json")
    public String EditEmployee(@RequestBody EmployeeModel admin){
        dao.editEmployee(admin.getDesignation(),admin.getEmail(),admin.getEmp_code(),admin.getJoin_date(),admin.getName(),admin.getPassword(),admin.getPhoneno(),admin.getPlace(),admin.getId());
        return "{Status:'Success'}";
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deleteemp",consumes = "application/json",produces = "apllication/json")
    public String DeleteEmp(@RequestBody EmployeeModel admin)
    {
        dao.deleteEmployee(admin.getId());
        return "{Status:'Success'}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewemp")
    public List<EmployeeModel> ViewEmployee(){
        return (List<EmployeeModel>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
    public List<EmployeeModel> Login(@RequestBody EmployeeModel admin){
        return (List<EmployeeModel>) dao.LoginEmployee(admin.getEmp_code(),admin.getPassword());
    }

}
