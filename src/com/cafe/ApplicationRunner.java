package com.cafe;

import com.cafe.service.Cafe;

public class ApplicationRunner {

    public static void main(String[] args) {
        new Cafe(10, 5).start();
    }
}
