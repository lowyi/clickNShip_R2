package com.clicknship.order.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clicknship.order.service.OrderService;
import com.clicknship.common.controller.BaseController;
import com.clicknship.common.exception.BusinessException;
import com.clicknship.model.order.CreateOrderDTO;
import com.clicknship.model.order.OrderDTO;
import com.clicknship.model.order.OrderSearchDTO;

@RestController
@RequestMapping(value = "/order")
@RefreshScope
public class OrderController extends BaseController {

	@Autowired
	private OrderService orderService;
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@PostMapping("/createOrder")
	public ResponseEntity<List<OrderDTO>> createOrder(@RequestBody(required = true) CreateOrderDTO createOrder) throws BusinessException {
		return ResponseEntity.ok().body(orderService.createOrder(createOrder));
	}

	@GetMapping("/order/{id}")
	public ResponseEntity<OrderDTO> getOrderById(@PathVariable("id") Long orderId) {
		Optional<OrderDTO> result = orderService.findOrderById(orderId);
		return result.map(order -> ResponseEntity.ok().body(order)).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("/cancelPayment")
	public ResponseEntity<Void> cancelPayment(@RequestBody(required = true) List<Long> orderIds) {
		orderService.cancelPayment(orderIds);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/confirmPayment/{payOption}")
	public ResponseEntity<Void> confirmPayment(@PathVariable("payOption") @NotNull String payOption, @RequestBody(required = true) List<Long> orderIds) throws BusinessException {
		orderService.confirmPayment(payOption, orderIds);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/orderReceived")
	public ResponseEntity<Void> orderReceived(@RequestBody(required = true) OrderDTO order) {
		orderService.orderReceived(order);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/confirmDelivery")
	public ResponseEntity<Void> confirmDelivery(@RequestBody(required = true) OrderDTO order) {
		orderService.confirmDelivery(order);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/order/search")
	public ResponseEntity<List<OrderDTO>> getCatalogueBySearchDTO(@RequestBody(required = false) OrderSearchDTO searchDTO) {
		List<OrderDTO> results = orderService.searchOrders(searchDTO);
		return ResponseEntity.ok().body(results);
	}
}
