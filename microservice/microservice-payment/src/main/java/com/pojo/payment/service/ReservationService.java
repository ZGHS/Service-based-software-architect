package com.pojo.payment.service;

import com.pojo.payment.entity.Reservation;
import com.pojo.payment.feign.ReservationFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ReservationService {

    @Autowired
    private ReservationFeignClient reservationFeignClient;

    public Map<Long, Reservation> queryReservationByUserId(Long id) {
        Map<Long, Reservation> result = reservationFeignClient.queryReservationByUserId(id);
        return result;
    }


    public String reserveTicket(Long userId,Long t_id) {
        return reservationFeignClient.reserveTicket(userId,t_id);
    }



    public String cancelReservation(Long userId,Long t_id) {
        return reservationFeignClient.cancelReservation(userId,t_id);
    }
}

