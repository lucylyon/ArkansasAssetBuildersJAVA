package com.aab.arkansasassetbuilders;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;

// what i have done: added maven dependencies
//

import java.io.IOException;

public class searchAndFilterControler extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(searchAndFilterControler.class.getResource("Search-and-filter-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        //stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}