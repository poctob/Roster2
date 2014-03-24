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
package net.xpresstek.zroster.web;

import com.gzlabs.utils.DateUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import net.xpresstek.zroster.ejb.Configuration;
import net.xpresstek.zroster.ejb.Shift;
import net.xpresstek.zroster.web.ShiftController.ShiftControllerConverter;
import net.xpresstek.zroster.web.util.HttpUtil;
import org.json.simple.JSONValue;

/**
 *
 * @author apavlune
 */
@Named("uploadController")
@SessionScoped
public class UploadController implements Serializable {

    private String url;
    private String db_user;
    private String db_pass;
    private String response;
    private Integer progress = 0;
    private boolean error;

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public void upload() {
        progress = 0;
        HashMap hm = new HashMap();
        hm.put("user", getDb_user());
        hm.put("password", getDb_pass());
        List l1 = new LinkedList();

        ShiftController sc = ShiftControllerConverter.getController();
        List<Shift> shifts = sc.getItemsFromTheWeekStart();
        progress = 10;
        for (Shift s : shifts) {
            Map map = new HashMap();
            map.put("employee", s.getEmployeeObject().getName());
            map.put("position", s.getPositionObject().getName());
            map.put("start", DateUtils.DateToString(s.getStart()));
            map.put("end", DateUtils.DateToString(s.getEnd()));
            l1.add(map);
        }
        progress = 20;
        hm.put("data", JSONValue.toJSONString(l1));
        progress = 50;
        try {
            response = HttpUtil.sendPost(hm, getUrl());
            progress = 100;
        } catch (Exception ex) {
            Logger.getLogger(UploadController.class.getName()).
                    log(Level.SEVERE, null, ex);   
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
                (FacesMessage.SEVERITY_ERROR, "Upload Failed", "Upload Failed"));
             error=true;
        } finally {
            url = null;
            db_user = null;
            db_pass = null;
            error=false;
        }
    }

    public String getUrl() {
        if (url == null || url.length() == 0) {
            Configuration conf =
                    (Configuration) ControllerFactory.getConfigurationController().
                    getObject("UploadHost");

            url = conf.getConfigValue();
        }
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDb_user() {
        if (db_user == null || db_user.length() == 0) {
            Configuration conf =
                    (Configuration) ControllerFactory.getConfigurationController().
                    getObject("UploadUser");

            db_user = conf.getConfigValue();
        }
        return db_user;
    }

    public void setDb_user(String db_user) {
        this.db_user = db_user;
    }

    public String getDb_pass() {
        if (db_pass == null || db_pass.length() == 0) {
            Configuration conf =
                    (Configuration) ControllerFactory.getConfigurationController().
                    getObject("UploadPassword");

            db_pass = conf.getConfigValueRaw();
        }
        return db_pass;
    }

    public void setDb_pass(String db_pass) {
        this.db_pass = db_pass;
    }

    public String getResponse() {
        progress = 0;
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void cancel() {
        progress = 0;
    }

    public void onComplete() {
        if(error)
        {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
                (FacesMessage.SEVERITY_ERROR, "Upload Failed", "Upload Failed"));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
                    (FacesMessage.SEVERITY_INFO, "Upload Completed", "Upload Completed"));
        }
        error=false;
        progress = 0;
    }
}
