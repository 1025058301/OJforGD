package pers.lcy.graduationdesign.dao;

import pers.lcy.graduationdesign.model.ProblemPerson;

public interface ProblemPersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProblemPerson record);

    int insertSelective(ProblemPerson record);

    ProblemPerson selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProblemPerson record);

    int updateByPrimaryKey(ProblemPerson record);
}