package com.chinasofti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.dao.ClazzDao;
import com.chinasofti.entity.Clazz;
import com.chinasofti.service.ClazzService;

@Service
public class ClazzServiceImpl implements ClazzService {

	@Autowired
	private ClazzDao clazzDao;

	public List<Clazz> getClazzList() {
		return clazzDao.getClazzList();
	}

}
