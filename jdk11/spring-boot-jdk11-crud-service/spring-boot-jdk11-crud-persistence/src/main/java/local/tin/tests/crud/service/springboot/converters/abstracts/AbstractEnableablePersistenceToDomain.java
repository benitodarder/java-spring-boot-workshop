package local.tin.tests.crud.service.springboot.converters.abstracts;

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
    protected B setDepth0Attributes(B b, P p) {
        b.setEnabled(p.isEnabled());
        return super.setDepth0Attributes(b, p); 
    }
 




}
