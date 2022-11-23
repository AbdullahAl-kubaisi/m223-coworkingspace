package ch.zli.m223.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "coworking_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    private int age;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Role role;

    private String job;

    @OneToMany()
    private List<User> othermembers = new ArrayList<User>();

    @OneToMany(mappedBy = "user")
    private List<Booking> bookingList = new ArrayList<Booking>();

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "canteen_user", joinColumns = @JoinColumn(name = "user_idfs"), inverseJoinColumns = @JoinColumn(name = "snack_idfs"))
    private List<Canteen> canteen = new ArrayList<Canteen>();



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    public List<User> getOthermembers() {
        return othermembers;
    }

    public void setOthermembers(List<User> othermembers) {
        this.othermembers = othermembers;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }


    public List<Canteen> getCanteen() {
        return this.canteen;
    }

    public void setCanteen(List<Canteen> canteen) {
        this.canteen = canteen;
    }

    
}