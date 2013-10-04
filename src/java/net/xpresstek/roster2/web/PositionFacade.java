/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;

import javax.ejb.Stateless;
import net.xpresstek.roster2.ejb.Position;

/**
 *
 * @author apavlune
 */
@Stateless
public class PositionFacade extends AbstractFacade<Position> {   

    public PositionFacade() {
        super(Position.class);
    }
    
}
