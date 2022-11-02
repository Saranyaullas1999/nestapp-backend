package com.nestdigital.NestApp.dao;

import com.nestdigital.NestApp.Model.LeaveModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository<LeaveModel,Integer> {

    @Query(value = "SELECT l.id, l.`apply_date`, l.`date`, l.`duration`, l.`reason`, l.`status`, l.`type`,e.name FROM `leaveform` l JOIN employee e ON e.id=l.emp_id WHERE l.emp_id = :emp_id",nativeQuery = true)
    List<Map<String,String>> viewSingle(Integer emp_id);

    @Query(value = "SELECT l.id, l.`apply_date`, l.`date`, l.`duration`, l.`reason`, l.`status`, l.`type`,e.name FROM `leaveform` l JOIN employee e ON e.id=l.emp_id",nativeQuery = true)
    List<Map<String,String>> ViewAll();

    @Modifying
    @Query(value = "UPDATE `leaveform` SET `status`= :status WHERE `id`= :id",nativeQuery = true)
    void ChangeStatus(Integer id,Integer status);

}
