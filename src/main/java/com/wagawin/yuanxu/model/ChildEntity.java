package com.wagawin.yuanxu.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Table(name = "child", schema = "test", catalog = "")
public class ChildEntity {
    private int id;
    private String name;
    private int age;
    private String sex;
    private String hairColor;
    private String bicycleColor;
    private PersonEntity personByPersonId;
    private Collection<MealEntity> mealsById;

    @Basic
    @Column(name = "sex", nullable = false)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "hairColor")
    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    @Basic
    @Column(name = "bicycleColor")
    public String getBicycleColor() {
        return bicycleColor;
    }

    public void setBicycleColor(String bicycleColor) {
        this.bicycleColor = bicycleColor;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChildEntity that = (ChildEntity) o;

        if (id != that.id) return false;
        if (age != that.age) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    public PersonEntity getPersonByPersonId() {
        return personByPersonId;
    }

    public void setPersonByPersonId(PersonEntity personByPersonId) {
        this.personByPersonId = personByPersonId;
    }

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "childByChildId")
    public Collection<MealEntity> getMealsById() {
        return mealsById;
    }

    public void setMealsById(Collection<MealEntity> mealsById) {
        this.mealsById = mealsById;
    }
}
