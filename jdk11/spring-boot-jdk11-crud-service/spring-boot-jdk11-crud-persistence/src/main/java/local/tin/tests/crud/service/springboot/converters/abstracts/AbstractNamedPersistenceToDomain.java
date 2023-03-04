package local.tin.tests.crud.service.springboot.converters.abstracts;

import java.io.Serializable;

/**
 *
 * @author benitodarder
 * @param <P>
 * @param <B>
 */
public abstract class AbstractNamedPersistenceToDomain<P extends local.tin.tests.crud.model.persistence.interfaces.INamed, B extends local.tin.tests.crud.model.domain.interfaces.INamed, K extends Serializable> 
        extends AbstractEnableablePersistenceToDomain<P, B, K> {

    @Override
    protected B setDepth0Attributes(B b, P p) {
        b.setName(p.getName());
        return super.setDepth0Attributes(b, p); 
    }



}
