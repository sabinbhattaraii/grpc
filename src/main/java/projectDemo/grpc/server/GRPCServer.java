package projectDemo.grpc.server;

import projectDemo.grpc.endpoint.MovieServiceEndpoint;
import io.grpc.ServerBuilder;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.event.BeanCreatedEvent;
import io.micronaut.context.event.BeanCreatedEventListener;
import jakarta.inject.Inject;

@Factory
public class GRPCServer<T extends ServerBuilder<T>> implements BeanCreatedEventListener<T> {

    private final MovieServiceEndpoint movieServiceEndpoint;

    //    constructor
    @Inject
    GRPCServer(MovieServiceEndpoint movieServiceEndpoint){
        this.movieServiceEndpoint = movieServiceEndpoint;
    }


    @Override
    public T onCreated(BeanCreatedEvent<T> event) {
        return event.getBean()
                .addService(movieServiceEndpoint);
    }
}