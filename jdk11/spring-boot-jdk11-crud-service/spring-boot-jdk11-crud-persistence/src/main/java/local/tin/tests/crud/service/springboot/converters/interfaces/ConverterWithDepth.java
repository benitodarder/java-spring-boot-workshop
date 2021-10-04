package local.tin.tests.crud.service.springboot.converters.interfaces;

/**
 *
 * @author benitodarder
 */
public interface ConverterWithDepth<C0, C1> {

    public static final int DEFAULT_DEPTH = 1;

    public C1 convert(C0 c0, int depth);

}
