/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author apavlune
 */
public class HttpUtil {
    
    public static String sendPost(Map params, String url) throws Exception
    {
        URL obj=new URL(url);
        HttpURLConnection con=(HttpURLConnection)obj.openConnection();
        con.setRequestMethod("POST");
        
        Set set=params.entrySet();        
        Iterator i=set.iterator();
        
        String urlParams="";
        
        while(i.hasNext())
        {
           Map.Entry<String, String> e=(Map.Entry)i.next();
           urlParams+=e.getKey();
           urlParams+="="+e.getValue()+"&";
        }
        urlParams=urlParams.substring(0, urlParams.length()-1);
        
        con.setDoOutput(true);
        DataOutputStream wr=new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParams);
        wr.flush();
        wr.close();
        
        int rCode=con.getResponseCode();
        BufferedReader br=new BufferedReader
                (new InputStreamReader(con.getInputStream()));
        
        String il;
        StringBuffer response=new StringBuffer();
        while((il=br.readLine())!=null)
        {
            response.append(il);
        }
        br.close();
        
        return response.toString();
        
    }
    
}
