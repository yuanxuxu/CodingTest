package com.wagawin.yuanxu.service;

import java.util.List;

import com.wagawin.yuanxu.dao.HouseEntityDAO;
import com.wagawin.yuanxu.model.HouseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("HouseEntityService")
public class HouseEntityService {

    @Autowired
    HouseEntityDAO HouseEntityDao;

    @Transactional
    public List<HouseEntity> getAllHouses() {
        return HouseEntityDao.getAllHouses();
    }

    @Transactional
    public HouseEntity getHouseEntity(int id) {
        return HouseEntityDao.getHouseEntity(id);
    }

    @Transactional
    public void addHouseEntity(HouseEntity HouseEntity) {
        HouseEntityDao.addHouseEntity(HouseEntity);
    }

    @Transactional
    public void updateHouseEntity(HouseEntity HouseEntity) {
        HouseEntityDao.updateHouseEntity(HouseEntity);

    }
    @Transactional
    public void deleteHouseEntity(int id) {
        HouseEntityDao.deleteHouseEntity(id);
    }

    @Transactional
    public HouseEntity getHouseByPersonId(int id){
        return HouseEntityDao.getHouseByPersonId(id);
    }
}
