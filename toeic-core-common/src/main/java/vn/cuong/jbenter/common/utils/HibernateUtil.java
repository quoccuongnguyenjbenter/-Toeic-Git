package vn.cuong.jbenter.common.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
//    HibernateUtil hbnu=new HibernateUtil();
//    private final SessionFactory sc=hbnu.buildSessionFactory();
    private static final SessionFactory sessionFactory=buildSessionFactory();
    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();

        }catch (Throwable e){
            System.out.println("Initial session factory fail");
            throw new  ExceptionInInitializerError(e);
        }
//        return new Configuration().configure().buildSessionFactory();
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
