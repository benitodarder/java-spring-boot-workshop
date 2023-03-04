package local.tin.tests.crud.service.springboot;

public class Persistence extends local.tin.tests.crud.model.persistence.abstracts.AbstractNamed<Integer>  {
    
    private Integer id;
    
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = (Integer) id;
    }
 
}
