package main.database.impl;

import main.database.IDepartmentDAO;
import main.domian.DepartmentTO;
import main.utils.EstablishConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DepartmentDAO implements IDepartmentDAO {

    private Connection connection = null;
    private ResultSet resultSet = null;


    public DepartmentDAO() {
        connection = EstablishConnection.getConnection();
    }

    @Override
    public void save(DepartmentTO departmentTO) throws  Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");

        String insertDepartment = "INSERT INTO DEPARTMENT "+
                "(DEPARTMENT_NUMBER, DEPARTMENT_NAME, LOCATION) VALUES"+
                "(?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(insertDepartment);

        preparedStatement.setString(1, departmentTO.getDepartmentNumber() + "");
        preparedStatement.setString(2, departmentTO.getDepartmentName());
        preparedStatement.setString(3, departmentTO.getLocation());

        preparedStatement.executeUpdate();
    }

    @Override
    public List<DepartmentTO> readAll() throws Exception{
        String selectAll = "SELECT * FROM DEPARTMENT";

        PreparedStatement preparedStatement = connection.prepareStatement(selectAll);
        resultSet = preparedStatement.executeQuery();

        List<DepartmentTO> departmentTOList = new ArrayList<>();

        while(resultSet.next()){
            DepartmentTO departmentTO = new DepartmentTO();
            departmentTO.setDepartmentNumber(resultSet.getInt("DEPARTMENT_NUMBER"));
            departmentTO.setDepartmentName(resultSet.getNString("DEPARTMENT_NAME"));
            departmentTO.setLocation(resultSet.getNString("LOCATION"));

            departmentTOList.add(departmentTO);
        }

        return departmentTOList;
    }


}
