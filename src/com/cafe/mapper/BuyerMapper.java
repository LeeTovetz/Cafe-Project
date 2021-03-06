package com.cafe.mapper;

import com.cafe.csv.BuyerRow;
import com.cafe.model.Order;
import com.cafe.model.Product;
import com.cafe.service.Buyer;

import java.util.List;

public class BuyerMapper implements Mapper<Buyer, BuyerRow> {

    @Override
    public BuyerRow map(Buyer buyer) {
        return new BuyerRow(
                buyer.getId(),
                buyer.getOrders().size(),
                getCaloriesAvg(buyer.getOrders()),
                getOrderPriceAvg(buyer.getOrders())
        );
    }

    private Double getCaloriesAvg(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.products().stream())
                .mapToInt(Product::calories)
                .average()
                .orElse(0.0);
    }

    private Double getOrderPriceAvg(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.products().stream())
                .mapToInt(Product::price)
                .average()
                .orElse(0.0);
    }
}
