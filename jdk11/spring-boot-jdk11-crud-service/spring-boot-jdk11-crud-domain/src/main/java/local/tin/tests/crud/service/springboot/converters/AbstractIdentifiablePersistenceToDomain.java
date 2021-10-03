package local.tin.tests.crud.service.springboot.converters;

import local.tin.tests.crud.service.springboot.converters.interfaces.ConverterWithDepth;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author benitodarder
 * @param <P>
 * @param <B>
 */
public abstract class AbstractIdentifiablePersistenceToDomain<P extends local.tin.tests.crud.model.persistence.interfaces.IIdentifiable, B extends local.tin.tests.crud.model.domain.interfaces.IIdentifiable> 
        implements Converter<P, B>, ConverterWithDepth<P, B> {

    protected abstract B getConvertedInstance();
    
    protected Object getConvertedId(P arg0) {
        return arg0.getId();
    }
    
    @Override
    public B convert(P arg0) {
        B b = getConvertedInstance();
        b.setId(getConvertedId(arg0));
        return b;
    }



}
