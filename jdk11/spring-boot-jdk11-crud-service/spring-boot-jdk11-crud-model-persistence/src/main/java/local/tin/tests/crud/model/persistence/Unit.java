package local.tin.tests.crud.model.persistence;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import local.tin.tests.crud.model.persistence.abstracts.AbstractNamed;


/**
 *
 * @author benito.darder
 */
@Entity
@Table(name = "UNIT")
public class Unit extends AbstractNamed<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "abbreviation")
    private String abbreviation;
    @OneToMany(mappedBy = "unit", fetch = FetchType.LAZY)
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
