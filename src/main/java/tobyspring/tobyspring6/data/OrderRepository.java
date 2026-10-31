package tobyspring.tobyspring6.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import tobyspring.tobyspring6.order.Order;

public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Order order) {
        entityManager.persist(order);
    }
}
