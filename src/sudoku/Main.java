package sudoku;

public class Main {
  public static void main(String[] args) {
    if(Sudoku.solve(0,0)) {
      System.out.println("Résolution :");
      Sudoku.afficherGrille();
    }
    else {
      System.out.println("Grille impossible");
      Sudoku.afficherGrille();
    }
  }
}
