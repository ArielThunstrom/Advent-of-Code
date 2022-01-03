import java.util.*;

class Main {

  
  public static void main(String[] args) {
   ArrayList <String> words = DataImporting.importFile("testData.txt");
   // System.out.println(convert(words));
    //System.out.println(convert(DataImporting.importFile("testData.txt")));
    ArrayList <HydroPoints> hydro = convert(words);
    
    int [][] nums = creating2D(findingRow(hydro), findingCol(hydro));
    //increasingX(nums, hydro);
    //increasingY(nums, hydro);
    for (HydroPoints poo : hydro){
      nums = Diagonal2(nums, poo);
    }
    print(nums);
    //System.out.print(danger(nums));
  }
  
  
  
  public static ArrayList<HydroPoints> convert(ArrayList<String> points){
    ArrayList<HydroPoints> fin = new ArrayList<>();
    for (String point : points){
      int firstSpaceInd = point.indexOf(" ");
      int firstCommaInd = point.indexOf(",");
      int x1 = Integer.parseInt(point.substring(0, firstCommaInd));
      int y1 = Integer.parseInt(point.substring(firstCommaInd + 1, firstSpaceInd));
      String newS = point.substring(point.indexOf(">") + 2);
      int nextCommaInd = newS.indexOf(",");
      int x2 = Integer.parseInt(newS.substring(0, nextCommaInd));
      int y2 = Integer.parseInt(newS.substring(nextCommaInd + 1));

      fin.add(new HydroPoints(x1, y1, x2, y2));

    }
    return fin;
  }

  public static int findingRow (ArrayList <HydroPoints> points) {
    int max = points.get(0).getX1();
    for (int i = 0; i < points.size(); i++) {
      int tempMax = Math.max(points.get(i).getX1(), points.get(i).getX2());
      max = Math.max(tempMax, max);
    }
    return max + 1;
  }



  public static int findingCol(ArrayList<HydroPoints> points){
    int max = points.get(0).getY1();
    for(int i = 0; i<points.size(); i++){
     int temp = Math.max(points.get(i).getY1(), points.get(i).getY2());
      max = Math.max(temp, max);
    }
    return max+1;
  }

  public static int [][] creating2D (int row, int col) {
    int [][] diagram = new int [row][col];
    //print(diagram);
    //initialized to 0
    return diagram;
  } 
  public static void print(int[][]nums) {
		for(int row = 0; row<nums.length;row++) {
			for(int col = 0; col<nums[0].length;col++) {
			System.out.print(nums[row][col] +"\t");
			}
			System.out.println();
		}
    
	}



  public static void increasingX (int [][]nums, ArrayList <HydroPoints> hydro) {
    for (int i = 0; i < hydro.size(); i++) {
      
      if (hydro.get(i).getX1() == hydro.get(i).getX2()) {
        //System.out.print(hydro.get(i).getX1());
        if (hydro.get(i).getY1() < hydro.get(i).getY2()) {
        for (int x = hydro.get(i).getY1(); x <= hydro.get(i).getY2(); x++)
          nums[x][hydro.get(i).getX1()] ++;
      }
       else {
        for (int x = hydro.get(i).getY2(); x <= hydro.get(i).getY1(); x++)
          nums[x][hydro.get(i).getX1()] ++;
      }
    }
      }
      
    
    }
    


  public static void increasingY(int [][]nums, ArrayList<HydroPoints> points){
    for(int i = 0; i<points.size(); i++){
      if(points.get(i).getY1() == points.get(i).getY2()){
      if(points.get(i).getX1()<points.get(i).getX2()){
      
        
        for(int j = points.get(i).getX1(); j<=points.get(i).getX2(); j++)
          nums[points.get(i).getY1()][j] ++;
          
      
      
        
       
      } else{
        for(int j = points.get(i).getX2(); j<= points.get(i).getX1(); j++){
          nums[points.get(i).getY1()][j]++;
        }
      }
      
    } 
    
    
  } 
  }
 
public static void Diagonal (int [][] nums, ArrayList <HydroPoints> hydro) {
  for (int i = 0; i < hydro.size(); i++) {
    if (hydro.get(i).getX1() != hydro.get(i).getX2() && hydro.get(i).getY1() != hydro.get(i).getY2()) {

      if (hydro.get(i).getY1() < hydro.get(i).getY2() ) {
        //second point is higher, line is like /
        //increasing col, decreasing row 
        for (int row = hydro.get(i).getY2(); row <= hydro.get(i).getY1(); row --) {
          for (int col = hydro.get(i).getX1(); col <= hydro.get(i).getX2(); col ++) {
              nums[row][col] ++;
          }
        }
      }
      else if (hydro.get(i).getY1() > hydro.get(i).getY2() ) {
        //first point is higher, line is like \
        //decreasing col, increasing row 
        for (int row = hydro.get(i).getY1(); row >= hydro.get(i).getY2(); row ++) {
          for (int col = hydro.get(i).getX2(); col >= hydro.get(i).getX1(); col --) {
              nums[row][col] ++;
          }
        }
      }
    }
  }
}


/*
public static void Diagonal(int [][]nums, ArrayList<HydroPoints>hydro){
  for(int i = 0; i< hydro.size(); i++){
    if(hydro.get(i).getX1() != hydro.get(i).getX2() && hydro.get(i).getY1() != hydro.get(i).getY2()){
      if(hydro.)
      for(int row = hydro.get(i).getX1(); row<=hydro.get(i).getX2(); row++){

      }
    }
  }
}
  */
  
  
  
  public static int danger (int [][] nums) {
    int count = 0;
    for (int row = 0; row < nums.length; row++) {
      for (int col = 0; col < nums[0].length; col++) {
        if (nums[row][col] >= 2) {
          count ++;
        }
      }
    }
    return count; 
  }
  public static int[][] Diagonal2 (int[][] nums, HydroPoints x){
    
    int smallX = 0;
    int largeX = 0;
    int smallY = 0;
    int largeY = 0;

    if (x.getX1() < x.getX2()){
      smallX = x.getX1();
      largeX = x.getX2();
      smallY = x.getY1();
      largeY = x.getY2();
    }else{
      smallX = x.getX2();
      largeX = x.getX1();
      smallY = x.getY2();
      largeY = x.getY1();
    }

    if (smallY < largeY){
      for (int i = 0; i <= largeX - smallX; i ++){
        nums[smallX + i][] ++;
      }
    }
    if (smallY > largeY){
      for (int i = 0; i <= largeX - smallX; i ++){
        nums[smallX + i][] ++;
      }
    }
    return nums;
  }
  

}
