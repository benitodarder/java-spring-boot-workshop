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
public abstract class AbstractDomainToPersistence<B extends local.tin.tests.crud.model.domain.interfaces.IIdentifiable, P extends local.tin.tests.crud.model.persistence.interfaces.IIdentifiable, K extends Serializable> 
        implements Converter<B, P>, ConverterWithDepth<B, P> {

    protected abstract P getConvertedInstance();
    
    protected abstract P setDepth0Attributes(P p, B b);
    
    protected abstract P setDeeperAttributes(P p, B b, int depth);
    
    protected K getConvertedId(B arg0) {
        return (K) arg0.getId();
    }
    
    @Override
    public P convert(B arg0) {
        return convert(arg0, DEFAULT_DEPTH);
    }
    
    @Override
    public P convert(B arg0, int depth) {
        if (arg0 == null) {
            return null;
        }
        P p = getConvertedInstance();
        setDepth0Attributes(p, arg0);
        if (depth > 1) {
            setDeeperAttributes(p, arg0, depth - 1);
        }
        return p;
    }



}
