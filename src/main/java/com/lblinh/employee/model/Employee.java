package com.lblinh.employee.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

// import lombok.Data;

// @Data

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "sex", nullable = false)
    private int sex;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "money", nullable = false)
    private int money;

    @Column(name = "start_date", nullable = false)
    private String startDate;

    @Column(name = "url_image", nullable = true)
    private String urlImage;

    // @OneToOne(mappedBy = "team")
    // @JsonBackReference

    // @JsonIgnore
    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Working> working = new ArrayList<Working>();

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Advance> advance = new ArrayList<Advance>();

    public List<Working> getWorking() {
        return working;
    }

    public void setWorking(List<Working> working) {
        this.working = working;
    }

    public List<Advance> getAdvance() {
        return advance;
    }

    public void setAdvance(List<Advance> advance) {
        this.advance = advance;
    }

    public void setEmployee(Employee employee) {
        this.fullName = employee.fullName;
        this.sex = employee.sex;
        this.age = employee.age;
        this.phone = employee.phone;
        this.address = employee.address;
        this.money = employee.money;
        this.startDate = employee.startDate;
        this.urlImage = employee.urlImage;
        this.team.setId(employee.team.getId());
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        // this.team = team.getId();
        // ;
        this.team = team;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
