import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    ArrayList<Integer> nums = new ArrayList<>();
    nums = importFile("ariel.txt");
    int row = row("ariel.txt");
    int column = col(nums);
   gamma(making2d(nums, 1000, 12));
   //gamma(making2d(nums, row, column));
    
  }




  
 //returning the number of rows needed. 
 public static int row (String fileName){
    ArrayList<String> words = new ArrayList<>();
    int count = 0;
    //count is the number of rows
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

    
    
    return count;
  }



  
  //importing the text file into a integer array
  //returns that integer array
public static ArrayList <Integer> importFile(String fileName){
    ArrayList<String> words = new ArrayList<>();
    int count = 0;
    //count is the number of cols
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

//returns the number of columns
  public static int col(ArrayList<Integer>nums){
    int col = nums.size() / row("testing.txt");
    System.out.println(col);
    return col;

  }


  public static int [][] making2d (ArrayList<Integer>nums1, int rows, int cols){
    int [][] binary = new int [rows][cols];
    int index = 0;
    System.out.println(rows);
    System.out.println("cols = " + cols);
    for(int row = 0; row<binary.length; row++ ){
      for(int col = 0; col<binary[0].length;col++){
        binary[row][col] = nums1.get(index);
         index++; 
      }
    }
      return binary;
  }

 


public static void print(int [][] nums){
    for(int row = 0;row<nums.length;row++){
      for(int col = 0; col<nums[0].length; col++){
        System.out.print(nums[row][col] + " ");
      }
      System.out.println();
    }
  }




  //create a string to hold the bits
public static void gamma (int [][] nums ){
   String gamma = "";
   
   String epsilon = "";
   for (int col = 0; col < nums[0].length; col++) {
     int count0 = 0;
     int count1 = 0;
     for (int row = 0; row < nums.length; row++) {
       if (nums[row][col] == 1) {
         count1 ++;
       } else {
         count0 ++;
       }
     }
     if (count1 > count0) {
       gamma += 1;
       epsilon += 0;
     }
     else {
       gamma += 0;
       epsilon += 1;
     }
   }
   System.out.print("gamma binary: " + gamma);
   binary(gamma, epsilon);
   
   
  }
  //this method def works
  public static void binary (String gamma, String epsilon) {
    int gammaBinary = 0;
    int epsilonBinary = 0;
    for (int i = 0; i < gamma.length(); i++) {
      int num = Integer.parseInt(gamma.substring(i, i + 1));
      if (num == 1) {
        gammaBinary += Math.pow(2, gamma.length()- 1 - i);
      }
    }
      if (gamma.substring(gamma.length()-1).equals(1)) {
        gammaBinary+= Math.pow(2, 0);
      }

  for (int i = 0; i < epsilon.length(); i++) {
      int num = Integer.parseInt(epsilon.substring(i, i + 1));
      if (num == 1) {
        epsilonBinary += Math.pow(2, epsilon.length()- 1 - i);
      }
    }
      if (epsilon.substring(epsilon.length()-1).equals(1)) {
        epsilonBinary+= Math.pow(2, 0);
      }




    System.out.println("gamma: " + gammaBinary);
    System.out.println("epsilon: " + epsilonBinary);
    System.out.println(gammaBinary * epsilonBinary);
    
  }



}
