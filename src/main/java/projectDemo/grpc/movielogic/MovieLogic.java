package projectDemo.grpc.movielogic;

import projectDemo.MovieDetails;
import projectDemo.MovieReply;

import java.util.HashMap;
import java.util.Map;

public class MovieLogic {

    private MovieReply response;

    public MovieReply getResponse() {
        return response;
    }

    public void setResponse(MovieReply response) {
        this.response = response;
    }

    public MovieLogic(String Genre){

        Map<String, MovieReply> genre = new HashMap<>();

        genre.put("Action", MovieReply.newBuilder().addMovieDetails(MovieDetails.newBuilder()
                .setTitle("Days of Future Past")
                .setRating(7.2f)
                .setDescription("X men movies")).build());
        genre.put("Comedy", MovieReply.newBuilder().addMovieDetails(MovieDetails.newBuilder()
                .setTitle("Hangover")
                .setRating(6.7f)
                .setDescription("Movie about drunk guys")).build());
        genre.put("Thriller", MovieReply.newBuilder().addMovieDetails(MovieDetails.newBuilder()
                .setTitle("ShutterIsland")
                .setRating(8.9f)
                .setDescription("Played by Leo")).build());
        genre.put("Drama", MovieReply.newBuilder().addMovieDetails(MovieDetails.newBuilder()
                .setTitle("Drama movie")
                .setRating(8.1f)
                .setDescription("This is some movie")).build());

//        iterate through each movie through hashmap
//        if genre requested by the user matches, respond with the list of movies

        genre.forEach((k,v) -> {
            if (k.equals(Genre)){
                response = v;
            }
        });

    }

}