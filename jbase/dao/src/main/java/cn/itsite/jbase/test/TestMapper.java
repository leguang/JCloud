package cn.itsite.jbase.test;


import cn.itsite.jbase.common.test.User;
import cn.itsite.jbase.entity.DictItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    int deleteByPrimaryKey(String uid);

    int insert(DictItem record);

    DictItem selectByPrimaryKey(String uid);

    List<DictItem> selectAll();

    int updateByPrimaryKey(DictItem record);
}