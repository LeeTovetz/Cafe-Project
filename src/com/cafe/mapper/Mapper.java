package com.cafe.mapper;

public interface Mapper<F, T> {

    T map(F from);
}
