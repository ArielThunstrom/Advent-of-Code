
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    ArrayList <String> flooring = importFile("ariel.txt");
    String words = flooring.get(0);
    System.out.print(floor(words));
  }
  
  public static int floor (String words) {
    int floor = 0; 
    for (int i = 0; i < words.length(); i++) {
      if(words.substring(i, i+ 1).equals("(")){
        floor++;
      } else if(words.substring(i, i+1).equals(")")){
        floor--;
      }
    
    }
    return floor;
  }
  
  
  
  
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
  
  

}
