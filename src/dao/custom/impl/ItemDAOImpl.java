package dao.custom.impl;

import java.util.List;

import org.hibernate.Session;

import dao.custom.ItemDAO;
import entity.Item;

public class ItemDAOImpl implements ItemDAO {

  private Session session;

  public String getLastItemCode() throws Exception {
    return (String) session.createQuery("SELECT i.code FROM entity.Item i ORDER BY i.code DESC").setMaxResults(1).list().get(0);

  }

  @Override
  public List<Item> findAll() throws Exception {
    return session.createQuery("FROM entity.Item", Item.class).list();
  }

  @Override
  public Item find(String key) throws Exception {
    return session.get(Item.class, key);
  }

  @Override
  public void save(Item item) throws Exception {
    session.save(item);
  }

  @Override
  public void update(Item item) throws Exception {
    session.update(item);
  }

  @Override
  public void delete(String key) throws Exception {
    session.delete(session.load(Item.class, key));
  }

  @Override
  public void setSession(Session session) {
    this.session = session;
  }
}
