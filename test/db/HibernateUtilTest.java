package db;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

class HibernateUtilTest {

  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();
    //Transaction tx = null;

    System.out.println(session);

    session.close();
 /*   try {
      Transaction transaction = session.beginTransaction();


    } catch () {
    }finally {

    }*/
  }
}