package com.baizhi.dao;

import com.baizhi.entity.Student;

import java.util.List;

public interface PoiDao {
    public void insert(List<Student> list);
     public void update(List<Student> list);
	  public void edit(List<Student> list);
}
