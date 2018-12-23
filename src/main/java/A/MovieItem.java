package A;

import info.movito.themoviedbapi.model.MovieDb;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * An implementation of MovieItem
 * in multiWindowApplication
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Dez-21
 */
public class MovieItem extends AnchorPane implements Initializable {
    @FXML
    ImageView button;
    @FXML
    Label title;
    @FXML
    ImageView poster;

    private String posterURL;
    private String backdropURL;
    private String describtion;
    private String fullTitle;
    private MovieDb movieDb;


    public MovieItem(String posterURL, String backdropURL, String describtion, String fullTitle, MovieDb movieDb) {
        super();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/fxml/movieItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.posterURL = posterURL;
        this.backdropURL = backdropURL;
        this.describtion = describtion;
        this.fullTitle = fullTitle;
        this.movieDb = movieDb;

        poster.setImage(new Image(this.posterURL));
        title.setText(fullTitle);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Image img = new Image("https://image.tmdb.org/t/p/w300/dCtFvscYcXQKTNvyyaQr2g2UacJ.jpg");
        //GuiToolBox.getRoundCorners(poster,img,true);

    }


    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public String getBackdropURL() {
        return backdropURL;
    }

    public void setBackdropURL(String backdropURL) {
        this.backdropURL = backdropURL;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public MovieDb getMovieDb() {
        return movieDb;
    }

    public void setMovieDb(MovieDb movieDb) {
        this.movieDb = movieDb;
    }
}
