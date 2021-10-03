package local.tin.tests.crud.service.springboot.converters.interfaces;

/**
 *
 * @author benitodarder
 */
public interface ConverterWithDepth<C0, C1> {
    
    public C1 convert(C0 c0, int depth);
    
}
