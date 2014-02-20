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
package net.xpresstek.zroster.web.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
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
        HttpsURLConnection con=(HttpsURLConnection)obj.openConnection();
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
