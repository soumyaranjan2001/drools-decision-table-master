package com.spring.drools.demo;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MegaOfferController {
    @Autowired
    private KieSession session;

    @PostMapping("/order")
    public Order orderNow(@RequestBody Order order) {
        System.out.println("=== BEFORE RULES ===");
        System.out.println(order);
        
        session.insert(order);
        int fired = session.fireAllRules();
        
        System.out.println("=== AFTER RULES ===");
        System.out.println("Rules fired: " + fired);
        System.out.println(order);
        
        return order;
    }
}
