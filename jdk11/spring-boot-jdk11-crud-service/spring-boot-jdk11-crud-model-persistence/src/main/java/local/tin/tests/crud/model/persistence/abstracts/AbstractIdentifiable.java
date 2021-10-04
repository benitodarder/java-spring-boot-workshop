package local.tin.tests.crud.model.persistence.abstracts;

import java.util.Objects;
import javax.persistence.MappedSuperclass;
import local.tin.tests.crud.model.persistence.interfaces.IIdentifiable;


/**
 *
 * @author benitodarder
 */
@MappedSuperclass
public abstract class AbstractIdentifiable extends AbstractObject implements IIdentifiable {
    


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
