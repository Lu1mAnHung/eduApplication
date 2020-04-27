package com.edu.service.evaluation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.EvaluationDao;
import com.edu.model.EvalutionInfo;
import com.edu.service.evaluation.EvaluationService;


@Service
public class EvalutionServiceImpl implements EvaluationService{

	@Autowired
	EvaluationDao EvaluationDao;

	@Override
	public List<EvalutionInfo> showEvaCourse(String u_no) {
		List<EvalutionInfo> list = EvaluationDao.showEvaCourse(u_no);
		return list;
	}


	@Override
	public List<EvalutionInfo> viewEvaluation(String u_name) {
		List<EvalutionInfo> list = EvaluationDao.viewEvaluation(u_name);
		return list;
	}

	@Override
	public void addEvaluation(String u_no, String c_id, String evaluation) {
          EvaluationDao.addEvaluation(u_no, c_id, evaluation);
	}

}
