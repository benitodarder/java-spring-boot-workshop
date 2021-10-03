package local.tin.tests.crud.service.springboot.converters;

import local.tin.tests.crud.service.springboot.converters.interfaces.ConverterWithDepth;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author benitodarder
 * @param <P>
 * @param <B>
 */
public abstract class AbstractIdentifiableDomainToPersistence<B extends local.tin.tests.crud.model.domain.interfaces.IIdentifiable, P extends local.tin.tests.crud.model.persistence.interfaces.IIdentifiable> 
        implements Converter<B, P>, ConverterWithDepth<B, P> {

    protected abstract P getConvertedInstance();
    
    protected Object getConvertedId(B arg0) {
        return arg0.getId();
    }
    
    @Override
    public P convert(B arg0) {
        P p = getConvertedInstance();
        p.setId(getConvertedId(arg0));
        return p;
    }
    




}
