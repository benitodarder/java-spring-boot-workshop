package local.tin.tests.crud.model.persistence.abstracts;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import local.tin.tests.crud.model.persistence.interfaces.IEnableable;


/**
 *
 * @author benitodarder
 */
@MappedSuperclass
public abstract class AbstractEnableable<K extends Serializable> extends AbstractIdentifiable<K> implements IEnableable<K> {
   
    @Column(name = "enabled")
    private boolean enabled;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (this.enabled ? 1 : 0);
        hash = 83 * hash + super.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractEnableable other = (AbstractEnableable) obj;
        if (this.enabled != other.enabled) {
            return false;
        }
        return super.equals(obj);
    }

    
}
