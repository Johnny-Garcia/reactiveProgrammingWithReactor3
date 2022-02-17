package reactiveProgrammingWithReactor3;

//generic imports to help with simpler IDEs (ie tech.io)
import java.util.*;
import java.util.function.*;
import java.time.*;

import model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Learn how to transform values.
 *
 * @author Sebastien Deleuze
 */
public class Part04Transform {

//========================================================================================

    // TODO Capitalize the user username, firstname and lastname
    Mono<User> capitalizeOne(Mono<User> mono) {
        Mono<User> user = mono
                .map(m -> new User(
                        m.getUsername().toUpperCase(),
                        m.getFirstname().toUpperCase(),
                        m.getLastname().toUpperCase()
                ));
        return user;
    }

//========================================================================================

    // TODO Capitalize the users username, firstName and lastName
    Flux<User> capitalizeMany(Flux<User> flux) {
        Flux<User> user = flux
                .map(f -> new User(
                        f.getUsername().toUpperCase(),
                        f.getFirstname().toUpperCase(),
                        f.getLastname().toUpperCase()
                ));
        return user;
    }

//========================================================================================

    // TODO Capitalize the users username, firstName and lastName using #asyncCapitalizeUser
    Flux<User> asyncCapitalizeMany(Flux<User> flux) {
        Flux<User> user = flux
                .flatMap(this::asyncCapitalizeUser);
        return user;
    }

    Mono<User> asyncCapitalizeUser(User u) {
        return Mono.just(new User(u.getUsername().toUpperCase(), u.getFirstname().toUpperCase(), u.getLastname().toUpperCase()));
    }

}

