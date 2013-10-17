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
import net.xpresstek.roster2.ejb.Shift;
import net.xpresstek.roster2.web.ShiftController.ShiftControllerConverter;
import net.xpresstek.roster2.web.util.HttpUtil;
import org.json.simple.JSONValue;

/**
 *
 * @author apavlune
 */
@Named("uploadController")
@SessionScoped
public class UploadController implements Serializable{
    
    private String url;
    private String db_user;
    private String db_pass;
    
    private String response;
    
    public void upload()
    {
        if(url!=null && url.length()>0)
        {
            HashMap hm=new HashMap();
            hm.put("user", db_user);
            hm.put("password", db_pass);
            List l1=new LinkedList();
            
            ShiftController sc=ShiftControllerConverter.getController();
            List<Shift> shifts=sc.getItemsFromTheWeekStart();
            for(Shift s : shifts)
            {
                Map map=new HashMap();
                map.put("employee", s.getEmployeeObject().getName());
                map.put("position", s.getPositionObject().getName());
                map.put("start", DateUtils.DateToString(s.getStart()));
                map.put("end", DateUtils.DateToString(s.getEnd()));
                l1.add(map);
            }
            hm.put("data", JSONValue.toJSONString(l1));
            
            try {
                response=HttpUtil.sendPost(hm, url);
            } catch (Exception ex) {
                Logger.getLogger(UploadController.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDb_user() {
        return db_user;
    }

    public void setDb_user(String db_user) {
        this.db_user = db_user;
    }

    public String getDb_pass() {
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
