package com.qiumingjie.dao.formSystem;

import com.qiumingjie.entities.formSystem.info.OpsQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author QiuMingJie
 * @date 2021/5/7 14:44
 * @description
 */
@Repository
public interface OperationPlanRepository extends JpaRepository<OpsQueue,String> {
    @Query(nativeQuery = true,value =
            "select \n" +
                    "dbo.OPS_Queue.patient_dept as dept,\n" +
                    "dbo.OPS_Queue.patient_bed as bed, \n" +
                    "dbo.OPS_Queue.inpatientID as inpatientId,\n" +
                    "dbo.BasicData_Patient_Info.name as name,\n" +
                    "dbo.BasicData_Patient_Info.age as age,\n" +
                    "dbo.OPS_Queue.operation_room as room,\n" +
                    "dbo.OPS_Queue.operation_no as no,\n" +
                    "(operation_doctor+','+anesthetic_assistant1+','+anesthetic_assistant2+','+anesthetic_assistant3) as operationDoctor,\n" +
                    "anesthetic_doctor as anestheticDoctor,\n" +
                    "scrub_nurse as scrubNurse,\n" +
                    "circulating_nurse as circulatingNurse\n" +
                    "from dbo.OPS_Queue inner join dbo.BasicData_Patient_Info\n" +
                    "on dbo.OPS_Queue.patientID =dbo.BasicData_Patient_Info.patientID\n" +
                    "where request_datetime>= ?1 and request_datetime<?2 and 手术执行地点=?3 \n" +
                    "order by patient_dept,dbo.OPS_Queue.operation_room asc\n")
    List<Object> getOperationPlan(Date requestDateTimeStart, Date requestDateTimeEnd, String operationPlace);
}
