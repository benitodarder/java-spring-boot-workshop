package  local.tin.tests.crud.model.domain;

import java.util.Objects;
import local.tin.tests.crud.model.domain.abstracts.AbstractEnableable;
import local.tin.tests.crud.model.domain.composites.AssemblyId;



/**
 *
 * @author benito.darder
 */

public class Assembly extends AbstractEnableable {


    private AssemblyId id;
    private Double quantity;
    private Product product;
    private Component component;
    

    @Override
    public AssemblyId getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (AssemblyId) id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.quantity);
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
        final Assembly other = (Assembly) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.quantity, other.quantity);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }
    
    
}
