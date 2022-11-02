package com.nestdigital.NestApp.dao;

import com.nestdigital.NestApp.Model.LogModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface LogDao extends CrudRepository<LogModel,Integer> {

    @Modifying
    @Query(value = "UPDATE `log` SET `logout_sec_id`= :logout_sec_id,`logout_time`= :logout_time WHERE `id`= :id",nativeQuery = true)
    void Checkout(Integer logout_sec_id,String logout_time,Integer id);


    @Query(value = "SELECT l.`id`,l.emp_id,l.`login_sec_id`, l.`login_time`, l.`logout_sec_id`, l.`logout_time`,e.name ,s.name AS loginsec_name,c.name AS logoutsec_name FROM `log` l JOIN employee e ON e.id=l.emp_id JOIN security s JOIN security c ON s.id=l.login_sec_id AND c.id=l.logout_sec_id",nativeQuery = true)
    List<Map<String,String>> viewallLogs();

    @Query(value = "SELECT l.`id`,l.emp_id,l.`login_sec_id`, l.`login_time`, l.`logout_sec_id`, l.`logout_time`,e.name ,s.name AS loginsec_name,c.name AS logoutsec_name FROM `log` l JOIN employee e ON e.id=l.emp_id JOIN security s JOIN security c ON s.id=l.login_sec_id AND c.id=l.logout_sec_id WHERE l.emp_id= :emp_id",nativeQuery = true)
    List<Map<String,String>> ViewByIdLogs(Integer emp_id);
}
