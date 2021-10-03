package local.tin.tests.crud.model.domain.composites;

import java.util.Objects;
import local.tin.tests.crud.model.domain.interfaces.ICompositeId;



/**
 *
 * @author benito.darder
 */
public class AssemblyId implements ICompositeId {
    
    private Integer productId;  
    private Integer componentId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer product) {
        this.productId = product;
    }

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer component) {
        this.componentId = component;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.productId);
        hash = 23 * hash + Objects.hashCode(this.componentId);
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
        final AssemblyId other = (AssemblyId) obj;
        if (!Objects.equals(this.productId, other.productId)) {
            return false;
        }
        return Objects.equals(this.componentId, other.componentId);
    }
}
