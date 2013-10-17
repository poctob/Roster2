/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import net.xpresstek.roster2.web.util.HttpUtil;

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
