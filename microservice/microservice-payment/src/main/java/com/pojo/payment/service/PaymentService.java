package com.pojo.payment.service;

import com.pojo.payment.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class PaymentService {

    @Autowired
    private TicketService ticketService;


    private static final Map<Long, Payment> PAYMENT_MAP_1 = new HashMap<Long, Payment>();
    private static final Map<Long, Payment> PAYMENT_MAP_2 = new HashMap<Long, Payment>();
    private static final Map<Long, Payment> PAYMENT_MAP_3 = new HashMap<Long, Payment>();


    private static final Map<Long, Map<Long, Payment>> ALL_PAYMENT_MAP = new HashMap<Long, Map<Long, Payment>>();

    static {// 准备一些静态数据,模拟数据库
        ALL_PAYMENT_MAP.put(1L, PAYMENT_MAP_1);
        ALL_PAYMENT_MAP.put(2L, PAYMENT_MAP_2);
        ALL_PAYMENT_MAP.put(3L, PAYMENT_MAP_3);
    }

    public Map<Long, Payment> queryPaymentByUserId(Long id) {
        return ALL_PAYMENT_MAP.get(id);
    }


    public Payment payTicket(Long userId, Long t_id) {
        ALL_PAYMENT_MAP.get(userId).put(t_id, new Payment(userId, t_id, System.currentTimeMillis()));
        ticketService.changTicketState(t_id, 2);
        return ALL_PAYMENT_MAP.get(userId).get(t_id);
    }


    public void cancelPayment(Long userId, Long t_id) {
        ALL_PAYMENT_MAP.get(userId).remove(t_id);
        ticketService.changTicketState(t_id, 0);
    }


}