package local.tin.tests.crud.model.domain.abstracts;

import java.io.Serializable;
import local.tin.tests.crud.model.domain.interfaces.IEnableable;




/**
 *
 * @author benitodarder
 */

public abstract class AbstractEnableable<K extends Serializable> extends AbstractIdentifiable<K> implements IEnableable<K> {
  
    private boolean enabled;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }    

    
}
