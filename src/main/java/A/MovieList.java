package A;

import B.MovieManager;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

import java.util.LinkedList;

/**
 * An implementation of MovieList
 * in multiWindowApplication
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Dez-21
 */
public class MovieList {

    /* ---------------------------------------- Main ---------------------------------------------------------------- */



    /* ---------------------------------------- Attributes ---------------------------------------------------------- */

    private MovieManager movieManager = new MovieManager();


    /* ---------------------------------------- Constants ----------------------------------------------------------- */



    /* ---------------------------------------- Constructors -------------------------------------------------------- */



    /* ---------------------------------------- Methods ------------------------------------------------------------- */

    public LinkedList<MovieItem>search(String query, int page, boolean adult){

        MovieResultsPage apiResults = movieManager.search(query, page, adult);
        LinkedList<MovieItem> movieResults = new LinkedList<>();

        apiResults.getResults().forEach(movieDb -> {
            String posterPath = "https://image.tmdb.org/t/p/w300"+movieDb.getPosterPath();
            String backDropPath = "https://image.tmdb.org/t/p/w1280"+movieDb.getBackdropPath();
            MovieItem movieItem = new MovieItem(posterPath,backDropPath,movieDb.getOverview(),movieDb.getTitle(),movieDb);
            movieResults.add(movieItem);
        });

        return movieResults;
    }

    public LinkedList<MovieItem>popularMovies(int page, boolean adult){
        MovieResultsPage apiResults = movieManager.popularMovies(page, adult);
        LinkedList<MovieItem> movieResults = new LinkedList<>();

        apiResults.getResults().forEach(movieDb -> {
            String posterPath = "https://image.tmdb.org/t/p/w300"+movieDb.getPosterPath();
            String backDropPath = "https://image.tmdb.org/t/p/w1280"+movieDb.getBackdropPath();
            MovieItem movieItem = new MovieItem(posterPath,backDropPath,movieDb.getOverview(),movieDb.getTitle(),movieDb);
            movieResults.add(movieItem);
        });

        return movieResults;
    }


    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */

}
