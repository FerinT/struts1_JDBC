package main.database;

import main.domian.DepartmentTO;

import java.util.List;
import java.util.Set;

/**
 * Created by tayfer01 on 10/18/2016.
 */
public interface IDepartmentDAO {

    void save(DepartmentTO departmentTO) throws Exception;
    List<DepartmentTO> readAll() throws  Exception;


}
