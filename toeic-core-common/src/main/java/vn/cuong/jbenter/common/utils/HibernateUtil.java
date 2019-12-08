package vn.cuong.jbenter.common.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;


public class HibernateUtil {
//    HibernateUtil hbnu=new HibernateUtil();
//    private final SessionFactory sc=hbnu.buildSessionFactory();
    private static final SessionFactory sessionFactory=buildSessionFactory();
//    private static SessionFactory buildSessionFactory() {
//        try {
////            Configuration configuration=new Configuration().configure("E:\\clone-GIT\\toeic-web\\src\\main\\resources\\hibernate.cfg.xml");
//            File f=new File("E:\\clone-GIT\\toeic-web\\src\\main\\resources\\hibernate.cfg.xml");
//            return new Configuration().configure(f).buildSessionFactory();
//
//        }catch (Throwable ex){
//            System.out.println("Initial SessionFactory failed."+ex);
//            throw new  ExceptionInInitializerError(ex);
//        }
////        return new Configuration().configure().buildSessionFactory();
//    }
private static SessionFactory buildSessionFactory() {
    try {
        // Create the SessionFactory from hibernate.cfg.xml
        return new Configuration().configure().buildSessionFactory();
    }
    catch (Throwable ex) {
        // Make sure you log the exception, as it might be swallowed
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
    }
}
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
