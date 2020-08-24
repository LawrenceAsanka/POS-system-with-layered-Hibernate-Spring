package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.QueryDAO;
import entity.CustomEntity;

import java.sql.ResultSet;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public CustomEntity getOrderDetail(String orderId) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT  o.id, c.name, o.date FROM `Order` o\n" +
                "INNER JOIN Customer c on o.customerId = c.id\n" +
                "WHERE o.id=?", orderId);
        if (rst.next()) {
            return new CustomEntity(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3));
        }
        return null;
    }

    @Override
    public CustomEntity getOrderDetail2(String orderId) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT" +
                "  c.id, c.name, o.id FROM `Order` o\n" +
                "INNER JOIN Customer c on o.customerId = c.id\n" +
                "WHERE o.id=?", orderId);
        if (rst.next()) {
            return new CustomEntity(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3));
        }
        return null;
    }
}
