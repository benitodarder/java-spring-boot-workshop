package local.tin.tests.crud.service.springboot.converters;

/**
 *
 * @author benitodarder
 * @param <P>
 * @param <B>
 */
public abstract class AbstractEnableableDomainToPersistence<B extends local.tin.tests.crud.model.domain.interfaces.IEnableable, P extends local.tin.tests.crud.model.persistence.interfaces.IEnableable> 
        extends AbstractIdentifiableDomainToPersistence<B, P> {

    @Override
    public P convert(B arg0) {
        P p = super.convert(arg0);
        p.setEnabled(arg0.isEnabled());
        return p;
    }
    




}
