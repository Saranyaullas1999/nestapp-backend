package com.nestdigital.NestApp.dao;

import com.nestdigital.NestApp.Model.EmployeeModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<EmployeeModel,Integer> {

    @Query(value = "SELECT `id`, `designation`, `email`, `emp_code`, `join_date`, `name`, `password`, `phoneno`, `place` FROM `employee` WHERE `name`= :name OR `emp_code`= :emp_code",nativeQuery = true)
    List<EmployeeModel> searchEmployee(String name, Integer emp_code);


    @Modifying
    @Query(value = "UPDATE `employee` SET `designation`= :designation,`email`= :email,`emp_code`= :emp_code,`join_date`= :join_date,`name`= :name,`password`= :password,`phoneno`= :phoneno,`place`= :place WHERE `id`= :id",nativeQuery = true)
    void editEmployee(String designation,String email,Integer emp_code,String join_date,String name,String password,String phoneno,String place,Integer id);

    @Modifying
    @Query(value = "DELETE FROM `employee` WHERE `id`= :id",nativeQuery = true)
    void deleteEmployee(Integer id);

    @Query(value = "SELECT `id`, `designation`, `email`, `emp_code`, `join_date`, `name`, `password`, `phoneno`, `place` FROM `employee` WHERE `emp_code`= :emp_code AND `password`= :password",nativeQuery = true)
    List<EmployeeModel> LoginEmployee(Integer emp_code, String password);




}
