package com.nagarro.order.repository.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.order.entity.Order;
import com.nagarro.order.repository.OrderRepository;

import io.opentracing.Span;
import io.opentracing.Tracer;

@Service
public class OrderRepositoryImpl implements OrderRepository {

	private Tracer tracer;

	@Autowired
	OrderRepositoryImpl(Tracer tracer) {
		this.tracer = tracer;
	}

	@Override
	public List<Order> getOrdersByUserId(String userId, Span parentSpan) {
		Span span = tracer.buildSpan("Order Repository --> getOrdersByUserId").asChildOf(parentSpan).start();
		List<Order> orders = Arrays.asList(
				new Order(1, 1000, "2020-06-24T08:52:59+00:00"),
				new Order(2, 2000, "2020-06-23T08:52:59+00:00"));
		span.finish();

		return orders;
	}

}
