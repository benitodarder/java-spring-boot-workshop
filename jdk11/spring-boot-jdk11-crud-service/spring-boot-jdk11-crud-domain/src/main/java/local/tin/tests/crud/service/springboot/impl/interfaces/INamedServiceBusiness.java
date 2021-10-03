package local.tin.tests.crud.service.springboot.impl.interfaces;

import java.util.List;
import local.tin.tests.crud.model.domain.abstracts.AbstractIdentifiable;

/**
 *
 * @author benitodarder
 * @param <BN>
 */
public interface INamedServiceBusiness<BN extends AbstractIdentifiable> extends IServiceBusiness<BN> {
    
    public List<BN> findByName(String name);

}
