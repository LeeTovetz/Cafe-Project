package com.cafe.service;

import com.cafe.model.Order;
import com.cafe.model.Product;
import com.cafe.model.ProductFactory;
import com.cafe.model.ProductType;
import com.cafe.util.CafeConst;
import com.cafe.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

public class Buyer implements Runnable {

    private static int idGenerator = 1;

    private final Integer id;
    private final List<Order> orders = new ArrayList<>();
    private final BlockingQueue<Order> allOrders;

    public Buyer(BlockingQueue<Order> allOrders) {
        this.id = idGenerator++;
        this.allOrders = allOrders;
    }


    @Override
    public void run() {
        while (true) {
            try {
                var productsNumber = RandomUtil.get(CafeConst.MAX_PRODUCT_COUNT);
                var products = IntStream.range(0, productsNumber)
                        .mapToObj(i -> getRandomProduct())
                        .toList();
                var order = new Order(id, products);
                allOrders.put(order);
                orders.add(order);

                Thread.sleep(CafeConst.BUYER_WAIT_TIME * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Product getRandomProduct() {
        var types = ProductType.values();
        var randomIndex = RandomUtil.get(types.length);
        return ProductFactory.get(types[randomIndex]);
    }

    public Integer getId() {
        return id;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
