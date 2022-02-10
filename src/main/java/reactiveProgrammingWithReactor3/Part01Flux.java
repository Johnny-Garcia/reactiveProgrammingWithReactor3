package reactiveProgrammingWithReactor3;


//generic imports to help with simpler IDEs (ie tech.io)
import java.util.*;
import java.time.*;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

/**
 * Learn how to create Flux instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html">Flux Javadoc</a>
 */
@Slf4j
public class Part01Flux {

    public static void main(String[] args) {

        log.info("Teste de fluxo: {}", emptyFlux());
        log.info("Teste de fluxo: {}", fooBarFluxFromValues());
        log.info("Teste de fluxo: {}", fooBarFluxFromList());
        log.info("Teste de fluxo: {}", errorFlux());
        log.info("Teste de fluxo: {}", counter());
    }


//========================================================================================

    // TODO Return an empty Flux
    static Flux<String> emptyFlux() {
        Flux<String> fluxEmpty = Flux
                .just();
        fluxEmpty.subscribe();
        return fluxEmpty;
    }

//========================================================================================

    // TODO Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection
    static Flux<String> fooBarFluxFromValues() {
        Flux<String> flux = Flux
                .just("foo", "bar");
        flux.subscribe();
        return flux;
    }

//========================================================================================

    // TODO Create a Flux from a List that contains 2 values "foo" and "bar"
    static Flux<String> fooBarFluxFromList() {
        List<String> list = new ArrayList<String>();
        list.add("foo");
        list.add("bar");

        Flux<String> flux = Flux
                .fromIterable(list);
        flux.subscribe();
        return flux;
    }

//========================================================================================

    // TODO Create a Flux that emits an IllegalStateException
    static Flux<String> errorFlux() {
        Flux<String> flux = Flux.error(new IllegalStateException());
        return flux;
    }

//========================================================================================

    // TODO Create a Flux that emits increasing values from 0 to 9 each 100ms
    static Flux<Long> counter() {
        Flux<Long> count = Flux.interval(Duration.ofMillis(100)).take(10);
        count.subscribe();
        return count;
    }

}
