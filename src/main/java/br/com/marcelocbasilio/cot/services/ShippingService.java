package br.com.marcelocbasilio.cot.services;

import br.com.marcelocbasilio.cot.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {
        double basic = order.getBasic();
        double shipment = 0.00;

        if (basic < 100.00) {
            shipment = 20.00;
        } else if (basic < 200.00) {
            shipment = 12.00;
        }

        return shipment;
    }
}
