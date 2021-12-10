package com.epam.training.ticketservice.managers;

import com.epam.training.ticketservice.services.movies.MovieServiceImpl;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class MovieManager {

    private final MovieServiceImpl movieServiceImpl;
    private final UserManager userManager;

    public MovieManager(MovieServiceImpl movieServiceImpl, UserManager userManager) {
        this.movieServiceImpl = movieServiceImpl;
        this.userManager = userManager;
    }

    @ShellMethod(key="create movie", value="Allow admin to create given movie")
    public void createMovie(String title, String genre, int length){
        if(userManager.isAdminUser())
            movieServiceImpl.addMovie(title, genre, length);
    }

    @ShellMethod(key="update movie", value="Allow admin to update given movie")
    public void updateMovie(String title, String genre, int length){
        if(userManager.isAdminUser())
            movieServiceImpl.updateMovie(title, genre, length);
    }

    @ShellMethod(key="delete movie", value="Allow admin to delete given movie")
    public void deleteMovie(String title){
        if(userManager.isAdminUser())
            movieServiceImpl.deleteMovie(title);
    }

    @ShellMethod(key="list movies", value="Allow anyone to list movies")
    public void listMovies(){
        movieServiceImpl.listMovies();
    }

}
