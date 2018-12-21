package B;

import C.TMDBApi;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

/**
 * An implementation of MovieManager
 * in multiWindowApplication
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Dez-21
 */
public class MovieManager {

    /* ---------------------------------------- Main ---------------------------------------------------------------- */



    /* ---------------------------------------- Attributes ---------------------------------------------------------- */

    private TMDBApi api = new TMDBApi();

    /* ---------------------------------------- Constants ----------------------------------------------------------- */



    /* ---------------------------------------- Constructors -------------------------------------------------------- */



    /* ---------------------------------------- Methods ------------------------------------------------------------- */

    /**
     * Searches for movies with the TMDB Api
     * @param query     name of the movie
     * @param adult     adult yes/no
     */
    public MovieResultsPage search(String query,int page, boolean adult){
        return api.search(query, page,true);
    }


    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */

}
