package local.tin.tests.crud.service.springboot.converters.abstracts;

import java.io.Serializable;

/**
 *
 * @author benitodarder
 * @param <P>
 * @param <B>
 */
public abstract class AbstractEnableableDomainToPersistence<B extends local.tin.tests.crud.model.domain.interfaces.IEnableable, P extends local.tin.tests.crud.model.persistence.interfaces.IEnableable, K extends Serializable> 
        extends AbstractIdentifiableDomainToPersistence<B, P, K> {

    @Override
    protected P setDepth0Attributes(P p, B b) {
        super.setDepth0Attributes(p, b);
        p.setEnabled(b.isEnabled());
        return p;
    }



}
