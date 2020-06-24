package com.nagarro.order.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.order.entity.Order;
import com.nagarro.order.repository.OrderRepository;
import com.nagarro.order.service.OrderService;

import io.opentracing.Span;
import io.opentracing.Tracer;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
	private Tracer tracer;

	@Autowired
	OrderServiceImpl(OrderRepository orderRepository, Tracer tracer) {
		this.tracer = tracer;
		this.orderRepository = orderRepository;
	}

	@Override
	public List<Order> getOrdersByUserId(String userId, Span rootSpan) {
		List<Order> orders = new ArrayList<>();
		Span span = tracer.buildSpan("Order Service --> getOrdersByUserId").asChildOf(rootSpan).start();
		orders = orderRepository.getOrdersByUserId(userId, span);
		span.setTag("http.status_code", 200);
		span.finish();
		return orders;
	}

}
