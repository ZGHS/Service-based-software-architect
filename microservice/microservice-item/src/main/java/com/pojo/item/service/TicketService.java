package com.pojo.item.service;

import com.pojo.item.entity.Ticket;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TicketService {

    private static final Map<Long, Ticket> TICKET_MAP = new HashMap<Long, Ticket>();

    static {// 准备一些静态数据,模拟数据库
        TICKET_MAP.put(1L, new Ticket(1L, 0));
        TICKET_MAP.put(2L, new Ticket(2L, 0));
        TICKET_MAP.put(3L, new Ticket(3L, 0));
        TICKET_MAP.put(4L, new Ticket(4L, 0));
        TICKET_MAP.put(5L, new Ticket(5L, 0));
        TICKET_MAP.put(6L, new Ticket(6L, 0));
        TICKET_MAP.put(7L, new Ticket(7L, 0));
        TICKET_MAP.put(8L, new Ticket(8L, 0));
        TICKET_MAP.put(9L, new Ticket(9L, 0));
        TICKET_MAP.put(10L, new Ticket(10L, 0));
    }

    /**
     * 模拟实现票查询
     */
    public Ticket queryTicketById(Long id) {
        return TICKET_MAP.get(id);
    }

    public Map<Long, Ticket> getAllTickets() {
        return TICKET_MAP;
    }

    public void changTicketState(Long id, Integer state) {
        TICKET_MAP.put(id, new Ticket(id, state));
    }


    public Map<Long, Ticket> getRestTicket() {
        Map<Long, Ticket> result_map = new HashMap<Long, Ticket>();
        for (Map.Entry<Long, Ticket> entry : TICKET_MAP.entrySet()) {
            Long key = entry.getKey();
            Ticket value = entry.getValue();
            if (value.getTicket_state() == 0) {
                result_map.put(key, value);
            }
        }
        return result_map;
    }


}

