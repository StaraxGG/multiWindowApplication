package A;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * An implementation of HomeScreen
 * in multiWindowApplication
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Dez-21
 */
public class HomeScreen implements Initializable {

    @FXML
    ImageView logo;
    @FXML
    TilePane tilePane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image("logo.png",400,60,false,true,true);
        logo.setImage(image);

        MovieList movieList = new MovieList();
        tilePane.getChildren().add(movieList.search("harry potter",0,true).get(0));
    }

}
