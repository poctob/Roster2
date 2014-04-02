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

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.xpresstek.zroster.web.util.DataChangeEventListener;
import net.xpresstek.zroster.web.util.DataChangedEvent;

/**
 * Entity Facade super class. Perform basic database operations for the entity
 * classes.
 *
 * @author Alex Pavlunenko
 */
public abstract class AbstractFacade<T> {

    /**
     * Listens for the data changes
     */
    private List<DataChangeEventListener> listeners;

    /**
     * Template entity class
     */
    private Class<T> entityClass;

    /**
     * Persistence unit
     */
    @PersistenceContext(unitName = "Roster2PU")

    /**
     * Entity manager
     */
    private EntityManager em;

    /**
     * Default constructor initializes entity class.
     *
     * @param entityClass Entity class to use.
     */
    public AbstractFacade(Class<T> entityClass) {
        listeners = new ArrayList();
        this.entityClass = entityClass;
    }

    /**
     * Adds a datachangeeventlistener to the list
     * @param l Listener to add to the list
     */
    public void addDataChangeListener(DataChangeEventListener l) {
        listeners.add(l);
    }
    
    /**
     * Removes a datachangeeventlistener from the list
     * @param l Listener to remove from the list
     */
    public void reomveDataChangeListener(DataChangeEventListener l) {
        listeners.remove(l);
    }
    
    private void fireDataChangeListeners()
    {
        DataChangedEvent event=new DataChangedEvent(this);
        for(DataChangeEventListener l : listeners)
        {
            l.updateData(event);
        }
    }    

    /**
     * Getter for the entity manager object.
     *
     * @return
     */
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Creates new entity in the database.
     *
     * @param entity Entity to create.
     */
    public void create(T entity) {
        getEntityManager().persist(entity);
        fireDataChangeListeners();
    }

    /**
     * Updates entity in the database.
     *
     * @param entity Entity to update.
     */
    public void edit(T entity) {
        getEntityManager().merge(entity);
        fireDataChangeListeners();
    }

    /**
     * Deletes entity from the database.
     *
     * @param entity Entity to delete.
     */
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
        fireDataChangeListeners();
    }

    /**
     * Updates entity in the database and refreshes it in the context.
     *
     * @param entity Entity to update.
     */
    public void refresh(T entity) {
        T obj = getEntityManager().merge(entity);
        getEntityManager().refresh(obj);
        fireDataChangeListeners();
    }

    /**
     * Finds object in the database.
     *
     * @param id Object's id
     * @return Found entity
     */
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     * Fetches all records.
     *
     * @return List of all entities
     */
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /**
     * Finds a specified number of entities.
     *
     * @param range Range of the search.
     * @return List of found entities.
     */
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    /**
     * Returns a number of entities in the database.
     *
     * @return Number of entities.
     */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
