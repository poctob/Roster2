package net.xpresstek.zroster.web;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Entity Facade super class.  Perform basic database operations for the 
 * entity classes. 
 * @author Alex Pavlunenko
 */
public abstract class AbstractFacade<T> {

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
     * @param entityClass Entity class to use.
     */
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Getter for the entity manager object.
     * @return 
     */
    protected EntityManager getEntityManager() { 
        return em;
    }

    /**
     * Creates new entity in the database.
     * @param entity Entity to create.
     */
    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    /**
     * Updates entity in the database.
     * @param entity Entity to update.
     */
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    /**
     * Deletes entity from the database.
     * @param entity Entity to delete.
     */
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }
    
    /**
     * Updates entity in the database and refreshes it in the context.
     * @param entity Entity to update.
     */
    public void refresh(T entity)
    {
        T obj=getEntityManager().merge(entity);
        getEntityManager().refresh(obj);
    }

    /**
     * Finds object in the database.
     * @param id Object's id
     * @return Found entity
     */
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     * Fetches all records.
     * @return List of all entities
     */
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /**
     * Finds a specified number of entities.
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
