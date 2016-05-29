package com.project.order.dao;

import com.project.order.dto.Order;

import java.sql.SQLException;

/**
 * Created by igor on 24.05.16.
 */
public class OrderDAOImpl implements OrderDAO{
    @Override
    public int create(Order order) throws SQLException {
        return 0;
    }

    @Override
    public Order read(int id) throws SQLException {
        return null;
    }

    @Override
    public int update(Order order) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int id) throws SQLException {
        return 0;
    }
}
