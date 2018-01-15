/*
 GNU Lesser General Public License

 Copyright (c) 2017 Wimmer, Simon-Justus

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package chart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.ta4j.core.Indicator;
import org.ta4j.core.Strategy;
import org.ta4j.core.TradingRecord;

public abstract class AbstractProgram extends Application {

    /**
     * Entry point for the JavaFX Application start
     * @param primaryStage the primary stage (handed-down from JavaFX thread)
     * @throws Exception exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/charting-root.fxml"));

        Parent root = fxmlLoader.load();
        RootController rootController = fxmlLoader.<RootController>getController();
        final ChartIndicatorBox indicatorBox = createIndicatorBox();
        rootController.setIndicatorBox(indicatorBox);
        Scene rootScene = new Scene(root);
        rootScene.getStylesheets().add(getClass().getClassLoader().getResource(("fxml/charting-root.css")).toString());
        primaryStage.setScene(rootScene);

        primaryStage.setTitle(indicatorBox.getTimeSeries().getName());
        primaryStage.show();
    }

    /**
     * This method can be overwritten to get custom {@link ChartIndicatorBox} with custom {@link Indicator indicators},
     * {@link Strategy strategies} and {@link TradingRecord}
     * @return a {@link ChartIndicatorBox} for the Chart that is used in the {@link #start(Stage) start(Stage) function}
     * colorOf this class
     */
    abstract public ChartIndicatorBox createIndicatorBox();


}