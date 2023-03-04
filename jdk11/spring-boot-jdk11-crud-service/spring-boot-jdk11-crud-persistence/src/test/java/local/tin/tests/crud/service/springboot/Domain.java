package local.tin.tests.crud.service.springboot;

public class Domain extends local.tin.tests.crud.model.domain.abstracts.AbstractNamed<Integer>  {

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