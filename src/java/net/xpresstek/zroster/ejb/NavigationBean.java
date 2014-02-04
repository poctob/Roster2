/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.zroster.ejb;

/**
 *
 * @author apavlune
 */
public class NavigationBean {

    /**
     * Creates a new instance of NavigationBean
     */
    public NavigationBean() {
    }

    public String getPage(String target) {
        String retval = null;
        switch (target) {

            case "shift":
                retval = "/shift/List";
                break;
            case "employee":
                retval = "/employee/List";
                break;
            case "position":
                retval = "/position/List";
                break;
            case "privilege":
                retval = "/privilege/List";
                break;
            case "timeOff":
                retval = "/timeOff/List";
                break;
            case "schedule":
                retval = "/schedule/List";
                break;
            case "configuration":
                retval = "/configuration/List";
                break;
            case "upload":
                retval = "/upload/upload";
                break;
            default:
                break;
        }
        return retval;
    }
}
