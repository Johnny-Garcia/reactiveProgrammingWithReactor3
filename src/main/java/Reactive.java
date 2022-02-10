import reactor.core.publisher.Flux;

public class Reactive {
    public static void main(String[] args) {
        Reactive reactive = new Reactive();
        reactive.emptyFlux();
    }

    Flux<String> emptyFlux() {
        return null;
    }

}
