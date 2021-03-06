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

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import net.xpresstek.zroster.web.util.MailUtil;

/**
 *
 * @author Alex Pavlunenko <alexp at xpresstek.net>
 */
@Named("idleController")
@ApplicationScoped
public class IdleController implements Serializable{
    
     public void idleListener() {  
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try
        {
            FacesContext.getCurrentInstance().getExternalContext().
                    redirect("expired.xhtml");
        }
        catch(IOException ex)
        {
            Logger.getLogger(MailUtil.class.getName()).
                        log(Level.SEVERE, null, ex);
        }
        
    }  
    
}
