package net.xpresstek.zroster.web;

import com.gzlabs.utils.CryptoUtils;
import java.util.List;
import net.xpresstek.zroster.ejb.S3cr3t;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("s3cr3tController")
@SessionScoped
public class S3cr3tController extends ControllerBase {

    private S3cr3t current;
    @EJB
    private net.xpresstek.zroster.web.S3cr3tFacade ejbFacade;

    public S3cr3tController() {
    }

    @Override
    AbstractFacade getFacade() {
        return ejbFacade;
    }

    @Override
    Object getCurrent() {
        return current;
    }

    @Override
    void setCurrent(Object obj) {
        current = (S3cr3t) obj;
    }

    @Override
    void createNewCurrent() {
        current = new S3cr3t();
    }

    @Override
    public void create() {
        hashPassword();
        ejbFacade.deleteByEmployeeID(current.getEmployee().getPkID());
        super.create();
    }
    
    @Override
    public void update() {
        hashPassword();
        ejbFacade.deleteByEmployeeID(current.getEmployee().getPkID());
        super.update();
    }

    private void hashPassword() {
        String salt = CryptoUtils.generateRandomSalt(120, 32);
        String pass = current.getS3cr3tPK().getPass();
        String hash = CryptoUtils.hashPasswordSHA512(pass, salt);
        current.getS3cr3tPK().setPass(hash);
        current.getS3cr3tPK().setSalt(salt);
    }
    
    public boolean isPasswordCorrect(int employeeID, String password)
    {
        boolean retval=false;
        List<S3cr3t> secrets = ejbFacade.findByEmployeeID(employeeID);
        if(secrets.size()>0)
        {
            String salt=secrets.get(0).getS3cr3tPK().getSalt();
            String hash=CryptoUtils.hashPasswordSHA512(password, salt);
            if(secrets.get(0).getS3cr3tPK().getPass().equals(hash))
            {
                retval=true;
            }
        }
        return retval;
    }

    public S3cr3t getS3cr3t(Integer id) {
        return (S3cr3t) getObject(id);
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
        
        public static S3cr3tController getController()
        {
            FacesContext fc=FacesContext.getCurrentInstance();
            return (S3cr3tController) fc.getApplication().getELResolver().
                    getValue(fc.getELContext(), null, "s3cr3tController");
        }

        Integer getKey(String value) {
            net.xpresstek.zroster.ejb.S3cr3tPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new net.xpresstek.zroster.ejb.S3cr3tPK();
            return Integer.parseInt(values[0]);
        }

        String getStringKey(net.xpresstek.zroster.ejb.S3cr3tPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getUserId());
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
