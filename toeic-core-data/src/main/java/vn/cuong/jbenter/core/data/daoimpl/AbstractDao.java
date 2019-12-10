package vn.cuong.jbenter.core.data.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import vn.cuong.jbenter.common.constant.CoreConstant;
import vn.cuong.jbenter.common.utils.HibernateUtil;
import vn.cuong.jbenter.core.data.dao.GenericDao;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.Logger;

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
    private final Logger log = Logger.getLogger(this.getClass());
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
            log.error(e.getMessage(), e);
            throw e;
        }
        finally

        {
            session.close();
        }
        return list;
    }


    @Override
    public T update(T entity) {
        T result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Object object = session.merge(entity);
            result = (T) object;
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public void save(T entity) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(entity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
//            log.error(e.getMessage(), e);
            throw e;

        } finally {
            session.close();
        }
    }

    @Override
    public T findById(ID id) {
        T result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
//            Object object = session.merge(entity);
            result = (T) session.get(persistenceClass, id);
//            transaction.commit();
            if (result==null){
                throw new ObjectNotFoundException(" NOT FOUND "+id,null);
            }
        } catch (HibernateException e) {
            transaction.rollback();
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public Object[] findByProperty(String property, Object value, String sortExpression, String sortDirection) {
        List<T> list = new ArrayList<T>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Object totalItem = 0;
//        Object[] nameQuery = HibernateUtil.buildNameQuery(property);
        try {
            StringBuilder sql1 = new StringBuilder("from ");
//            sql1.append(getPersistenceClassName()).append(" where 1=1 ").append(nameQuery[0]);
            sql1.append(getPersistenceClassName());
//            if (sortExpression != null && sortDirection != null) {
//                sql1.append(" order by ").append(sortExpression);
//                sql1.append(" " +(sortDirection.equals(CoreConstant.SORT_ASC)?"asc":"desc"));
//            }
            if (property!=null&&value!=null){
                sql1.append(" where ").append(property).append("=: value");
            }
            if (sortExpression!=null&&sortDirection==null){
                sql1.append(" order by ").append(sortExpression);
                sql1.append(" "+(sortDirection.equals(CoreConstant.SORT_ASC)?"asc":"desc"));
            }
            Query query1=session.createQuery(sql1.toString());
            if (value!=null){
                query1.setParameter("value",value);
            }
            list =query1.list();
            StringBuilder sql2=new StringBuilder("select count(*) from ");
            sql2.append(getPersistenceClassName());
//            sql2.append(" where ").append(property).append("=: value");
            if(property!=null&&value!=null){
                sql2.append(" where ").append(property).append("=: value");
            }
            Query query2=session.createQuery(sql1.toString());
            if(value!=null){
                query2.setParameter("value",value);
            }
//            query2.setParameter("value",value);
            totalItem=query2.list().get(0);
            transaction.commit();
//            if (whereClause != null) {
//                sql1.append(whereClause);
//            }
//            Query query1 = session.createQuery(sql1.toString());
//            setParameterToQuery(nameQuery, query1);
//            if (offset != null && offset >= 0) {
//                query1.setFirstResult(offset);
//            }
//            if (limit != null && limit > 0) {
//                query1.setMaxResults(limit);
//            }
//            list = query1.list();
//            StringBuilder sql2 = new StringBuilder("select count(*) from ");
//            sql2.append(getPersistenceClassName()).append(" where 1=1 ").append(nameQuery[0]);
//            if (whereClause != null) {
//                sql2.append(whereClause);
//            }
//            Query query2 = session.createQuery(sql2.toString());
//            setParameterToQuery(nameQuery, query2);
//            totalItem = query2.list().get(0);
//            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            session.close();
        }
        return new Object[]{totalItem, list};
    }

    @Override
    public Integer delete(List<ID> ids) {
        Integer count=0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            for (ID item:ids
                 ) {
//                T t= (T) session.get(getPersistenceClassName(),item);
                T t=(T)session.get(persistenceClass, item);
                session.delete(t);
                count++;
            }

            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }
        return count;
    }

//    @Override
//    public T save(T entity) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            session.persist(entity);
//            transaction.commit();
//        } catch (HibernateException e) {
//            transaction.rollback();
//            log.error(e.getMessage(), e);
//            throw e;
//        } finally {
//            session.close();
//        }
//        return null;
//    }


}
