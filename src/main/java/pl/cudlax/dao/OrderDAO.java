package pl.cudlax.dao;

import java.util.List;

import pl.cudlax.domain.Order;

public interface OrderDAO {

	void createOrder(Order c);

	void removeOrder(Order c);

	List<Order> getAllOrders();

	Order getOrder(Long id);

}
