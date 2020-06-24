package com.nagarro.order.repository;

import java.util.List;

import com.nagarro.order.entity.Order;

import io.opentracing.Span;

public interface OrderRepository {

	List<Order> getOrdersByUserId(String userId, Span rootSpan);

}
