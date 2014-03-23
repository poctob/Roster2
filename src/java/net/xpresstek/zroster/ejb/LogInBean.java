/* 
 * Copyright (C) 2014 Alex Pavlunenko <alexp at xpresstek.net>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.xpresstek.zroster.ejb;

import java.io.Serializable;
import java.util.Collection;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import net.xpresstek.zroster.web.ControllerFactory;
import net.xpresstek.zroster.web.EmployeeController;
import net.xpresstek.zroster.web.EmployeeController.EmployeeControllerConverter;
import net.xpresstek.zroster.web.S3cr3tController;
import net.xpresstek.zroster.web.S3cr3tController.S3cr3tControllerConverter;
import org.primefaces.context.RequestContext;

/**
 *
 * @author apavlune
 */
@SessionScoped
public class LogInBean implements Serializable{

    private static final String EMPLOYEE_PAGE="/secured/user/List";
    private static final String ADMINISTRATOR_PAGE="/shift/List";
    private static final String LOGIN_PAGE="/index";
    private String user;
    private String password;
    private boolean loggedIn = false;
    private FacesMessage msg = null;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    public String logout()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        this.loggedIn=false;
        this.user="";
        this.password="";
        return LOGIN_PAGE;
    }

    /**
     * Processes login information.  Sets current employee to supplied user name.
     * Manages messages.
     * @return String signifying success of the login operation.
     */
    public String login() {
     //   FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        RequestContext context = RequestContext.getCurrentInstance();        
        String retval=null;

        if (user != null && password != null) {
            loggedIn = true;
            S3cr3tController sc = ControllerFactory.getS3cr3tController();
            EmployeeController ec = ControllerFactory.getEmployeeController();
            Employee e = ec.getEmployeeByName(user);
            if (sc.isPasswordCorrect(e.getPkID(), password)) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", user);
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome "+user, user);
                ec.setCurrent(e);                
                retval=getPrivilegePage(e);
            } else {
                loggedIn = false;
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
            }
        } else {
            loggedIn = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid input");
        }

        addCurrentMessage();
        context.addCallbackParam("loggedIn", loggedIn);
        return retval;
    }
    
    /**
     * Determines navigation page based on the employee privileges
     * @param employee Employee to check.
     * @return Navigation page.
     */
    private String getPrivilegePage(Employee employee)
    {
        String retval=null;
        if(employee!=null)
        {
            retval=EMPLOYEE_PAGE;
            Collection<Privilege> priv=employee.getPrivilegeCollection();
            for(Privilege p : priv)
            {
                if(p.isAdministrator())
                {
                    retval=ADMINISTRATOR_PAGE;
                    break;
                }
            }
        }
        return retval;
    }
    
    public void addCurrentMessage()
    {
         FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
