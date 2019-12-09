package vn.cuong.jbenter.core.test;

import org.junit.Test;

import vn.cuong.demo.core.persistence.entity.RoleEntity;
import vn.cuong.jbenter.core.dao.RoleDao;
import vn.cuong.jbenter.core.daoimpl.RoleDaoImpl;

import java.util.List;

public class RoleTest {
    @Test
    public void checkFindAll(){
        RoleDao roleDao =new RoleDaoImpl();
//        List<RoleEntity> list= roleDao.findAll();
        List<RoleEntity> list=roleDao.findAll();
    }
    @Test
    public void checkUpdateRole(){
        RoleDao roleDao=new RoleDaoImpl();
        RoleEntity entity=new RoleEntity();
        entity.setRoleId(2);
        entity.setName("USER_1");
        roleDao.update(entity);
    }

    @Test
    public void checkSaveRole(){
        RoleDao roleDao=new RoleDaoImpl();
        RoleEntity entity=new RoleEntity();
        entity.setRoleId(3);
        entity.setName("USER_2");
        roleDao.update(entity);
    }

    @Test
    public void checkFindId(){
        RoleDao roleDao=new RoleDaoImpl();
//        RoleEntity entity=new RoleEntity();
//        entity.setRoleId(3);
//        entity.setName("USER_2");
//        roleDao.update(entity);
        RoleEntity entity=roleDao.findById(1);
    }

    @Test
    public void checkFindByProperty(){
        RoleDao roleDao=new RoleDaoImpl();
        String property=null;
        Object value=null;
        String sortExpression=null;
        String sortDirection=null;
        Object[] objects=roleDao.findByProperty(property,value,sortExpression,sortDirection);
    }
}
