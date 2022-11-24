package projectDemo.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import projectDemo.GenreRequest;
import projectDemo.MovieReply;
import projectDemo.MovieServiceGrpc;

import java.util.Iterator;

public class Client {

    public static void main(String[] args) {

        Client client = new Client();
        client.run();
    }

    private void run(){

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        unaryCall(channel);
    }

    private void unaryCall(ManagedChannel channel) {
        MovieServiceGrpc.MovieServiceBlockingStub client = MovieServiceGrpc.newBlockingStub(channel);

        GenreRequest request = GenreRequest.newBuilder()
                .setGenre("Comedy")
                .build();

//        MovieReply response = client.send(request);
//        System.out.println(response);


        Iterator<MovieReply> response = client.send(request);
        for (int i = 1; response.hasNext(); i++) {
            System.out.println(response.next());
        }


    }
}