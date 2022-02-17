package projectReactorEssentialsYT;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class MonoTest {

    @Test
    public void monoSubscriber(){
        String name = "Jonathan";
        String surname = "Garcia";
        List<String> names = new ArrayList<>();

        Mono<String> mono = Mono.just(name).log();
        Flux<String> flux = Flux.just(name, surname).log();
        names.stream().collect(Collectors.joining());
        flux.error(new Throwable());
        mono.subscribe();
        flux.subscribe();

        //StepVerifier dando erro!!!!
        //StepVerifier.create(mono).expectNext(name).verifyComplete();

    }
    @Test
    public void monoSubscriberConsumer(){
        String name = "Jonathan";
        String surname = "Garcia";

        Mono<String> mono = Mono.just(name).log();

        mono.subscribe(s -> log.info("Valor subscrito: {}", s));

        // Não funciona
        StepVerifier.create(mono)
                .expectSubscription()
                .expectNext(name)
                .expectNextCount(10)
                .thenAwait(Duration.ofSeconds(1))
                .verifyComplete();

    }

    @Test
    public void monoSubscriberConsumerError() {
        String name = "Jonathan";
        String surname = "Garcia";

        Mono<String> mono = Mono.just(name)
                .map(s -> {throw new RuntimeException("Erro de Runtime");});
        mono.subscribe(s -> log.info("Valor subscrito: {}", s), s -> log.error("Ocorreu algum erro!"));

        StepVerifier.create(mono)
                .expectError(RuntimeException.class)
                .verify();
    }
}
