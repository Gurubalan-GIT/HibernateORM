package com.its.guru.hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "entityclass", schema = "test")
public class EntityClass {
    private int key;
    private String email;
    private String password;

    @Id
    @Column(name = "`key`")
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Basic
    @Column(name = "`Email`")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "`Password`")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityClass that = (EntityClass) o;
        return key == that.key &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(key, email, password);
    }
}
