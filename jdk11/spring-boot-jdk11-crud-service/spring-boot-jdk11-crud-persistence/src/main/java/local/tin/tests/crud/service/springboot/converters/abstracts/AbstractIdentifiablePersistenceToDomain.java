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
public abstract class AbstractIdentifiablePersistenceToDomain<P extends local.tin.tests.crud.model.persistence.interfaces.IIdentifiable, B extends local.tin.tests.crud.model.domain.interfaces.IIdentifiable, K extends Serializable> 
        extends AbstractPersistenceToDomain<P, B, K> implements Converter<P, B>, ConverterWithDepth<P, B> {

    @Override
    protected B setDepth0Attributes(B b, P p) {
        b.setId(getConvertedId(p));
        return b;
    }





}
