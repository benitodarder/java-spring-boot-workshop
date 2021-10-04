package local.tin.tests.crud.service.springboot.converters.abstracts;

/**
 *
 * @author benitodarder
 * @param <P>
 * @param <B>
 */
public abstract class AbstractEnableableDomainToPersistence<B extends local.tin.tests.crud.model.domain.interfaces.IEnableable, P extends local.tin.tests.crud.model.persistence.interfaces.IEnableable> 
        extends AbstractIdentifiableDomainToPersistence<B, P> {

    @Override
    protected P setDepth0Attributes(P p, B b) {
        super.setDepth0Attributes(p, b);
        p.setEnabled(b.isEnabled());
        return p;
    }



}
