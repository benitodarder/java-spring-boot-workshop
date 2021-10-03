package local.tin.tests.spring.boot.simple.crud.model.data.embeddables;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import local.tin.tests.spring.boot.simple.crud.model.data.interfaces.IEmbeddable;

/**
 *
 * @author benito.darder
 */
@Embeddable
public class AssemblyId implements IEmbeddable {
    
    @Column(name = "PRODUCTID")
    private Integer productId;  
    @Column(name = "COMPONENTID")
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
