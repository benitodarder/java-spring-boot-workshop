package local.tin.tests.crud.service.springboot.converters;

/**
 *
 * @author benitodarder
 * @param <P>
 * @param <B>
 */
public abstract class AbstractNamedPersistenceToDomain<P extends local.tin.tests.crud.model.persistence.interfaces.INamed, B extends local.tin.tests.crud.model.domain.interfaces.INamed> 
        extends AbstractEnableablePersistenceToDomain<P, B> {
    
    @Override
    public B convert(P arg0) {
        B b = super.convert(arg0);
        b.setName(arg0.getName());
        return b;
    }



}
