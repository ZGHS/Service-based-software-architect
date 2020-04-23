package com.pojo.payment.controller;


import com.pojo.payment.entity.Payment;
import com.pojo.payment.service.PaymentService;
import com.pojo.payment.service.ReservationService;
import com.pojo.payment.service.TicketService;
import com.pojo.payment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Evan
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private PaymentService paymentService;


    @Autowired
    private ReservationService reservationService;
    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/payment/queryPaymentByUserId/{userId}")
    public Map<Long, Payment> queryPaymentByUserId(@PathVariable("userId") Long userId) {
        if (userService.queryUserById(userId) == null) {
            return null;
        }
        if (userService.queryUserById(userId).getState() == 0) {
            return null;
        }
        return this.paymentService.queryPaymentByUserId(userId);
    }


    @GetMapping(value = "/payment/payTicket/{userId}/{t_id}")
    public String payTicket(@PathVariable("userId") Long userId, @PathVariable("t_id") Long t_id) {
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
            return "You didn't  reserve this ticket!";
        }
        this.paymentService.payTicket(userId, t_id);
        reservationService.removeReservation(userId, t_id);
        return "pay successfully!";
    }

    @GetMapping(value = "/payment/cancelPayment/{userId}/{t_id}")
    public String cancelPayment(@PathVariable("userId") Long userId, @PathVariable("t_id") Long t_id) {
        if (userService.queryUserById(userId) == null) {
            return "User doesn't exist!";
        }
        if (userService.queryUserById(userId).getState() == 0) {
            return "User doesn't login!";
        }

        if (ticketService.queryTicketById(t_id) == null) {
            return "Ticket doesn't exist!";
        }

//        if (ticketService.queryTicketById(t_id).getTicket_state() == 0) {
//            return "Ticket hasn't been reserved!";
//        }

        if (ticketService.queryTicketById(t_id).getTicket_state() == 1) {
            return "Ticket hasn't  been paid!";
        }
        if (paymentService.queryPaymentByUserId(userId).get(t_id) == null) {
            return "You didn't  pay for this ticket!";
        }
        this.paymentService.cancelPayment(userId, t_id);
        return "cancel successfully!";
    }


}

