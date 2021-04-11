package pers.lcy.graduationdesign.dao;

import pers.lcy.graduationdesign.model.CourseSelectInfo;

public interface CourseSelectInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseSelectInfo record);

    int insertSelective(CourseSelectInfo record);

    CourseSelectInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseSelectInfo record);

    int updateByPrimaryKey(CourseSelectInfo record);
}