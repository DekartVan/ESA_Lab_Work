package com.example.demo.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import com.example.demo.models.Director;
import com.example.demo.services.DirectorService;

import java.util.List;

@Path("/director")
public class DirectorResource {

    @Inject
    private DirectorService directorService;

    @GET
    @Produces("application/json")
    public List<Director> getAll() {
        return directorService.findAll();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Director create(Director director) {
        directorService.create(director);
        return director;
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public void deleteById(@PathParam("id") Long id) {
        directorService.deleteById(id);
    }

}
