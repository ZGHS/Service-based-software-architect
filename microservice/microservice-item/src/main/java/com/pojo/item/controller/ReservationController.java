package com.pojo.item.controller;


import com.pojo.item.entity.Reservation;
import com.pojo.item.service.ReservationService;
import com.pojo.item.service.TicketService;
import com.pojo.item.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private UserService userService;
    @Autowired
    private TicketService ticketService;

    @GetMapping(value = "item/queryReservationByUserId/{userId}")
    public Map<Long, Reservation> queryReservationByUserId(@PathVariable("userId") Long userId) {
        if (userService.queryUserById(userId) == null) {
            return null;
        }
        if (userService.queryUserById(userId).getState() == 0) {
            return null;
        }
        return this.reservationService.queryReservationByUserId(userId);
    }


    @GetMapping(value = "/item/reserveTicket/{userId}/{t_id}")
    public String reserveTicket(@PathVariable("userId") Long userId, @PathVariable("t_id") Long t_id) {
        if (userService.queryUserById(userId) == null) {
            return "User doesn't exist!";
        }
        if (userService.queryUserById(userId).getState() == 0) {
            return "User doesn't login!";
        }

        if (ticketService.queryTicketById(t_id) == null) {
            return "Ticket doesn't exist!";
        }

        if (ticketService.queryTicketById(t_id).getTicket_state() == 1) {
            return "Ticket has been reserved!";
        }

        if (ticketService.queryTicketById(t_id).getTicket_state() == 2) {
            return "Ticket has been paid!";
        }

        this.reservationService.reserveTicket(userId, t_id);
        return "reserve successfully!";
    }

    @GetMapping(value = "/item/cancelReservation/{userId}/{t_id}")
    public String cancelReservation(@PathVariable("userId") Long userId, @PathVariable("t_id") Long t_id) {
        if (userService.queryUserById(userId) == null) {
            return "User doesn't exist!";
        }
        if (userService.queryUserById(userId).getState() == 0) {
            return "User doesn't login!";
        }

        if (ticketService.queryTicketById(t_id) == null) {
            return "Ticket doesn't exist!";
        }
        if (ticketService.queryTicketById(t_id).getTicket_state() == 0) {
            return "Ticket hasn't been reserved!";
        }

        if (ticketService.queryTicketById(t_id).getTicket_state() == 2) {
            return "Ticket has been paid!";
        }

        if (reservationService.queryReservationByUserId(userId).get(t_id) == null) {
            return "You didn't reserve this ticket!";
        }

        this.reservationService.cancelReservation(userId, t_id);
        return "Cancel reservation successfully!";

    }

    @GetMapping(value = "/item/cancelReservationAfterPayment/{userId}/{t_id}")
    public void cancelReservationAfterPayment(@PathVariable("userId") Long userId, @PathVariable("t_id") Long t_id) {
        this.reservationService.cancelReservation(userId, t_id);
    }
}

