package com.project.order.bo.exception;

import java.sql.SQLException;

/**
 * Created by igor on 24.05.16.
 */
public class BOException extends Exception {
    public BOException(SQLException e) {
        super(e);
    }
}
