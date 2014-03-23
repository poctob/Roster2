/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.zroster.web;

import javax.faces.context.FacesContext;

/**
 *
 * @author alex
 */
public class ControllerFactory {

    protected static ControllerBase getController(String controller_type) {
        FacesContext fc = FacesContext.getCurrentInstance();
        return (ControllerBase) fc.getApplication().getELResolver().
                getValue(fc.getELContext(), null, controller_type);
    }

    public static EmployeeController getEmployeeController() {
        return (EmployeeController) getController("employeeController");
    }

    public static ConfigurationController getConfigurationController() {
        return (ConfigurationController) getController("configurationController");
    }

    public static ClockEventTransController getClockEventTransController() {
        return (ClockEventTransController) getController("clockEventTransController");
    }

    public static PositionController getPositionController() {
        return (PositionController) getController("positionController");
    }

    public static S3cr3tController getS3cr3tController() {
        return (S3cr3tController) getController("s3cr3tController");
    }

    public static ClockEventController getClockEventController() {
        return (ClockEventController) getController("clockEventController");
    }

    public static WeeklyHoursController getWeeklyHoursController()
    {
        return (WeeklyHoursController) getController("weeklyHoursController");
    }
    
    public static TimeOffStatusController getTimeOffStatusController()
    {
        return (TimeOffStatusController) getController("timeOffStatusController");
    }
}
