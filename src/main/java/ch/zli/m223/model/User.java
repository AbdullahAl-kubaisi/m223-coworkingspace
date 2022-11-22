package ch.zli.m223.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int age;
    private String description;
    private Date register_date;
    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;
    private String job;

    @OneToMany()
    private List<User> othermembers = new ArrayList<User>();
    @OneToMany(mappedBy = "user")
    private List<Booking> bookingList = new ArrayList<Booking>();
    @ManyToMany()
    @JoinTable(name = "CanteenToUser", joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "snack_idfs")})
    private List<Canteen> snacksList = new ArrayList<Canteen>();


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

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public List<Canteen> getSnacksList() {
        return snacksList;
    }

    public void setSnacksList(List<Canteen> snacksList) {
        this.snacksList = snacksList;
    }
}