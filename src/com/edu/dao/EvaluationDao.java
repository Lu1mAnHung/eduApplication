package com.edu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.model.EvalutionInfo;

@Repository
public interface EvaluationDao {

	/**
	 * 展示课程评价（学生）
	 * @return
	 */
	public List<EvalutionInfo> showEvaCourse(String u_no);

	/**
	 * 添加评价
	 */
	public void addEvaluation(String u_no, String c_id, String evaluation);

	/**
	 * 展示学生评价（教师）
	 */
	public List<EvalutionInfo> viewEvaluation(String u_name);

}
