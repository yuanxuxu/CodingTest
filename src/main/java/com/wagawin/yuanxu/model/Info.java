package com.wagawin.yuanxu.model;

public class Info {
    private PersonEntity PersonEntity;
    private MealEntity MealEntity;

    public Info(PersonEntity PersonEntity, MealEntity MealEntity) {
        this.PersonEntity = PersonEntity;
        this.MealEntity = MealEntity;
    }

    public PersonEntity getPersonEntity() {
        return PersonEntity;
    }

    public void setPersonEntity(PersonEntity PersonEntity) {
        this.PersonEntity = PersonEntity;
    }

    public MealEntity getMealEntity() {
        return MealEntity;
    }

    public void setMealEntity(MealEntity MealEntity) {
        this.MealEntity = MealEntity;
    }
}
