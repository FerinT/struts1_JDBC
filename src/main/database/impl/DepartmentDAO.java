package main.database.impl;

import main.database.IDepartmentDAO;
import main.domian.DepartmentTO;
import main.utils.EstablishConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DepartmentDAO implements IDepartmentDAO {

    private Connection connection = null;
    private ResultSet resultSet = null;


    public DepartmentDAO() {
        connection = EstablishConnection.getConnection();
    }


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

    public List<DepartmentTO> findAll() throws Exception{
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

    public void update(DepartmentTO departmentTO) throws Exception{
        String update = "UPDATE DEPARTMENT SET DEPARTMENT_NAME = ?, LOCATION = ? WHERE DEPARTMENT_NUMBER = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1, departmentTO.getDepartmentName());
        preparedStatement.setString(2, departmentTO.getLocation());
        preparedStatement.setString(3, departmentTO.getDepartmentNumber() + "");

        preparedStatement.executeUpdate();

    }

    public DepartmentTO findById(int id) throws Exception{

        String select = "SELECT * FROM DEPARTMENT WHERE DEPARTMENT_NUMBER = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(select);
        preparedStatement.setString(1, id + "");

        resultSet = preparedStatement.executeQuery();

        resultSet.next();

        DepartmentTO departmentTO = new DepartmentTO();
        departmentTO.setDepartmentNumber(resultSet.getInt("DEPARTMENT_NUMBER"));
        departmentTO.setDepartmentName(resultSet.getNString("DEPARTMENT_NAME"));
        departmentTO.setLocation(resultSet.getNString("LOCATION"));

        return departmentTO;
    }


}
