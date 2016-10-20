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
    public DepartmentAction() {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String action = mapping.getParameter();

        if(action.equals("saveDepartment")) {
            this.saveDepartment(form, request);
            return mapping.findForward("success");
        }
        if(action.equals("test")){
            this.viewAll(form, request);
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
        dynaActionForm.set("departmentList", departmentDAO.readAll());

        return departmentDAO.readAll();

    }

}

