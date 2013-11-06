/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.ejb;

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
        this.loggedIn=false;
        this.user="";
        this.password="";
        return "success";
    }

    public String login() {
        RequestContext context = RequestContext.getCurrentInstance();        
        String retval="failure";

        if (user != null && password != null) {
            loggedIn = true;
            S3cr3tController sc = S3cr3tControllerConverter.getController();
            EmployeeController ec = EmployeeControllerConverter.getController();
            Employee e = ec.getEmployeeByName(user);
            if (sc.isPasswordCorrect(e.getPkID(), password)) {
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", user);
                retval="success";
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
    
    public void addCurrentMessage()
    {
         FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
