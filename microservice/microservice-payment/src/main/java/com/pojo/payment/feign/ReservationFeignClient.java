package com.pojo.payment.feign;

import com.pojo.payment.entity.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * 申明这是一个Feign客户端，并且指明服务id
 *
 * @author Evan
 */
@FeignClient(value = "app-item")
public interface ReservationFeignClient {

    @RequestMapping(value = "/item/queryReservationByUserId/{id}", method = RequestMethod.GET)
    Map<Long, Reservation> queryReservationByUserId(@PathVariable("id") Long id);


    @RequestMapping(value = "/item/reserveTicket/{userId}/{t_id}", method = RequestMethod.GET)
    String reserveTicket(@PathVariable("userId") Long userId, @PathVariable("t_id") Long t_id);


    @RequestMapping(value = "/item/cancelReservationAfterPayment/{userId}/{t_id}", method = RequestMethod.GET)
    String cancelReservation(@PathVariable("userId") Long userId, @PathVariable("t_id") Long t_id);


}

