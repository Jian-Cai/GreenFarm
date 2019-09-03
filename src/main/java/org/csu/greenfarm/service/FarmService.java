package org.csu.greenfarm.service;

import org.csu.greenfarm.domain.Farm;

import java.util.List;

public interface FarmService {

    List<Farm> getAllFarm(); //返回所有的采摘园
    Farm getFarmByFarmId(String farmId); //通过采摘园Id返回采摘园
    Farm getFarmByItem(String farm_item); //通过主营业务返回采摘园
}
