package com.app.shopping.notificationservice;

import org.springframework.stereotype.Service;

@Service
public class EmailSender {

    public void sendEmail(String orderNumber){
        System.out.println("Order Placed Successfully - Order Number is" + orderNumber);
        System.out.println("Email Sent");
    }
}
