package local.tin.tests.crud.service.springboot.converters.abstracts;

import local.tin.tests.crud.service.springboot.converters.interfaces.ConverterWithDepth;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author benitodarder
 * @param <P>
 * @param <B>
 */
public abstract class AbstractIdentifiableDomainToPersistence<B extends local.tin.tests.crud.model.domain.interfaces.IIdentifiable, P extends local.tin.tests.crud.model.persistence.interfaces.IIdentifiable> 
         extends AbstractDomainToPersistence<B, P> implements Converter<B, P>, ConverterWithDepth<B, P> {

    @Override
    protected P setDepth0Attributes(P p, B b) {
        p.setId(getConvertedId(b));
        return p;
    }

}
