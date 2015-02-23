package pl.cudlax.dao.impl;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import pl.cudlax.domain.Order;

/**
 * @author Zari
 *
 */
public class OrderDAOImplTest {
	
	@Mock
	private SessionFactory sf;
	
	@Mock
	private Session session;
	
	@Mock
	private Transaction transaction;
	
	@InjectMocks
	private OrderDAOImpl dao;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Mockito.when(sf.openSession()).thenReturn(session);
		Mockito.when(session.getTransaction()).thenReturn(transaction);
	}

	@Test
	public void testCreateOrder() {
		Order o = new Order();
		dao.createOrder(o);
	}

	@Test
	public void testRemoveOrder() {
		Order o = new Order();
		dao.removeOrder(o);
	}

}
