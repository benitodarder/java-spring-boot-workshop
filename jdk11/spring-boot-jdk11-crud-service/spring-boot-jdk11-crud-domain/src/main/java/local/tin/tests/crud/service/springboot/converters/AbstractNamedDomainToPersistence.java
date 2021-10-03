package local.tin.tests.crud.service.springboot.converters;

/**
 *
 * @author benitodarder
 * @param <P>
 * @param <B>
 */
public abstract class AbstractNamedDomainToPersistence<B extends local.tin.tests.crud.model.domain.interfaces.INamed, P extends local.tin.tests.crud.model.persistence.interfaces.INamed> 
        extends AbstractEnableableDomainToPersistence<B, P> {

    @Override
    public P convert(B arg0) {
        P p = super.convert(arg0);
        p.setName(arg0.getName());
        return p;
    }
    




}
