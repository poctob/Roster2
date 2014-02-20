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
            case "timeClock":
                retval = "/clockEventTrans/List";
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
