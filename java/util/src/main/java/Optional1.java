import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.function.Supplier;

@Slf4j
public class Optional1 {
    static class Outer {
        Nested nested;

        public Nested getNested() {
            return nested;
        }

    }

    static class Nested {
        Inner inner;

        public Inner getInner() {
            return inner;
        }

    }

    static class Inner {
        String foo;

        public String getFoo() {
            return foo;
        }
    }


    public static <T> Optional<T> resolve(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return Optional.ofNullable(result);
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }

    public static void test1() {
        Optional.of(new Outer())
                .map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo)
                .ifPresent(x -> log.info(x));
    }

    public static void main(String[] args) {
        test1();
    }


}
