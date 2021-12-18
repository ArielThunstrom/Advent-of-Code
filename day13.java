import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    ArrayList <point> points = convert(importFile("data.txt"));
    String [][] hashtag = hashtag(creating2D(points), points);
    ArrayList <folding> folds = importFolding("fold.txt");
    for (int i = 0; i < folds.size(); i++) {
      if (folds.get(i).getWay().equals("y")) {
        hashtag = foldY(hashtag, folds.get(i).getNum(), hashtag);
      }
      else if (folds.get(i).getWay().equals("x")) {
        hashtag = foldX(hashtag, folds.get(i).getNum(), hashtag);
      }
    }

    print(hashtag);
    //count method was used to get output for part 1
  }


    
  }

public static int count (String [][] hashtag) {
  int count = 0;
  for (int row = 0; row < hashtag.length; row ++) {
    for (int col = 0; col < hashtag[0].length; col ++) {
      if (hashtag[row][col].equals("#")) {
        count ++;
      }
    }
  }
  return count;
}

public static ArrayList<folding> importFolding(String fileName){
    ArrayList<String> words = new ArrayList<>();
    try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        words.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    ArrayList <folding> folds = new ArrayList <> ();
    for (String fold : words) {
      String way = fold.substring(11, 12);
      int num = Integer.parseInt(fold.substring(13));
      folds.add(new folding(way, num));
    }
    return folds;
  }


public static String[][] foldX (String [][] grid, int fold, String [][] hashtag) {
  String [][] rightGrid = new String [grid.length][fold];
  String [][] leftGrid = new String [grid.length][fold];


  //left grid 
  for(int row = 0; row< leftGrid.length ; row++){
    for(int col = 0; col< leftGrid[0].length;col++){
      leftGrid[row][col] = grid[row][col];

    }

  }


//right grid
  int newFold = fold + 1;
  for(int row = 0; row < rightGrid.length; row++){
    newFold = fold +1;
    for(int col = 0; col < rightGrid[0].length; col++){
      if (newFold < grid[0].length) {
      rightGrid[row][col] = grid[row][newFold];
      
      newFold ++;
      }
    }
   
  }
  hashtag = combiningX(rightGrid, leftGrid, fold, hashtag);
  return hashtag;
}

public static String [][] combiningX (String [][] rightGrid, String [][] leftGrid, int fold, String [][] hashtag) {
  String[][] finalGrid = new String[rightGrid.length][rightGrid[0].length];
  for(int row = 0; row<finalGrid.length; row++){
    for(int col = 0; col<finalGrid[0].length; col++){
      finalGrid[row][col] = rightGrid[row][col];
    }
  } int count = 0;
  for (int row = 0; row < leftGrid.length; row++) {
    count = 0;
    for (int col = leftGrid[0].length-1; col >= 0; col--) {
      
      if (leftGrid[row][col].equals("#")) {
        finalGrid[row][count] = "#";
      }
      count ++;
    }
    
  }
  hashtag = finalGrid;
  return hashtag;
}


//horizontal 
public static String [][] foldY (String[][] grid, int fold, String [][] hashtag){
  String[][] topgrid = new String [fold][grid[0].length];
  String [][] bottomgrid = new String[grid.length-fold-1][grid[0].length];
  //this for loop creates topGrid
  for(int row = 0; row<topgrid.length ; row++){
    for(int col = 0; col<topgrid[0].length;col++){
      topgrid[row][col] = grid[row][col];

    }

    
  }
  for(int row = 0; row<bottomgrid.length; row++){
    for(int col = 0; col<bottomgrid[0].length; col++){
      bottomgrid[row][col] = grid[fold+1][col];
    }
    fold++;
  }
   hashtag = combineY(topgrid, bottomgrid, hashtag);
    return hashtag;
}

//combining top and bottom grids
public static String [][] combineY(String[][] topGrid, String[][]bottomgrid, String [][] hashtag){
  String[][] finalGrid = new String[topGrid.length][topGrid[0].length];
  for(int row = 0; row<finalGrid.length; row++){
    for(int col = 0; col<finalGrid[0].length; col++){
      finalGrid[row][col] = topGrid[row][col];
    }
  } int count = 0;
  for (int row = bottomgrid.length-1; row >= 0; row--) {
    for (int col = 0; col < bottomgrid[0].length; col++) {
      if (bottomgrid[row][col].equals("#")) {
        finalGrid[count][col] = "#";
      }
    }
    count++;
  }
  hashtag = finalGrid;
  return hashtag;
}

//adds the hashtags to 2D array (initializing)
public static String[][] hashtag (String [][] grid, ArrayList <point> points) {
  for (int i = 0; i < points.size(); i++) {
  grid[points.get(i).getY()][points.get(i).getX()] = "#";
  
}
return grid;

}
//created 2D array initialized to .
  public static String [][] creating2D (ArrayList <point> points) {
    int maxX = points.get(0).getX();
    int maxY = points.get(0).getY();
    for (int i = 0; i < points.size(); i++) {
      maxX = Math.max(maxX, points.get(i).getX());
      maxY =  Math.max(maxY, points.get(i).getY());
    }
    String [][] grid = new String [maxY + 1][maxX + 1];

    for (int row = 0; row < grid.length; row ++) {
      for (int col = 0; col < grid[0].length; col++) {
        grid[row][col] = ".";
      }
    }

    return grid;
  }
//printing 
    public static void print(String[][] nums) {
		for(int row = 0; row<nums.length;row++) {
			for(int col = 0; col<nums[0].length;col++) {
			System.out.print(nums[row][col] +"\t");
			}
			System.out.println();
		}
    
	}
//arraylist of the testData
public static ArrayList<String> importFile(String fileName){
    ArrayList<String> words = new ArrayList<>();
    try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        words.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return words;
  }
//arrayList of points from testData
  public static ArrayList<point> convert(ArrayList<String> points){
    ArrayList<point> fin = new ArrayList<>();
    for (String point : points){
      int firstCommaInd = point.indexOf(",");
      int x = Integer.parseInt(point.substring(0, firstCommaInd));
      int y = Integer.parseInt(point.substring(firstCommaInd + 1));
      
      fin.add(new point (x, y));

    }
    return fin;
  }

}
