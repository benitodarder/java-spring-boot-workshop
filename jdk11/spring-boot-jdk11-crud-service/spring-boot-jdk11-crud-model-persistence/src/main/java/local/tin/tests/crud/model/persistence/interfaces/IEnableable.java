package local.tin.tests.crud.model.persistence.interfaces;

import java.io.Serializable;

/**
 *
 * @author benitodarder
 */
public interface IEnableable<K extends Serializable> extends IIdentifiable<K> {
    
    /**
     * Returns enabled/disabled status
     * 
     * @return boolean
     */
    public boolean isEnabled();
    
    /**
     * Sets enabled/disabled status
     * 
     * @param enabled boolean
     */
    public void setEnabled(boolean enabled);
    
}
