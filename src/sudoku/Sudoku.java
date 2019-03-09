package sudoku;

public class Sudoku {

  public static int[][] grille =
  {
    {0,0,0,0,0,4,0,9,0},
    {8,0,2,9,7,0,0,0,0},
    {9,0,1,2,0,0,3,0,0},
    {0,0,0,0,4,9,1,5,7},
    {0,1,3,0,5,0,9,2,0},
    {5,7,9,1,2,0,0,0,0},
    {0,0,7,0,0,2,6,0,3},
    {0,0,0,0,3,8,2,0,5},
    {0,2,0,5,0,0,0,0,0}
  };

  public static boolean estPossible(int v, int i, int j) {

    for(int c = 0; c < 9; c++)
      if(grille[i][c] == v)
        return false;

    for(int l = 0; l < 9; l++)
      if(grille[l][j] == v)
        return false;

    int x1 = 3 * (i/3);
    int y1 = 3 * (j/3);
    int x2 = x1 + 2;
    int y2 = y1 + 2;

    for(int x = x1; x <= x2; x++)
      for(int y = y1; y <= y2; y++)
        if(grille[x][y] == v)
          return false;

    return true;
  }

  public static int[] caseSuivante(int i, int j) {

    if(j < 8) {
      j++;
    }
    else { 
      if(i < 8) {
        i++;
        j = 0;
      }
    }

  int[] res = {i, j};
  return res;
}

public static boolean solve(int i, int j) {
  if(i != 8 || j != 8) {
    int[] prochaineCase = caseSuivante(i,j);
    if(grille[i][j] != 0) {
      return solve(prochaineCase[0], prochaineCase[1]);
    }
    else {
      for(int v = 1; v <= 9; v++) {
        if(estPossible(v, i, j)) {
          grille[i][j] = v;
          if(solve(prochaineCase[0], prochaineCase[1])) return true;
        }
        else {
          grille[i][j] = 0;
        }
      }
    }
  }

  else {
    for(int v = 1; v <= 9; v++) {
      if(estPossible(v, i, j)) {
        grille[i][j] = v;
        return true;
      }
      else {
        grille[i][j] = 0;
      }
    }
  }
  return false;
}

public static void afficherGrille() {
  System.out.println("###########"); 
  for(int i = 0; i < 9; i++) {
    System.out.print("#");
    for(int j = 0; j < 9; j++) {
      System.out.print(grille[i][j]);
    }
    System.out.println("#");
  }
  System.out.println("###########");
}
}
