package br.com.marcelocbasilio.cot.services;

import br.com.marcelocbasilio.cot.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;
    public double total(Order order) {
        double basic = order.getBasic();
        double discount = order.getDiscount();
        double shipment = shippingService.shipment(order);

        return basic * (1 - discount/100.0) + shipment;
    }
}
