package com.pojo.payment.service;

import com.pojo.payment.entity.Ticket;
import com.pojo.payment.feign.TicketFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private TicketFeignClient ticketFeignClient;



    public String changTicketState(Long t_id, Integer state) {
        return ticketFeignClient.changTicketState(t_id, state);
    }


    public Ticket queryTicketById(Long t_id) {
        return ticketFeignClient.queryTicketById(t_id);
    }
}


