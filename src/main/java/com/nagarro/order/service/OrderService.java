package com.nagarro.order.service;

import java.util.List;

import com.nagarro.order.entity.Order;

import io.opentracing.Span;

public interface OrderService {

	List<Order> getOrdersByUserId(String userId, Span rootSpan);

}
