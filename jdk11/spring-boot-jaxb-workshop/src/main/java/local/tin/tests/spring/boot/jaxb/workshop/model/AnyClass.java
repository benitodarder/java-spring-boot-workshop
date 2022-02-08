package local.tin.tests.spring.boot.jaxb.workshop.model;

import java.util.Objects;

/**
 *
 * @author benitodarder
 */
public class AnyClass {
    
    private int id;
    private String string;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.string);
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
        final AnyClass other = (AnyClass) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.string, other.string)) {
            return false;
        }
        return true;
    }
    
    

}
