/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;

import com.gzlabs.utils.DateUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import net.xpresstek.roster2.ejb.Configuration;
import net.xpresstek.roster2.ejb.Shift;
import net.xpresstek.roster2.web.ConfigurationController.ConfigurationControllerConverter;
import net.xpresstek.roster2.web.ShiftController.ShiftControllerConverter;
import net.xpresstek.roster2.web.util.HttpUtil;
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

    public void upload() {

        HashMap hm = new HashMap();
        hm.put("user", getDb_user());
        hm.put("password", getDb_pass());
        List l1 = new LinkedList();

        ShiftController sc = ShiftControllerConverter.getController();
        List<Shift> shifts = sc.getItemsFromTheWeekStart();
        for (Shift s : shifts) {
            Map map = new HashMap();
            map.put("employee", s.getEmployeeObject().getName());
            map.put("position", s.getPositionObject().getName());
            map.put("start", DateUtils.DateToString(s.getStart()));
            map.put("end", DateUtils.DateToString(s.getEnd()));
            l1.add(map);
        }
        hm.put("data", JSONValue.toJSONString(l1));

        try {
            response = HttpUtil.sendPost(hm, getUrl());
        } catch (Exception ex) {
            Logger.getLogger(UploadController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        finally
        {
            url=null;
            db_user=null;
            db_pass=null;

        }

    }

    public String getUrl() {
        if (url == null || url.length() == 0) {
            Configuration conf =
                    (Configuration) ConfigurationControllerConverter.getController().
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
                    (Configuration) ConfigurationControllerConverter.getController().
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
                    (Configuration) ConfigurationControllerConverter.getController().
                    getObject("UploadPassword");

            db_pass = conf.getConfigValue();
        }
        return db_pass;
    }

    public void setDb_pass(String db_pass) {
        this.db_pass = db_pass;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
