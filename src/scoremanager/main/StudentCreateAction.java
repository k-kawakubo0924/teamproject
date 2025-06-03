package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class StudentCreateAction implements Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {


            return "/window/StudentCreate.jsp";
        }
    }
