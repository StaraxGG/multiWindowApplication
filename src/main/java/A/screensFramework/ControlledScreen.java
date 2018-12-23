package A.screensFramework;

import A.MovieItem;
import A.MovieList;

import java.util.LinkedList;

/**
 * An implementation of ControlledScreen
 * in multiWindowApplication
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Dez-22
 */
public interface ControlledScreen {

    /**
     * This method will allow the injection of the Parent ScreenPane
      * @param screenParent
     */
   public void setScreenParent(ScreensController screenParent);

   public void setScreenContent(LinkedList<MovieItem> movieItems, int index);
}
