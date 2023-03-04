package local.tin.tests.crud.model.persistence.interfaces;

import java.io.Serializable;

/**
 *
 * @author benito.darder
 */
public interface INamed<K extends Serializable> extends IEnableable<K> {
    
    /**
     * Returns the element name
     * 
     * @return String
     */
    public String getName();
   
    /**
     * Sets the element name
     * 
     * @param name
     */
    public void setName(String name);    
        
}
