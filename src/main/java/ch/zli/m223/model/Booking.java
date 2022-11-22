package ch.zli.m223.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private  Status Status;
    @ManyToOne()
    private User user;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
    private Date startDate;
    private Date endDate;
    private boolean halfDay;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ch.zli.m223.model.Status getStatus() {
        return Status;
    }

    public void setStatus(ch.zli.m223.model.Status status) {
        Status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoomToUse() {
        return room;
    }

    public void setRoomToUse(Room room) {
        this.room = room;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isHalfDay() {
        return halfDay;
    }

    public void setHalfDay(boolean halfDay) {
        this.halfDay = halfDay;
    }
}
