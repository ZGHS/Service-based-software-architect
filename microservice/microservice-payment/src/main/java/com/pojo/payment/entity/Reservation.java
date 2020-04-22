package com.pojo.payment.entity;

public class Reservation {

    private Long user_id;
    private Long ticket_id;
    private Long time_stamp;

    public Reservation() {
    }

    public Reservation(Long user_id, Long ticket_id, Long time_stamp) {
        this.user_id = user_id;
        this.ticket_id = ticket_id;
        this.time_stamp = time_stamp;
    }


    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Long getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(Long time_stamp) {
        this.time_stamp = time_stamp;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "user_id=" + user_id +
                ", ticket_id=" + ticket_id +
                ", time_stamp=" + time_stamp +
                '}';
    }
}
