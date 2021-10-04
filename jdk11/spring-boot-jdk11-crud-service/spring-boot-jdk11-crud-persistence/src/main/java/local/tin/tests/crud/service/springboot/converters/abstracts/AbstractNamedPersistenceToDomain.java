package local.tin.tests.crud.service.springboot.converters.abstracts;

/**
 *
 * @author benitodarder
 * @param <P>
 * @param <B>
 */
public abstract class AbstractNamedPersistenceToDomain<P extends local.tin.tests.crud.model.persistence.interfaces.INamed, B extends local.tin.tests.crud.model.domain.interfaces.INamed> 
        extends AbstractEnableablePersistenceToDomain<P, B> {

    @Override
    protected B setDepth0Attributes(B b, P p) {
        b.setName(p.getName());
        return super.setDepth0Attributes(b, p); 
    }



}
