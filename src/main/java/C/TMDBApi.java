package C;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

/**
 * An implementation of TMDBApi
 * in multiWindowApplication
 *
 * This class is used to access the tmdb api.
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Dez-21
 */
public class TMDBApi {

    /* ---------------------------------------- Main ---------------------------------------------------------------- */



    /* ---------------------------------------- Attributes ---------------------------------------------------------- */

    private String apiKey = "652086fc44227443a5017d1f532898da";
    TmdbSearch search = new TmdbApi(apiKey).getSearch();


    /* ---------------------------------------- Constants ----------------------------------------------------------- */



    /* ---------------------------------------- Constructors -------------------------------------------------------- */



    /* ---------------------------------------- Methods ------------------------------------------------------------- */

    /**
     * Searches for movies with the TMDB Api
     * @param query     name of the movie
     * @param page      result page
     * @param adult     adult yes/no
     */
    public MovieResultsPage search(String query,int page, boolean adult){
        return search.searchMovie(query, null, "eng", true, page);
    }

}
