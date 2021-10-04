package local.tin.tests.crud.model.domain.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import local.tin.tests.crud.model.domain.Assembly;
import local.tin.tests.crud.model.domain.Component;
import local.tin.tests.crud.model.domain.Product;
import local.tin.tests.crud.model.domain.composites.AssemblyId;


/**
 *
 * @author benitodarder
 */
public class AssemblyDeserializer extends StdDeserializer<Assembly> {

    public AssemblyDeserializer(Class<?> vc) {
        super(vc);
    }

    public AssemblyDeserializer() {
        this(null);
    }



    @Override
    public Assembly deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = jp.getCodec().readTree(jp);
        AssemblyId assemblyId = new AssemblyId();
        assemblyId.setComponentId(jsonNode.get("id").get("componentId").asInt());
        assemblyId.setProductId(jsonNode.get("id").get("productId").asInt());
        Assembly assembly = new Assembly();
        assembly.setId(assemblyId);
        if (jsonNode.get("component") != null) {
            assembly.setComponent(mapper.readValue(jsonNode.get("component").toString(), Component.class));
        }
        if (jsonNode.get("product") != null) {
            assembly.setProduct(mapper.readValue(jsonNode.get("product").toString(), Product.class));
        }
        if (jsonNode.get("quantity") != null) {
            assembly.setQuantity(jsonNode.get("quantity").asDouble());
        }
        return assembly;
    }

}
