package com.wagawin.yuanxu.dao;

import java.util.List;

import com.wagawin.yuanxu.model.HouseEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HouseEntityDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public List<HouseEntity> getAllHouses() {
        Session session = this.sessionFactory.getCurrentSession();
        List<HouseEntity> HouseEntityList = session.createQuery("from HouseEntity").list();
        return HouseEntityList;
    }

    public HouseEntity getHouseEntity(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        HouseEntity HouseEntity = (HouseEntity) session.load(HouseEntity.class, new Integer(id));
        return HouseEntity;
    }

    public HouseEntity addHouseEntity(HouseEntity HouseEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(HouseEntity);
        return HouseEntity;
    }

    public void updateHouseEntity(HouseEntity HouseEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(HouseEntity);
    }

    public void deleteHouseEntity(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        HouseEntity p = (HouseEntity) session.load(HouseEntity.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
    }

    public HouseEntity getHouseByPersonId(int id){
        String hql = "from HouseEntity u where u.id = ?";
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        return (HouseEntity) query.uniqueResult();
    }

}
