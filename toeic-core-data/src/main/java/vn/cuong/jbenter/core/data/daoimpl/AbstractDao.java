package vn.cuong.jbenter.core.data.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import vn.cuong.jbenter.common.utils.HibernateUtil;
import vn.cuong.jbenter.core.data.dao.GenericDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

//public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {
//    private Class<T> persistenceClass;
//    public AbstractDao(){
//        this.persistenceClass= (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
//    }
//    public String getPersistenceClassName(){
//        return persistenceClass.getSimpleName();
//    }
//    protected Session getSession(){
//        return HibernateUtil.getSessionFactory().openSession();
//    }
//    @Override
//    public List<T> findAll() {
//        List<T> list=new ArrayList<T>();
//        Transaction transaction=null;
//        try{
//            transaction=getSession().beginTransaction();
//            StringBuilder sql= new StringBuilder("from ");
//            sql.append(this.getPersistenceClassName());
//            Query query=this.getSession().createQuery(sql.toString());
//            list=query.list();
//
//            transaction.commit();
//        }
//        catch (HibernateException e){
//            transaction.rollback();
//            throw e;
//        }
//        return list;
//    }
//}
public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {
//    private final Logger log = Logger.getLogger(this.getClass());
    private Class<T> persistenceClass;

    public AbstractDao() {
        this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public String getPersistenceClassName() {
        return persistenceClass.getSimpleName();
    }

    public List<T> findAll() {
        List<T> list = new ArrayList<T>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder("from ");
            sql.append(this.getPersistenceClassName());
            Query query = session.createQuery(sql.toString());
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
//            log.error(e.getMessage(), e);
            throw e;
        }
//        } finally {
//            session.close();
//        }
            return list;
        }

}
