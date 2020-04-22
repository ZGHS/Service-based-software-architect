package com.pojo.item.entity;

public class Ticket {

    private Long id;

    //    0:空闲    1:被预定    2:已卖出
    private Integer ticket_state;


    public Ticket() {
    }

    public Ticket(Long id, Integer ticket_state) {
        this.id = id;
        this.ticket_state = ticket_state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTicket_state() {
        return ticket_state;
    }

    public void setTicket_state(Integer ticket_state) {
        this.ticket_state = ticket_state;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", ticket_state=" + ticket_state +
                '}';
    }
}
