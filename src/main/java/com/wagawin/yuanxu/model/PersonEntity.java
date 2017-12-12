package com.wagawin.yuanxu.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "person", schema = "test", catalog = "")
public class PersonEntity {
    private int id;
    private String name;
    private int age;
    private Collection<ChildEntity> childrenById;
    private HouseEntity houseById;

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

        PersonEntity that = (PersonEntity) o;

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

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "personByPersonId")
    public Collection<ChildEntity> getChildrenById() {
        return childrenById;
    }

    public void setChildrenById(Collection<ChildEntity> childrenById) {
        this.childrenById = childrenById;
    }

    @OneToOne(mappedBy = "personById")
    public HouseEntity getHouseById() {
        return houseById;
    }

    public void setHouseById(HouseEntity houseById) {
        this.houseById = houseById;
    }
}
