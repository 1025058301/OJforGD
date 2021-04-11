package pers.lcy.graduationdesign.dao;

import pers.lcy.graduationdesign.model.HomeworkInfo;

public interface HomeworkInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HomeworkInfo record);

    int insertSelective(HomeworkInfo record);

    HomeworkInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HomeworkInfo record);

    int updateByPrimaryKey(HomeworkInfo record);
}