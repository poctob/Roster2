/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.ejb;

import java.util.Collection;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import net.xpresstek.roster2.web.EmployeeController;
import net.xpresstek.roster2.web.EmployeeController.EmployeeControllerConverter;
import net.xpresstek.roster2.web.S3cr3tController;
import net.xpresstek.roster2.web.S3cr3tController.S3cr3tControllerConverter;
import org.primefaces.context.RequestContext;

/**
 *
 * @author apavlune
 */
public class LogInBean {

    public static final String EMPLOYEE_PAGE="/user/List";
    public static final String ADMINISTRATOR_PAGE="/shift/List";
     public static final String LOGIN_PAGE="/index";
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
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        RequestContext context = RequestContext.getCurrentInstance();        
        String retval=null;

        if (user != null && password != null) {
            loggedIn = true;
            S3cr3tController sc = S3cr3tControllerConverter.getController();
            EmployeeController ec = EmployeeControllerConverter.getController();
            Employee e = ec.getEmployeeByName(user);
            if (sc.isPasswordCorrect(e.getPkID(), password)) {
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
