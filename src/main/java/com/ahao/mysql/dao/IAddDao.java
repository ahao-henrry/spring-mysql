package com.ahao.mysql.dao;

import java.util.List;

import com.ahao.mysql.pojo.LikePojo;

public interface IAddDao {

    boolean saveNormal(LikePojo likePojo);

    boolean saveNamedParameter(LikePojo likePojo);

	boolean batchSave(List<LikePojo> likePojos);

}
