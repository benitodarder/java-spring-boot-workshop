package local.tin.tests.crud.model.domain.interfaces;

/**
 *
 * @author benito.darder
 */
public interface IIdentifiable extends IObject {
    
    /**
     * Returns the element identifier, being atomic or composite
     * 
     * @return Object
     */
    public Object getId();
   
    /**
     * Sets the element identifier, being atomic or composite
     * 
     * @param id
     */
    public void setId(Object id);    
    
}
