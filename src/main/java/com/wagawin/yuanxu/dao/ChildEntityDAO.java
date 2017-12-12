package com.wagawin.yuanxu.dao;

import java.util.List;

import com.wagawin.yuanxu.model.ChildEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChildEntityDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public List<ChildEntity> getAllChilds() {
        Session session = this.sessionFactory.getCurrentSession();
        List<ChildEntity> ChildEntityList = session.createQuery("from ChildEntity").list();
        return ChildEntityList;
    }

    public ChildEntity getChildEntity(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        ChildEntity ChildEntity = (ChildEntity) session.load(ChildEntity.class, new Integer(id));
        return ChildEntity;
    }

    public ChildEntity addChildEntity(ChildEntity ChildEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(ChildEntity);
        return ChildEntity;
    }

    public void updateChildEntity(ChildEntity ChildEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(ChildEntity);
    }

    public void deleteChildEntity(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        ChildEntity p = (ChildEntity) session.load(ChildEntity.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
    }

    public ChildEntity getChildByName(String name){
        String hql = "from ChildEntity u where u.name = ?";
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, name);
        ChildEntity childEntity = (ChildEntity) query.uniqueResult();
        return childEntity;
    }
}
