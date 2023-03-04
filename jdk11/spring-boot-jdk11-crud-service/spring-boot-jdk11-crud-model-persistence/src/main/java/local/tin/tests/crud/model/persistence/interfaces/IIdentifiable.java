package local.tin.tests.crud.model.persistence.interfaces;

import java.io.Serializable;

/**
 *
 * @author benito.darder
 */
public interface IIdentifiable<K extends Serializable> extends IObject {
    
    /**
     * Returns the element identifier, being atomic or composite
     * 
     * @return Object
     */
    public K getId();
   
    /**
     * Sets the element identifier, being atomic or composite
     * 
     * @param id
     */
    public void setId(K id);    
    
}
