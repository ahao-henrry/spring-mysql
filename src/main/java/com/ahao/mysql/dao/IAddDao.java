package com.ahao.mysql.dao;

import com.ahao.mysql.pojo.LikePojo;

public interface IAddDao {

    boolean saveNormal(LikePojo likePojo);

    boolean saveNamedParameter(LikePojo likePojo);

}
