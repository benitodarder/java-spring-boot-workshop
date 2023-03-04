package local.tin.tests.crud.model.domain;

import java.util.HashSet;
import java.util.Set;
import local.tin.tests.crud.model.domain.abstracts.AbstractNamed;



/**
 *
 * @author benito.darder
 */

public class Component extends AbstractNamed<Integer> {
    

    private Integer id; 
    private Unit unit;
    private Set<Assembly> assemblies;   
    
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = (Integer) id;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Set<Assembly> getAssemblies() {
        if (assemblies == null) {
            assemblies = new HashSet<>();
        }
        return assemblies;
    }

    public void setAssemblies(Set<Assembly> assemblies) {
        this.assemblies = assemblies;
    }

    
}
