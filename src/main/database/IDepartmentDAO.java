package main.database;

import main.domian.DepartmentTO;

import java.util.List;


/**
 * Created by tayfer01 on 10/18/2016.
 */
public interface IDepartmentDAO {

    void save(DepartmentTO departmentTO) throws Exception;

    List<DepartmentTO> findAll() throws  Exception;

    DepartmentTO findById(int id) throws Exception;

    void update(DepartmentTO departmentTO) throws Exception;

}

