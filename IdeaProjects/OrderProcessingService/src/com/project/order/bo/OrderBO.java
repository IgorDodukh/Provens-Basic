package com.project.order.bo;

import com.project.order.bo.exception.BOException;
import com.project.order.dto.Order;

/**
 * Created by igor on 24.05.16.
 */
public interface OrderBO {
    boolean placeOrder(Order order) throws BOException;

    boolean cancelOrder(int id) throws BOException;

    boolean deleteOrder(int id) throws BOException;
}
