package com.pojo.payment.feign;

import com.pojo.payment.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 申明这是一个Feign客户端，并且指明服务id
 *
 * @author Evan
 */
@FeignClient(value = "app-order")
public interface UserFeignClient {

    @RequestMapping(value = "/order/queryUserById/{userId}", method = RequestMethod.GET)
    User queryUserById(@PathVariable("userId") Long userId);


}

