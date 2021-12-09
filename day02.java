import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import java.util.ArrayList;
class Main {
  public static void main(String[] args) {
    ArrayList <String> words = importFile("day02.txt");
    int horizontal = Horizontal(words);
    int depth = depth(words);
    int total = horizontal * depth;
    System.out.println(total);
    System.out.println(aiming(words));
    
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


  public static int Horizontal (ArrayList <String> words) {
    int starting = 0;
    for (int i = 0; i < words.size(); i++) {
      if (words.get(i).length() > 7) {
      if (words.get(i).substring(0, 7).equals("forward")) {
        starting += Integer.parseInt(words.get(i).substring(8));
      }

    }
    }
    return starting;
  }


 public static int depth (ArrayList <String> words) {
    int starting = 0;
    for (int i = 0; i < words.size(); i++) {
      
      if (words.get(i).substring(0, 2).equals("up")) {
        starting -= Integer.parseInt(words.get(i).substring(3));
      }
     

    }
    for (int i = 0; i < words.size(); i++) {
      if (words.get(i).length() > 4) {
      if (words.get(i).substring(0, 4).equals("down")) {
        starting += Integer.parseInt(words.get(i).substring(5));
      }
      }
    }

    
    return starting;
  }


 






 public static int aiming (ArrayList <String> words) {
    int horizontal = 0;
    int depth = 0;
    int aim = 0;

    for (int i = 0; i < words.size(); i++) {
      if (words.get(i).length() > 4) {
      if (words.get(i).substring(0, 4).equals("down")) {
        aim += Integer.parseInt(words.get(i).substring(5));
      }
      }
      if (words.get(i).substring(0, 2).equals("up")) {
        aim -= Integer.parseInt(words.get(i).substring(3));
      }
      if (words.get(i).length() > 7) {
      if (words.get(i).substring(0, 7).equals("forward")) {
        int x = Integer.parseInt(words.get(i).substring(8));
        
        horizontal += x;
        
        depth += aim * x;
      }

    }

    }
  
    
    int total = depth * horizontal;
    return total;
  }




  
}
