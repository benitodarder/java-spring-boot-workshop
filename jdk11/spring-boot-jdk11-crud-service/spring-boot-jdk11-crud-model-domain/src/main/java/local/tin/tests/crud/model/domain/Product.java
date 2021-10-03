package local.tin.tests.crud.model.domain;

import java.util.HashSet;
import java.util.Set;
import local.tin.tests.crud.model.domain.abstracts.AbstractNamed;


/**
 *
 * @author benito.darder
 */
public class Product extends AbstractNamed {


    private Integer id;
    private String description;
    private Set<Assembly> assemblies;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
