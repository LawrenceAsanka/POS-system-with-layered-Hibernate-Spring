package lk.ijse.dep.pos.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

import lk.ijse.dep.pos.entity.SuperEntity;

public abstract  class CrudDAOImpl<T extends SuperEntity,ID extends Serializable> implements CrudDAO<T,ID>{

  protected Session session;
  private Class<T> entity;

  public  CrudDAOImpl(){
   entity = (Class<T>) (((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
  }

  @Override
  public void setSession(Session session) {
    this.session = session;
  }


  @Override
  public List<T> findAll() throws Exception {
    return session.createQuery("FROM "+ entity.getName()).list();
  }

  @Override
  public T find(ID key) throws Exception {
    return  session.get(entity,key);
  }

  @Override
  public void save(T entity) throws Exception {
    session.save(entity);
  }

  @Override
  public void update(T entity) throws Exception {
    session.update(entity);
  }

  @Override
  public void delete(ID key) throws Exception {
    session.delete(session.get(entity,key));
  }
}
