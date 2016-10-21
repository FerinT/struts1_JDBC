package main.common.action;


import main.database.impl.DepartmentDAO;
import main.domian.DepartmentTO;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by tayfer01 on 10/18/2016.
 */
public class DepartmentAction extends Action{

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String action = mapping.getParameter();

        if(action.equals("saveDepartment")) {
            this.saveDepartment(form, request);
            return mapping.findForward("success");
        }
        if(action.equals("viewAllDepartments") || action.equals("departmentNumbers")){
            this.viewAll(form, request);
            return mapping.findForward("success");
        }
        if(action.equals("departmentInformation")){
            this.getSingleDepartment(form,request);
            return mapping.findForward("success");
        }
        if(action.equals("departmentUpdate")){
            this.updateDepartment(form,request);
            return mapping.findForward("success");
        }


       return null;
    }

    public void saveDepartment(ActionForm actionForm, HttpServletRequest request) throws Exception{
        DepartmentTO departmentTO = new DepartmentTO();

        departmentTO.setDepartmentNumber(Integer.parseInt(request.getParameter("departmentNumber")));
        departmentTO.setDepartmentName(request.getParameter("departmentName"));
        departmentTO.setLocation(request.getParameter("location"));

        DepartmentDAO departmentDAO = new DepartmentDAO();
        departmentDAO.save(departmentTO);
    }

    public List<DepartmentTO> viewAll(ActionForm actionForm, HttpServletRequest request) throws Exception{
        DepartmentDAO departmentDAO = new DepartmentDAO();

        DynaActionForm dynaActionForm = (DynaActionForm) actionForm;
        dynaActionForm.set("departmentList", departmentDAO.findAll());

        return departmentDAO.findAll();

    }

    public void getSingleDepartment(ActionForm actionForm, HttpServletRequest request) throws Exception{
        int departmentId = Integer.parseInt(request.getParameter("departmentNumber"));

        System.out.println("Selected: " + departmentId);

        DepartmentTO departmentTO = new DepartmentTO();
        DepartmentDAO departmentDAO = new DepartmentDAO();

        departmentTO = departmentDAO.findById(Integer.parseInt(request.getParameter("departmentNumber")));

        DynaActionForm dynaActionForm = (DynaActionForm) actionForm;
        dynaActionForm.set("departmentNumber", departmentTO.getDepartmentNumber());
        dynaActionForm.set("departmentName", departmentTO.getDepartmentName());
        dynaActionForm.set("location", departmentTO.getLocation());

    }

    public void updateDepartment(ActionForm actionForm, HttpServletRequest request) throws Exception {
        DepartmentTO departmentTO = new DepartmentTO();

        departmentTO.setDepartmentNumber(Integer.parseInt(request.getParameter("departmentNumber")));
        departmentTO.setDepartmentName(request.getParameter("departmentName"));
        departmentTO.setLocation(request.getParameter("location"));

        DepartmentDAO departmentDAO = new DepartmentDAO();
        departmentDAO.update(departmentTO);
    }

}

