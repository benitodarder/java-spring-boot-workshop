package local.tin.tests.crud.service.springboot.converters.abstracts;

import java.io.Serializable;
import local.tin.tests.crud.service.springboot.converters.interfaces.ConverterWithDepth;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author benitodarder
 * @param <P>
 * @param <B>
 */
public abstract class AbstractEnableablePersistenceToDomain<P extends local.tin.tests.crud.model.persistence.interfaces.IEnableable, B extends local.tin.tests.crud.model.domain.interfaces.IEnableable, K extends Serializable> 
        extends AbstractIdentifiablePersistenceToDomain<P, B, K> implements Converter<P, B>, ConverterWithDepth<P, B> {

    @Override
    protected B setDepth0Attributes(B b, P p) {
        b.setEnabled(p.isEnabled());
        return super.setDepth0Attributes(b, p); 
    }
 




}
