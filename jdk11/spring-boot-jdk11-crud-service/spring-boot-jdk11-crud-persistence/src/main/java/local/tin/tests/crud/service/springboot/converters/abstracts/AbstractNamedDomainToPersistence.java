package local.tin.tests.crud.service.springboot.converters.abstracts;

/**
 *
 * @author benitodarder
 * @param <P>
 * @param <B>
 */
public abstract class AbstractNamedDomainToPersistence<B extends local.tin.tests.crud.model.domain.interfaces.INamed, P extends local.tin.tests.crud.model.persistence.interfaces.INamed> 
        extends AbstractEnableableDomainToPersistence<B, P> {

    @Override
    protected P setDepth0Attributes(P p, B b) {
        p.setName(b.getName());
        return super.setDepth0Attributes(p, b);
    }




}
