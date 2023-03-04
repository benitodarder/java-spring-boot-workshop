package local.tin.tests.crud.model.domain;

import java.util.HashSet;
import java.util.Set;
import local.tin.tests.crud.model.domain.abstracts.AbstractNamed;



/**
 *
 * @author benito.darder
 */

public class Unit extends AbstractNamed<Integer> {


    private Integer id;
    private String abbreviation;
    private Set<Component> components;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = (Integer) id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Set<Component> getComponents() {
        if (components == null) {
            components = new HashSet<>();
        }
        return components;
    }

    public void setComponents(Set<Component> components) {
        this.components = components;
    }

}
