package com.wagawin.yuanxu.service;

import java.util.List;

import com.wagawin.yuanxu.model.ChildEntity;
import com.wagawin.yuanxu.dao.ChildEntityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ChildEntityService")
public class ChildEntityService {

    @Autowired
    ChildEntityDAO ChildEntityDao;

    @Transactional
    public List<ChildEntity> getAllChilds() {
        return ChildEntityDao.getAllChilds();
    }

    @Transactional
    public ChildEntity getChildEntity(int id) {
        return ChildEntityDao.getChildEntity(id);
    }

    @Transactional
    public void addChildEntity(ChildEntity ChildEntity) {
        ChildEntityDao.addChildEntity(ChildEntity);
    }

    @Transactional
    public void updateChildEntity(ChildEntity ChildEntity) {
        ChildEntityDao.updateChildEntity(ChildEntity);

    }
    @Transactional
    public void deleteChildEntity(int id) {
        ChildEntityDao.deleteChildEntity(id);
    }

    @Transactional
    public ChildEntity getChildByName(String name){
        return ChildEntityDao.getChildByName(name);
    }
}
