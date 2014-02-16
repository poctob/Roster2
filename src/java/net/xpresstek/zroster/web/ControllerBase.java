/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.zroster.web;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import net.xpresstek.zroster.web.util.JsfUtil;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author apavlune
 */
public abstract class ControllerBase implements Serializable {

    protected DataModel items = null;
    protected int selectedItemIndex;
    private String status;

    public void create() {
        try {
            getFacade().create(getCurrent());
            recreateModel();
            status = "Item Created!";
            JsfUtil.addSuccessMessage(status);
        } catch (Exception e) {
            status = e + ResourceBundle.getBundle("/Bundle").
                    getString("PersistenceErrorOccured");
            JsfUtil.addErrorMessage(e, status);
        }
    }
 
    public Object getSelected() {
        if (getCurrent() == null) {
            createNewCurrent();
            selectedItemIndex = -1;
        }
        return getCurrent();
    }

    public String getStatus() {
        return status;
    }

    public void destroy() {
        if (getCurrent() != null) {
            performDestroy();
            recreateModel();
        }
    }

    public void destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        recreateModel();
    }

    abstract AbstractFacade getFacade();

    abstract Object getCurrent();

    abstract void setCurrent(Object obj);

    abstract void createNewCurrent();

    public DataModel getItems() {
        if (items == null) {
            items =  new ListDataModel(getFacade().findAll());
        }
        return items;
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getFacade().findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getFacade().findAll(), true);
    }

    public Object getObject(Integer id) {
        return getFacade().find(id);
    }
    
    public Object getObject(String id) {
        return getFacade().find(id);
    }


    protected void performDestroy() {
        try {
            getFacade().remove(getCurrent());
            status = "Item Deleted";
            JsfUtil.addSuccessMessage(status);
        } catch (Exception e) {
            status = e + ResourceBundle.getBundle("/Bundle").
                    getString("PersistenceErrorOccured");
            JsfUtil.addErrorMessage(e, status);
        }
    }

    public void prepareCreate() {
        createNewCurrent();
        selectedItemIndex = -1;
    }

    public void prepareEdit() {
        setCurrent(getItems().getRowData());
        selectedItemIndex = getItems().getRowIndex();
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    protected void recreateModel() {
        items = null;
    }


    public void update() {
        try {
            getFacade().edit(getCurrent());

            status = "Item updated";
            JsfUtil.addSuccessMessage(status);
        } catch (Exception e) {
            status = e + ResourceBundle.getBundle("/Bundle").
                    getString("PersistenceErrorOccured");
            JsfUtil.addErrorMessage(e, status);
        }
    }

    protected void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
        }
        if (selectedItemIndex >= 0) {
            setCurrent(getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).
                    get(0));
        }
    }
    
     public void onRowEdit(RowEditEvent event) {

        Object newValue = event.getObject();

        if (newValue != null) {
            setCurrent(newValue);
            update();           
        }
    }

    public void onRowEditCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Canceled","Edit Canceled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
