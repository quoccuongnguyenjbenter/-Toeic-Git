package vn.cuong.jbenter.core.data.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<ID extends Serializable, T>{
    List<T> findAll();
    T update(T entity);
//    T save(T entity);
    void save(T entity);
    T findById(ID id);
    Object[] findByProperty(String property, Object value, String sortExpression, String sortDirection);
    Integer delete(List<ID> ids);
}