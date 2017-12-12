package com.wagawin.yuanxu.service;

import java.util.List;

import com.wagawin.yuanxu.dao.PersonEntityDAO;
import com.wagawin.yuanxu.model.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("PersonEntityService")
public class PersonEntityService {

    @Autowired
    PersonEntityDAO PersonEntityDao;

    @Transactional
    public List<PersonEntity> getAllPersons() {
        return PersonEntityDao.getAllPersons();
    }

    @Transactional
    public PersonEntity getPersonEntity(int id) {
        return PersonEntityDao.getPersonEntity(id);
    }

    @Transactional
    public void addPersonEntity(PersonEntity PersonEntity) {
        PersonEntityDao.addPersonEntity(PersonEntity);
    }

    @Transactional
    public void updatePersonEntity(PersonEntity PersonEntity) {
        PersonEntityDao.updatePersonEntity(PersonEntity);

    }
    @Transactional
    public void deletePersonEntity(int id) {
        PersonEntityDao.deletePersonEntity(id);
    }

    @Transactional
    public PersonEntity getPersonByName(String n){
        return PersonEntityDao.getPersonByName(n);
    }

    @Transactional
    public PersonEntity getPersonByChildName(String n){return PersonEntityDao.getPersonByChildName(n);}

}
