package com.embl.ebi.person.model;

import com.sun.istack.NotNull;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
public class Person implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty(message = "first name can not be empty")
    private String firstName;
    @NotEmpty(message = "last name can not be empty")
    private String lastName;
    @NotNull
    private Integer age;
    @NotEmpty(message = "favorite colour can not be empty")
    private String favoriteColour;
    @ElementCollection
    private List<String> hobby;

    public Person() {
    }


    public Person(String firstName, String lstName,Integer age,String favoriteColour,List<String> hobby) {
        this.firstName = firstName;
        this.lastName = lstName;
        this.age = age;
        this.favoriteColour = favoriteColour;
        this.hobby = hobby;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFavoriteColour() {
        return favoriteColour;
    }

    public void setFavoriteColour(String favoriteColour) {
        this.favoriteColour = favoriteColour;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }
}
