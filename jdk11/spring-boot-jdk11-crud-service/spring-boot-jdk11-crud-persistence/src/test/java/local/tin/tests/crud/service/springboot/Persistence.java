package local.tin.tests.crud.service.springboot;

public class Persistence extends local.tin.tests.crud.model.persistence.abstracts.AbstractNamed  {
    
    private int id;
    
    @Override
    public Object getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }
 
}
