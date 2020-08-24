package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import entity.Customer;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class CustomerDAOImpl implements CustomerDAO {

    private Session session;
    @Override
    public String getLastCustomerId() throws Exception {
        return (String)session.createNativeQuery("SELECT * FROM Customer ORDER BY id DESC LIMIT 1").uniqueResult();

    }

    @Override
    public List<Customer> findAll() throws Exception {
        return session.createQuery("FROM Customer",Customer.class).list();
    }

    @Override
    public Customer find(String key) throws Exception {
      return  session.get(Customer.class,key);
    }

    @Override
    public void save(Customer customer) throws Exception {
        session.save(customer);
    }

    @Override
    public void update(Customer customer) throws Exception {
      session.update(customer);
    }

    @Override
    public void delete(String key) throws Exception {
        session.delete(session.get(Customer.class,key));
    }

    @Override
    public void setSession(Session session) {
        this.session=session;
    }
}
