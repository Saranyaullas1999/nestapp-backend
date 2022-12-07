package com.nestdigital.NestApp.Controller;



import com.nestdigital.NestApp.Model.EmployeeModel;
import com.nestdigital.NestApp.Model.SecurityModel;
import com.nestdigital.NestApp.dao.SecurityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class SecurityController {

    @Autowired
    private SecurityDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addsec",consumes = "application/json",produces = "application/json")
    public String AddSecurity(@RequestBody SecurityModel sec){
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentdate = String.valueOf(dt.format(now));
        sec.setDoj(currentdate);
        System.out.println(sec.toString());
        dao.save(sec);
        return "{Status:'Success'}";

    }

   @CrossOrigin(origins = "*")
   @PostMapping(path = "/searchsec",consumes = "application/json",produces = "application/json")
   public List<SecurityModel> searchSecurity(@RequestBody SecurityModel sec){
        return (List<SecurityModel>) dao.searchSecurity(sec.getName(),sec.getSec_code());
   }

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/editsec",consumes = "application/json",produces = "application/json")
    public String EditSecurity(@RequestBody SecurityModel sec){
        dao.editSecurity(sec.getDoj(),sec.getName(),sec.getPassword(),sec.getPhone(),sec.getPlace(),sec.getSec_code(),sec.getId());
        return "{Status:'Success'}";
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deletesec",consumes = "application/json",produces = "apllication/json")
    public String DeleteSecurity(@RequestBody SecurityModel sec)
    {
        dao.deleteSecurity(sec.getId());
        return "{Status:'Success'}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewsec")
    public List<SecurityModel> ViewSecurity(){
        return (List<SecurityModel>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/loginsec",consumes = "application/json",produces = "application/json")
    public List<SecurityModel> Login(@RequestBody SecurityModel sec){
        return (List<SecurityModel>) dao.SecurityLogin(sec.getSec_code(), sec.getPassword());
    }



}
