package local.tin.tests.crud.model.domain.abstracts;

import local.tin.tests.crud.model.domain.interfaces.IEnableable;




/**
 *
 * @author benitodarder
 */

public abstract class AbstractEnableable extends AbstractIdentifiable implements IEnableable {
  
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
