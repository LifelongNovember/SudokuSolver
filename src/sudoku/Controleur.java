package sudoku;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.InputStream;
import java.net.URL;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import java.io.InputStream;

public class Controleur implements Initializable { 

  private boolean lightswitch = true;

  @FXML
  private TextArea  ta00, ta01, ta02, ta03, ta04, ta05, ta06, ta07, ta08,
                    ta10, ta11, ta12, ta13, ta14, ta15, ta16, ta17, ta18,
                    ta20, ta21, ta22, ta23, ta24, ta25, ta26, ta27, ta28,
                    ta30, ta31, ta32, ta33, ta34, ta35, ta36, ta37, ta38,
                    ta40, ta41, ta42, ta43, ta44, ta45, ta46, ta47, ta48,
                    ta50, ta51, ta52, ta53, ta54, ta55, ta56, ta57, ta58,
                    ta60, ta61, ta62, ta63, ta64, ta65, ta66, ta67, ta68,
                    ta70, ta71, ta72, ta73, ta74, ta75, ta76, ta77, ta78,
                    ta80, ta81, ta82, ta83, ta84, ta85, ta86, ta87, ta88;

  private TextArea[][] areas;

  @FXML
  private Button btnAction;

  @FXML
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    areas = new TextArea[][]{
      {ta00, ta01, ta02, ta03, ta04, ta05, ta06, ta07, ta08},
      {ta10, ta11, ta12, ta13, ta14, ta15, ta16, ta17, ta18},
      {ta20, ta21, ta22, ta23, ta24, ta25, ta26, ta27, ta28},
      {ta30, ta31, ta32, ta33, ta34, ta35, ta36, ta37, ta38},
      {ta40, ta41, ta42, ta43, ta44, ta45, ta46, ta47, ta48},
      {ta50, ta51, ta52, ta53, ta54, ta55, ta56, ta57, ta58},
      {ta60, ta61, ta62, ta63, ta64, ta65, ta66, ta67, ta68},
      {ta70, ta71, ta72, ta73, ta74, ta75, ta76, ta77, ta78},
      {ta80, ta81, ta82, ta83, ta84, ta85, ta86, ta87, ta88}
    };
    refreshDisplay();
  }
 
  @FXML
  private void onButtonPressed(ActionEvent event) {
    if(lightswitch) {
      for(int i = 0; i < 9; i++)
        for(int j = 0; j < 9; j++) {
          Modele.grille[i][j] = Integer.parseInt(areas[i][j].getText());
        }
      Modele.solve(0,0);
      refreshDisplay();
      btnAction.setText("Modifier");
      lightswitch = !lightswitch;
    } else {
      btnAction.setText("Résoudre");
      lightswitch = !lightswitch;
    }
  }

  public void refreshDisplay() {
    for(int i = 0; i < 9; i++)
      for(int j = 0; j < 9; j++)
        areas[i][j].setText("" + Modele.grille[i][j]);
  }
}


