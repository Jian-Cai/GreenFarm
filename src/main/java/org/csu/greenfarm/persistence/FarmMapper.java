/*
 * Copyright (c) 2019
 * User: Duo.y
 * File: FarmMapper.java
 * Date: 2019/09/02 15:24:02
 */

package org.csu.greenfarm.persistence;

import org.csu.greenfarm.domain.Farm;

import java.util.List;

public interface FarmMapper {

    List<Farm> getAllFarm(); //返回所有的采摘园
    Farm getFarmByFarmId(String farmId); //通过采摘园Id返回采摘园
    Farm getFarmByItem(String farm_item); //通过主营业务返回采摘园
    List<Farm> getFarmByFarmName(String farm_name); //通过采摘园名称返回采摘园
}
