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

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Kurt Sparber
 */
@Singleton
public class StageInitService {

    @Inject
    private HelloWorldService helloWorldService;


    public void init(Stage stage) {

        String hello = helloWorldService.say();

        stage.setTitle(hello);
        Button btn = new Button();
        btn.setText("Say " + hello);
        btn.setOnAction(event -> System.out.println(hello));

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        stage.setScene(new Scene(root, 300, 250));
        stage.show();
    }

}
