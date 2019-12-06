package vn.cuong.jbenter.core.data.daoimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.cuong.jbenter.common.utils.HibernateUtil;
import vn.cuong.jbenter.core.data.dao.GenericDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {
    private Class<T> persistenceClass;
    public AbstractDao(){
        this.persistenceClass= (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
    public String getPersistenceClassName(){
        return persistenceClass.getSimpleName();
    }
    protected Session getSession(){
        return HibernateUtil.getSessionFactory().openSession();
    }
    @Override
    public List<T> findAll() {
        List<T> list=new ArrayList<T>();
        Transaction transaction=null;
        transaction=getSession().beginTransaction();

        return null;
    }
}
