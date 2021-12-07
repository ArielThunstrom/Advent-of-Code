import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;  
import java.io.FileNotFoundException;  
class Main {
  public static void main(String[] args) {
    ArrayList <Integer> nums = importFile ("nums.txt");
    //System.out.print(increases(nums));
    System.out.print(threeIncreases(nums));
  }

  public static ArrayList<Integer> importFile(String fileName){
    ArrayList<Integer> nums = new ArrayList<>();
    try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        int data = myReader.nextInt();
        nums.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return nums;
  }

//part 1
  public static int increases (ArrayList <Integer> nums) {
    int count = 0;
    for (int i = 1; i < nums.size(); i++) {
      if (nums.get(i -1) < nums.get(i)) {
        count ++;
      }
    }
    return count;
  }
//part 2
  public static int threeIncreases (ArrayList <Integer> nums) {
    int count = 0;
    for (int i = 2; i < nums.size()-1; i ++) {
      int prevSum = nums.get(i-2) + nums.get(i-1) + nums.get(i);
      int nextSum = nums.get(i-1) + nums.get(i) + nums.get(i + 1);
      if (prevSum < nextSum) {
        count ++;
      }
    }
    return count;
  }
}
