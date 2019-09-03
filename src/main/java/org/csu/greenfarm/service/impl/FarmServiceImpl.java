package org.csu.greenfarm.service.impl;

import org.csu.greenfarm.domain.Farm;
import org.csu.greenfarm.persistence.FarmMapper;
import org.csu.greenfarm.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {

    @Autowired
    private FarmMapper mapper;

    @Override
    public List<Farm> getAllFarm() {
        return mapper.getAllFarm();
    }

    @Override
    public Farm getFarmByFarmId(String farmId) {
        return mapper.getFarmByFarmId(farmId);
    }

    @Override
    public Farm getFarmByItem(String farm_item) {
        return mapper.getFarmByItem(farm_item);
    }
}
