package com.its.guru.hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "table1", schema = "test")
public class EntityClass {
    private int key;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String address;
    private String gender;

    @Id
    @Column(name = "`key`")
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Basic
    @Column(name = "`FirstName`")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "`LastName`")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "`Username`")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "`Password`")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "`Address`")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "`Gender`")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityClass that = (EntityClass) o;
        return key == that.key &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(address, that.address) &&
                Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {

        return Objects.hash(key, firstName, lastName, username, password, address, gender);
    }
}
