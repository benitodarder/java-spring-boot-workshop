package local.tin.tests.spring.boot.web.page.model;

import java.util.Objects;

/**
 *
 * @author benitodarder
 */
public class Pojo {
    
    private Integer id;
    private String string;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.string);
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
        final Pojo other = (Pojo) obj;
        if (!Objects.equals(this.string, other.string)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
}
