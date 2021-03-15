package pers.lcy.graduationdesign.model;

import java.util.Date;

public class LoginTicket {
    private Integer id;

    private Integer userId;

    private String ticket;

    private Date expiredTime;

    private Integer state;

    public LoginTicket(Integer id, Integer userId, String ticket, Date expiredTime, Integer state) {
        this.id = id;
        this.userId = userId;
        this.ticket = ticket;
        this.expiredTime = expiredTime;
        this.state = state;
    }

    public LoginTicket() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket == null ? null : ticket.trim();
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}