import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapInitializerTest {
    @Test
    public void givenStatticMap_whenUpdated_thenCorrect(){
        MapInitializer.articleMapOne.put("NewArticle1", "Convert array to List");
        assertEquals(MapInitializer.articleMapOne.get("NewArticle1"), "Convert array to List");
    }

    @Test
    public void givenSingletonMap_whenGet_thenCorrect() {
        Map singletonMap = MapInitializer.createSingletonMap();
        assertEquals(singletonMap.get("username1"), "password1");
    }

    @Test
    public void test(){
        if(false || true)
            System.out.println("true");
    }

}