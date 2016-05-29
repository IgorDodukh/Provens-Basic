package com.project.order.dao;

import com.project.order.dto.Order;

import java.sql.SQLException;

/**
 * Created by igor on 24.05.16.
 */
public interface OrderDAO {

    int create(Order order) throws SQLException;

    Order read(int id) throws SQLException;

    int update(Order order) throws SQLException;

    int delete(int id) throws SQLException;

}
