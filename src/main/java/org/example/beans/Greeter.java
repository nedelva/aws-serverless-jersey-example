package org.example.beans;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class Greeter {
    String greeting;

    @Inject
    public Greeter(@ConfigProperty(name = "pong", defaultValue = "Hello, World!") String greeting) {
        this.greeting = greeting;
    }

    @Produces
    public String greeting() {
        return this.greeting;
    }
}
