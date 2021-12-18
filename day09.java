import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import java.util.ArrayList;
class Main {
  public static void main(String[] args) {
    
   
    colrowlength("testing.txt");
    
  }
  

    public static int findingLow (int [][] nums) {
      int sum = 0;
      ArrayList <Integer> finalNums = new ArrayList <> ();

      for (int row = 0; row < nums.length; row ++) {
        for (int col = 0; col < nums[0].length; col++) {
          //checking the corner values first 
          if ((row == 0 && col == 0)) {
            int min = Math.min(nums[row][col], nums[row +1][col]);
            
            min = Math.min(min, nums[row][col + 1]);
            
            if (min == nums[0][0]) {
              
              finalNums.add(min+1);
              
            }
          }
          
          else if((row == 0 && col == nums[0].length-1) ){
            int min = Math.min(nums[row][col], nums[row+1][col]);
            min = Math.min(min, nums[row][col-1]);
            if (min == nums[row][col]) {
            finalNums.add(min+1);
            }
          }
          
          else if(row == nums.length-1 && col == 0){
            int min = Math.min(nums[row][col], nums[row -1][col]);
            min = Math.min(min, nums[row][col+1]);
            if (min == nums[row][col]){

            finalNums.add(min+1);
            }
          
        } 
        else if(row == nums.length-1 && col == nums[0].length-1){
           int min = Math.min(nums[row][col], nums[row -1][col]);
            min = Math.min(min, nums[row][col-1]);
            if (min == nums[row][col]){

            finalNums.add(min+1);
        }
          
          } 
          
          else if (row == 0){
            int min = Math.min(nums[row][col], nums[row +1][col]);
            min = Math.min(min, nums[row][col-1]);
            min = Math.min(min, nums[row][col+1]);
            if (min == nums[row][col]) {

            finalNums.add(min+1);
            }
          }
          else if (row == nums.length-1) {
            int min = Math.min(nums[row][col], nums[row -1][col]);
            min = Math.min(min, nums[row][col-1]);
            min = Math.min(min, nums[row][col+1]);
            if (min == nums[row][col]) {

            finalNums.add(min+1);
            }
          }
          else if (col == 0) {
            int min = Math.min(nums[row][col], nums[row][col+1]);
            min = Math.min(min, nums[row-1][col]);
            min = Math.min(min, nums[row+1][col]);
            if (min == nums[row][col]) {

            finalNums.add(min+1);
            }
          }

          else if (col == nums[0].length-1) {
            int min = Math.min(nums[row][col], nums[row][col-1]);
            min = Math.min(min, nums[row-1][col]);
            min = Math.min(min, nums[row+1][col]);
            if (min == nums[row][col]) {

            finalNums.add(min+1);
            }
          }
          else {
            int min = Math.min(nums[row][col], nums[row][col-1]);
            min = Math.min(min, nums[row][col+1]);
            min = Math.min(min, nums[row+1][col]);
            min = Math.min(min, nums[row-1][col]);
            if (min == nums[row][col]) {

            finalNums.add(min+1);
            }
          }
          
          
        
         
        
      }
      }
      
      for (int i = 0; i < finalNums.size(); i++) {
        if (finalNums.get(i) != 10)
          sum += finalNums.get(i);
      }
      
     System.out.print(sum);
     
      return sum;
    }




  public static void print (int[][] nums) {
		for (int row = 0; row < nums.length; row++) {
			for (int col = 0; col < nums[0].length; col ++) {
			System.out.print(nums[row][col] + "\t" );
			}
			System.out.println();
		}
	}

  public static int [][] making2Array (int row, int col, ArrayList <Integer> nums) {
    int [][] data = new int [row][col];
    int count = 0;
    while (count < nums.size()) {
    for (int rows = 0; rows < data.length; rows++) {
      for (int cols = 0; cols < data[0].length; cols ++) {
        int n = nums.get(count);
        data[rows][cols] = n;
        count ++;
      }
    }
    }
    //print(data);
    return data;
    
  }

public static ArrayList <Integer> importFile(String fileName){
    ArrayList<String> words = new ArrayList<>();
    int count = 0;
    try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        count ++;
        words.add(data);
      }
      
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
    ArrayList <Integer> nums = new ArrayList <> ();
    int length = words.get(0).length()-1;
    for (int i = 0; i < count; i++ ) {
      for (int x = 0; x < length; x++) {
        int number = Integer.parseInt(words.get(i).substring(x, x+1));
        nums.add(number);
      }
      int lastNum = Integer.parseInt(words.get(i).substring(length));
      nums.add(lastNum);
      
    }

    
    
    return nums;
  }


public static void colrowlength(String fileName) {
		int total = 0;
		int row = 0;
		int col = 0;
		String all = "";
		
		try {
			File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj);

			while (myReader.hasNextLine()) {
				row++;
				String data = myReader.nextLine();
				all+= data;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		col = all.length()/row;
    //making2Array(row, col, "testing.txt");
	   //now you have col and row amount
    findingLow(making2Array(row, col, importFile(fileName)));
    
	}

}
