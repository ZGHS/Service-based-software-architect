package com.pojo.payment.feign;

import com.pojo.payment.entity.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "app-item")
public interface TicketFeignClient {
    @RequestMapping(value = "/item/changTicketState/{t_id}/{state}", method = RequestMethod.GET)
    String changTicketState(@PathVariable("t_id") Long t_id, @PathVariable("state") Integer state);

    @RequestMapping(value = "/item/queryTicketById/{t_id}", method = RequestMethod.GET)
    Ticket queryTicketById(@PathVariable("t_id") Long t_id);
}
