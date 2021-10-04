package local.tin.tests.crud.service.springboot.converters.abstracts;

import local.tin.tests.crud.service.springboot.converters.interfaces.ConverterWithDepth;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author benitodarder
 * @param <P>
 * @param <B>
 */
public abstract class AbstractPersistenceToDomain<P extends local.tin.tests.crud.model.persistence.interfaces.IIdentifiable, B extends local.tin.tests.crud.model.domain.interfaces.IIdentifiable>
        implements Converter<P, B>, ConverterWithDepth<P, B> {
    
    protected abstract B getConvertedInstance();
    
    protected abstract B setDepth0Attributes(B b, P p);
    
    protected abstract B setDeeperAttributes(B b, P p, int depth);    
    
    protected Object getConvertedId(P arg0) {
        return arg0.getId();
    }
    
    @Override
    public B convert(P arg0) {
        return convert(arg0, DEFAULT_DEPTH);
    }
    
    @Override
    public B convert(P arg0, int depth) {
        if (arg0 == null) {
            return null;
        }
        B b = getConvertedInstance();
        setDepth0Attributes(b, arg0);
        if (depth > 1) {
            setDeeperAttributes(b, arg0, depth - 1);
        }
        return b;
    }
    
}
