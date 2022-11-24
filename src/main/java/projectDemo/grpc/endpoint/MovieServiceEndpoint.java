

package projectDemo.grpc.endpoint;

import io.grpc.stub.StreamObserver;
import jakarta.inject.Singleton;
import projectDemo.GenreRequest;
import projectDemo.MovieReply;
import projectDemo.MovieServiceGrpc;
import projectDemo.grpc.movielogic.MovieLogic;

@Singleton
public class MovieServiceEndpoint extends MovieServiceGrpc.MovieServiceImplBase {

    @Override
    public void send(GenreRequest request, StreamObserver<MovieReply> responseObserver) {

//        get the genre request and store it in genre
        String genre = request.getGenre();

        MovieLogic m = new MovieLogic(genre);

        responseObserver.onNext(m.getResponse());

        responseObserver.onCompleted();


    }
}