package com.cafe.model;

public record Product(ProductType type,
                      int calories,
                      int price) {
}
