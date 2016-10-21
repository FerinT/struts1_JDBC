package main.domian;


import java.util.List;


/**
 * Concrete class for Department
 */

public class DepartmentTO {

    private int departmentNumber;
    private String departmentName;
    private String location;
    private List<DepartmentTO> departmentTOList;

    public DepartmentTO(){}

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDepartmentList(List<DepartmentTO> departmentTOList){
        this.departmentTOList = departmentTOList;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getLocation() {
        return location;
    }

    public List<DepartmentTO> getDepartmentList(){
        return this.departmentTOList;
    }

}
