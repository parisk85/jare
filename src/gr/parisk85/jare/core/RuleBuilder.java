package gr.parisk85.jare.core;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class RuleBuilder<T> {
    Class<T> given;
    Predicate<T> when;
    Consumer<T> then;
    Supplier<? extends Exception> thenThrow;

    public static <T> RuleBuilder<T> given(Class<T> given) {
        return new RuleBuilder(given);
    }

    public RuleBuilder(Class<T> given) {
        this.given = given;
    }

    public RuleBuilder<T> when(Predicate<T> when) {
        this.when = when;
        return this;
    }

    public Rule<T> then(Consumer<T> then) {
        this.then = then;
        return new BasicRule<>(this);
    }

    public Rule<T> thenThrow(Supplier<? extends Exception> thenThrow) {
        this.thenThrow = thenThrow;
        return new BasicRule<>(this);
    }
}
