package local.tin.tests.crud.model.domain.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import local.tin.tests.crud.model.domain.composites.AssemblyId;


/**
 *
 * @author benitodarder
 */
public class AssemblyIdDeserializer extends StdDeserializer<AssemblyId> {

    public AssemblyIdDeserializer(Class<?> vc) {
        super(vc);
    }

    public AssemblyIdDeserializer() {
        this(null);
    }



    @Override
    public AssemblyId deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = jp.getCodec().readTree(jp);
        AssemblyId request = new AssemblyId();
        request.setComponentId(jsonNode.get("componentId").asInt());
        request.setProductId(jsonNode.get("productId").asInt());
        return request;
    }

}
