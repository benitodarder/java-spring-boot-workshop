package local.tin.tests.spring.boot.simple.crud.model.data.interfaces;

/**
 *
 * @author benito.darder
 */
public interface INamed extends IEnableable {
    
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
