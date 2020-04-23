package com.pojo.item.service;

import com.pojo.item.entity.Reservation;
import com.pojo.item.entity.Ticket;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReservationService {

    private static final Map<Long, Reservation> RESERVATION_MAP_1 = new HashMap<Long, Reservation>();
    private static final Map<Long, Reservation> RESERVATION_MAP_2 = new HashMap<Long, Reservation>();
    private static final Map<Long, Reservation> RESERVATION_MAP_3 = new HashMap<Long, Reservation>();


    private static final Map<Long, Map<Long, Reservation>> ALL_RESERVATION_MAP = new HashMap<Long, Map<Long, Reservation>>();

    static {// 准备一些静态数据,模拟数据库
        ALL_RESERVATION_MAP.put(1L, RESERVATION_MAP_1);
        ALL_RESERVATION_MAP.put(2L, RESERVATION_MAP_2);
        ALL_RESERVATION_MAP.put(3L, RESERVATION_MAP_3);
    }


    public Map<Long, Reservation> queryReservationByUserId(Long id) {
        return ALL_RESERVATION_MAP.get(id);
    }


    public Reservation reserveTicket(Long userId, Long t_id) {

        ALL_RESERVATION_MAP.get(userId).put(t_id, new Reservation(userId, t_id, System.currentTimeMillis()));
        new TicketService().changTicketState(t_id, 1);
        return ALL_RESERVATION_MAP.get(userId).get(t_id);
    }


    public void cancelReservation(Long userId, Long t_id) {
        ALL_RESERVATION_MAP.get(userId).remove(t_id);
        new TicketService().changTicketState(t_id, 0);
    }

    public void removeReservation(Long userId, Long t_id) {
        ALL_RESERVATION_MAP.get(userId).remove(t_id);
    }


}
