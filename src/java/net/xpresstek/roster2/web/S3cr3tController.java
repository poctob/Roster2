package net.xpresstek.roster2.web;

import net.xpresstek.roster2.ejb.S3cr3t;
import net.xpresstek.roster2.web.util.JsfUtil;
import net.xpresstek.roster2.web.util.PaginationHelper;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("s3cr3tController")
@SessionScoped
public class S3cr3tController implements Serializable {

    private S3cr3t current;
    private DataModel items = null;
    @EJB
    private net.xpresstek.roster2.web.S3cr3tFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public S3cr3tController() {
    }

    public S3cr3t getSelected() {
        if (current == null) {
            current = new S3cr3t();
            current.setS3cr3tPK(new net.xpresstek.roster2.ejb.S3cr3tPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private S3cr3tFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {
                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (S3cr3t) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new S3cr3t();
        current.setS3cr3tPK(new net.xpresstek.roster2.ejb.S3cr3tPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getS3cr3tPK().setUserId(current.getEmployee().getPkID());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("S3cr3tCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (S3cr3t) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getS3cr3tPK().setUserId(current.getEmployee().getPkID());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("S3cr3tUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (S3cr3t) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("S3cr3tDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public S3cr3t getS3cr3t(net.xpresstek.roster2.ejb.S3cr3tPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = S3cr3t.class)
    public static class S3cr3tControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            S3cr3tController controller = (S3cr3tController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "s3cr3tController");
            return controller.getS3cr3t(getKey(value));
        }

        net.xpresstek.roster2.ejb.S3cr3tPK getKey(String value) {
            net.xpresstek.roster2.ejb.S3cr3tPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new net.xpresstek.roster2.ejb.S3cr3tPK();
            key.setUserId(Integer.parseInt(values[0]));
            key.setPass(values[1]);
            key.setSalt(values[2]);
            return key;
        }

        String getStringKey(net.xpresstek.roster2.ejb.S3cr3tPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getUserId());
            sb.append(SEPARATOR);
            sb.append(value.getPass());
            sb.append(SEPARATOR);
            sb.append(value.getSalt());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof S3cr3t) {
                S3cr3t o = (S3cr3t) object;
                return getStringKey(o.getS3cr3tPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + S3cr3t.class.getName());
            }
        }
    }
}
