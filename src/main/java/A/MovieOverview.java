package A;

import A.screensFramework.ControlledScreen;
import A.screensFramework.ScreensController;
import A.screensFramework.ScreensFramework;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

/**
 * An implementation of MovieOverview
 * in multiWindowApplication
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Dez-21
 */
public class MovieOverview implements ControlledScreen, Initializable {

    /* ---------------------------------------- Main ---------------------------------------------------------------- */



    /* ---------------------------------------- Attributes ---------------------------------------------------------- */

    @FXML
    private ImageView imgBackdrop;

    @FXML
    private ImageView imgCover;

    @FXML
    private Label lblYear;

    @FXML
    private Label lblTitle;

    @FXML
    private Label titleOverview;

    @FXML
    private Label lblRating;

    @FXML
    private JFXButton backButton;

    private ScreensController topController;

    /* ---------------------------------------- Constants ----------------------------------------------------------- */



    /* ---------------------------------------- Constructors -------------------------------------------------------- */

    /* ---------------------------------------- Methods ------------------------------------------------------------- */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MovieList movieList = new MovieList();
        LinkedList<MovieItem> movieItem = movieList.search("harry potter", 0, true);
        this.setMovie(movieItem.get(0));
    }

    public void setMovie(MovieItem movieItem){
        this.imgBackdrop.setImage(new Image((movieItem.getBackdropURL())));
        this.imgCover.setImage(new Image((movieItem.getPosterURL())));
        this.lblYear.setText(movieItem.getMovieDb().getReleaseDate().substring(0,4));
        this.lblTitle.setText(movieItem.getMovieDb().getTitle());
        this.titleOverview.setText(movieItem.getMovieDb().getOverview());
        this.lblRating.setText(Float.toString(movieItem.getMovieDb().getVoteAverage()));
    }

    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */

    @Override
    public void setScreenParent(ScreensController screenParent) {
        topController = screenParent;
    }

    @Override
    public void setScreenContent(LinkedList<MovieItem> movieItems, int i) {
        this.setMovie(movieItems.get(i));
    }

    @FXML
    private void goBack(ActionEvent event){
        topController.setScreen(ScreensFramework.screen1ID);
    }
}
