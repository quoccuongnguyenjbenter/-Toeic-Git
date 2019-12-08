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
}
