package local.tin.tests.crud.model.domain.abstracts;

import java.io.Serializable;
import java.util.Objects;
import local.tin.tests.crud.model.domain.interfaces.INamed;



/**
 *
 * @author benitodarder
 */
public abstract class AbstractNamed<K extends Serializable> extends AbstractEnableable<K> implements INamed<K> {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + super.hashCode();
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
        final AbstractNamed other = (AbstractNamed) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!this.name.equalsIgnoreCase(other.name)) {
            return false;
        }        
        return super.equals(obj);
    }
    
    

}
