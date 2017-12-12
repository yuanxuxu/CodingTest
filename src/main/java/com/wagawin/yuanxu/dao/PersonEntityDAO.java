package com.wagawin.yuanxu.dao;

import java.util.List;

import com.wagawin.yuanxu.model.ChildEntity;
import com.wagawin.yuanxu.model.PersonEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonEntityDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public List<PersonEntity> getAllPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<PersonEntity> PersonEntityList = session.createQuery("from PersonEntity").list();
        return PersonEntityList;
    }

    public PersonEntity getPersonEntity(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        PersonEntity PersonEntity = (PersonEntity) session.load(PersonEntity.class, new Integer(id));
        return PersonEntity;
    }

    public PersonEntity addPersonEntity(PersonEntity PersonEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(PersonEntity);
        return PersonEntity;
    }

    public void updatePersonEntity(PersonEntity PersonEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(PersonEntity);
    }

    public void deletePersonEntity(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        PersonEntity p = (PersonEntity) session.load(PersonEntity.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
    }

    public PersonEntity getPersonByName(String n){
        String hql = "from PersonEntity u where u.name = ?";
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, n);
        return (PersonEntity) query.uniqueResult();
    }

    public PersonEntity getPersonByChildName(String n){
        String hql = "from ChildEntity u where u.name = ?";
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, n);
        ChildEntity childEntity = (ChildEntity) query.uniqueResult();

        int personId = childEntity.getPersonByPersonId().getId();
        String hql2 = "from PersonEntity u where u.id = ?";
        Query query2 = session.createQuery(hql2);
        query2.setParameter(0, personId);
        PersonEntity personEntity = (PersonEntity) query2.uniqueResult();
        return personEntity;
    }

}
