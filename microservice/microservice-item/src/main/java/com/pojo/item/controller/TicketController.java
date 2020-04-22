package com.pojo.item.controller;


import com.pojo.item.entity.Ticket;
import com.pojo.item.service.TicketService;
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
public class TicketController {
    @Autowired
    private TicketService ticketService;

    /**
     * 对外提供接口服务，查询商品信息
     */
    @GetMapping(value = "item/restTicket")
    public Map<Long, Ticket> getRestTicket() {
        return this.ticketService.getRestTicket();
    }

    @GetMapping(value = "item/getAllTickets")
    public Map<Long, Ticket> getAllTickets() {
        return this.ticketService.getAllTickets();
    }


    @GetMapping(value = "item/changTicketState/{t_id}/{state}")
    public String changTicketState(@PathVariable("t_id") Long t_id, @PathVariable("state") Integer state) {

        if (this.ticketService.queryTicketById(t_id) != null) {
            this.ticketService.changTicketState(t_id, state);
            return "successful";
        }
        return "failed";
    }


    @GetMapping(value = "item/queryTicketById/{t_id}")
    public Ticket queryTicketById(@PathVariable("t_id") Long t_id) {
        return ticketService.queryTicketById(t_id);
    }

}

