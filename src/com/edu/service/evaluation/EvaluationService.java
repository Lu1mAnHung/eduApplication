package com.edu.service.evaluation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.model.EvalutionInfo;


@Service
public interface EvaluationService {

    /**
     *显示可评价课程信息（学生角色权限功能）
     */
   public List<EvalutionInfo> showEvaCourse(String u_no);
     /**
      * 添加评价（学生角色权限功能）
      */
   public void addEvaluation(String u_no,String c_id,String evaluation);

   /**
    * 查看学生课程评价（教师角色权限功能）
    */
   public List<EvalutionInfo> viewEvaluation(String u_name);

}
