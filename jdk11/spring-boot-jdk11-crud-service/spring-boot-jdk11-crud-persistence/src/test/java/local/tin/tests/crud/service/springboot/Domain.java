package local.tin.tests.crud.service.springboot;

public class Domain extends local.tin.tests.crud.model.domain.abstracts.AbstractNamed  {

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