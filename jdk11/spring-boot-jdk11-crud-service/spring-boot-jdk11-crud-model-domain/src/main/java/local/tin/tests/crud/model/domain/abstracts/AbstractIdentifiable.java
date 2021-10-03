package local.tin.tests.crud.model.domain.abstracts;

import java.util.Objects;
import local.tin.tests.crud.model.domain.interfaces.IIdentifiable;


/**
 *
 * @author benitodarder
 */
public abstract class AbstractIdentifiable extends AbstractObject implements IIdentifiable {
    
 
    private Integer id;

    @Override
    public Object getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.getId());
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
        final AbstractIdentifiable other = (AbstractIdentifiable) obj;
        return Objects.equals(this.getId(), other.getId());
    }
}
