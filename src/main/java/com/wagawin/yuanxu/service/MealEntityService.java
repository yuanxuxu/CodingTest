package com.wagawin.yuanxu.service;

import java.util.List;

import com.wagawin.yuanxu.model.MealEntity;
import com.wagawin.yuanxu.dao.MealEntityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("MealEntityService")
public class MealEntityService {

    @Autowired
    MealEntityDAO MealEntityDao;

    @Transactional
    public List<MealEntity> getAllCountries() {
        return MealEntityDao.getAllCountries();
    }

    @Transactional
    public MealEntity getMealEntity(int id) {
        return MealEntityDao.getMealEntity(id);
    }

    @Transactional
    public void addMealEntity(MealEntity MealEntity) {
        MealEntityDao.addMealEntity(MealEntity);
    }

    @Transactional
    public void updateMealEntity(MealEntity MealEntity) {
        MealEntityDao.updateMealEntity(MealEntity);

    }
    @Transactional
    public void deleteMealEntity(int id) {
        MealEntityDao.deleteMealEntity(id);
    }

    @Transactional
    public MealEntity getFavouriteMealByChild(String n){
        return MealEntityDao.getFavouriteMealByChild(n);
    }
}
