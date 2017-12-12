package com.wagawin.yuanxu.dao;

import java.util.Collection;
import java.util.List;

import com.wagawin.yuanxu.model.ChildEntity;
import com.wagawin.yuanxu.model.MealEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MealEntityDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public List<MealEntity> getAllCountries() {
        Session session = this.sessionFactory.getCurrentSession();
        List<MealEntity> MealEntityList = session.createQuery("from MealEntity").list();
        return MealEntityList;
    }

    public MealEntity getMealEntity(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        MealEntity MealEntity = (MealEntity) session.load(MealEntity.class, new Integer(id));
        return MealEntity;
    }

    public MealEntity addMealEntity(MealEntity MealEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(MealEntity);
        return MealEntity;
    }

    public void updateMealEntity(MealEntity MealEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(MealEntity);
    }

    public void deleteMealEntity(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        MealEntity p = (MealEntity) session.load(MealEntity.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
    }

    public MealEntity getFavouriteMealByChild(String n){
        String hql = "from ChildEntity u where u.name = ?";
        Session session;
        session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, n);
        ChildEntity childEntity = (ChildEntity) query.uniqueResult();

        Collection<MealEntity> mealEntities= childEntity.getMealsById();
        while (mealEntities.iterator().hasNext()){
            return mealEntities.iterator().next();
        }
        return null;
    }


}
