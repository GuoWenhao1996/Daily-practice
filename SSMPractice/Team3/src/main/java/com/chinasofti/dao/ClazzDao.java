package com.chinasofti.dao;

import java.util.List;

import com.chinasofti.entity.Clazz;

public interface ClazzDao {

	public List<Clazz> getClazzList();

	public Clazz getClazzByid(Integer id);
}
