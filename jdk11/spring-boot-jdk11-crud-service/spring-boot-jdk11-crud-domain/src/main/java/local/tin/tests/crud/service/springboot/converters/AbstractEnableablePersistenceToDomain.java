package local.tin.tests.crud.service.springboot.converters;

import local.tin.tests.crud.service.springboot.converters.interfaces.ConverterWithDepth;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author benitodarder
 * @param <P>
 * @param <B>
 */
public abstract class AbstractEnableablePersistenceToDomain<P extends local.tin.tests.crud.model.persistence.interfaces.IEnableable, B extends local.tin.tests.crud.model.domain.interfaces.IEnableable> 
        extends AbstractIdentifiablePersistenceToDomain<P, B> implements Converter<P, B>, ConverterWithDepth<P, B> {
 
    @Override
    public B convert(P arg0) {
        B b = super.convert(arg0);
        b.setEnabled(arg0.isEnabled());
        return b;
    }



}
