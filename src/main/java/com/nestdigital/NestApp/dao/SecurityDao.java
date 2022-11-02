package com.nestdigital.NestApp.dao;

import com.nestdigital.NestApp.Model.EmployeeModel;
import com.nestdigital.NestApp.Model.SecurityModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SecurityDao extends CrudRepository<SecurityModel,Integer> {
    @Query(value = "SELECT `id`, `doj`, `name`, `password`, `phone`, `place`, `sec_code` FROM `security` WHERE `name`=:name OR `sec_code`= :sec_code ",nativeQuery = true)
    List<SecurityModel> searchSecurity(String name,Integer sec_code);

    @Modifying
    @Query(value = "UPDATE `security` SET `doj`= :doj,`name`= :name,`password`= :password,`phone`= :phone,`place`= :place,`sec_code`= :sec_code WHERE `id` = :id",nativeQuery = true)
    void editSecurity(String doj,String name,String password,String phone,String place,Integer sec_code,Integer id);

    @Modifying
    @Query(value = "DELETE FROM `security` WHERE `id`= :id",nativeQuery = true)
    void deleteSecurity(Integer id);

    @Query(value = "SELECT `id`, `doj`, `name`, `password`, `phone`, `place`, `sec_code` FROM `security` WHERE `sec_code`= :sec_code AND`password`= :password",nativeQuery = true)
    List<SecurityModel> SecurityLogin(Integer sec_code,String password);
}
