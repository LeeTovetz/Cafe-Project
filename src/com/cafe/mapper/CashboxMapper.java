package com.cafe.mapper;

import com.cafe.csv.CashboxRow;
import com.cafe.model.Order;
import com.cafe.model.Product;
import com.cafe.service.Cashbox;

import java.util.List;

public class CashboxMapper implements Mapper<Cashbox, CashboxRow> {

    @Override
    public CashboxRow map(Cashbox cashbox) {
        return new CashboxRow(
                cashbox.getId(),
                cashbox.getOrders().size(),
                getOrderPriceSum(cashbox.getOrders())
        );
    }

    private Integer getOrderPriceSum(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.products().stream())
                .mapToInt(Product::price)
                .sum();
    }
}