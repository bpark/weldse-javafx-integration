/*
 * This file is part of weldse-javafx-integration.
 *
 * Foobar is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.bpark.weld.fx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * @author Kurt Sparber
 */
public class FxApplication extends Application {

    private WeldContainer container;

    @Override
    public void start(Stage stage) throws Exception {
        Weld weld = new Weld();
        container = weld.initialize();
        StageInitService sceneInitService = container.select(StageInitService.class).get();
        sceneInitService.init(stage);
    }

    public void start(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        container.shutdown();
    }

}
