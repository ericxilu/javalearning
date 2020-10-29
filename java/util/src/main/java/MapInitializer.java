import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MapInitializer {
    public static Map<String, String> articleMapOne;
    static {
        articleMapOne = new HashMap<>();
        articleMapOne.put("ar01", "Introto Map");
        articleMapOne.put("ar02", "some article");
    }

    public static Map<String, String> createSingletonMap() {
        return Collections.singletonMap("username1", "password1");
    }

    public static void main(String[] args) {
        log.info("get Guava Immutable Map {}", getGuavaImmutableMap());

    }

    public static Map<String, String> getGuavaImmutableMap(){
        return ImmutableMap.<String, String>builder()
                .put("k1", "v1")
                .put("k2", "v2")
                .build();
    }


}
