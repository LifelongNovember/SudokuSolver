package sudoku;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.InputStream;

public class Main extends Application {
  
  @Override
  public void start(Stage stage) throws Exception {
    InputStream is = getClass().getResourceAsStream("../SudokuSolver.fxml");
    FXMLLoader fxmll = new FXMLLoader();
    Parent root = fxmll.load(is);
    stage.setTitle("SudokuSolver");
    stage.setScene(new Scene(root));
    stage.show();
  }

  public static void main(String[] args) {
    if(Modele.solve(0,0)) {
      System.out.println("Résolution :");
      Modele.afficherGrille();
    }
    else {
      System.out.println("Grille impossible");
      Modele.afficherGrille();
    }
    launch(args);
  }
}
