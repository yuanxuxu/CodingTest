package com.wagawin.yuanxu.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "meal", schema = "test", catalog = "")
public class MealEntity {
    private int id;
    private String name;
    private Date invented;
    private ChildEntity childByChildId;

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
    @Column(name = "invented", nullable = true)
    public Date getInvented() {
        return invented;
    }

    public void setInvented(Date invented) {
        this.invented = invented;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MealEntity that = (MealEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (invented != null ? !invented.equals(that.invented) : that.invented != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (invented != null ? invented.hashCode() : 0);
        return result;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "child_id", referencedColumnName = "id", nullable = false)
    public ChildEntity getChildByChildId() {
        return childByChildId;
    }

    public void setChildByChildId(ChildEntity childByChildId) {
        this.childByChildId = childByChildId;
    }
}
