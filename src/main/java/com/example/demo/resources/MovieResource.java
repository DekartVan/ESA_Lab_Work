package com.example.demo.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import com.example.demo.models.Movie;
import com.example.demo.services.MovieService;

import java.util.List;

@Path("/movie")
public class MovieResource {

    @Inject
    private MovieService movieService;

    @GET
    @Produces("application/json")
    public List<Movie> getAll() {
        return movieService.findAll();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Movie create(Movie movie) {
        movieService.create(movie);
        return movie;
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public void deleteById(@PathParam("id") Long id) {
        movieService.deleteById(id);
    }
}
