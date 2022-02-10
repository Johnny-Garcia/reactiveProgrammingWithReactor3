package reactiveProgrammingWithReactor3;


import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * Learn how to create Mono instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html">Mono Javadoc</a>
 */
@Slf4j
public class Part02Mono {

    public static void main(String[] args) {
        log.info("Teste mono: {}", emptyMono());
        log.info("Teste mono: {}", monoWithNoSignal());
        log.info("Teste mono: {}", fooMono());
        log.info("Teste mono: {}", errorMono());
    }

//========================================================================================

    // TODO Return an empty Mono
    static Mono<String> emptyMono() {
        Mono<String> monoEmpty = Mono
                .empty();
        return monoEmpty;
    }

//========================================================================================

    // TODO Return a Mono that never emits any signal
    static Mono<String> monoWithNoSignal() {
        Mono<String> monoNoSignal = Mono
                .never();
        return monoNoSignal;
    }

//========================================================================================

    // TODO Return a Mono that contains a "foo" value
    static Mono<String> fooMono() {
        Mono<String> monoFoo = Mono
                .just("foo");
        monoFoo.subscribe();
        return monoFoo;
    }

//========================================================================================

    // TODO Create a Mono that emits an IllegalStateException
    static Mono<String> errorMono() {
        Mono<String> monoError = Mono
                .error(new IllegalStateException());
        return monoError;
    }

}
