package AdventOfCode;
import java.util.ArrayList;
import java.math.BigInteger;

public class day7 {

	public static void main(String[] args) {
		//ArrayList <Integer> lanternfishy = new ArrayList <> ();
		ArrayList <BigInteger> bigFish = new ArrayList <> ();
		int [] lanternFish = {5,1,1,4,1,1,4,1,1,1,1,1,1,1,1,1,1,1,4,2,1,1,1,3,5,1,1,1,5,4,1,1,1,2,2,1,1,1,2,1,1,1,2,5,2,1,2,2,3,1,1,1,1,1,1,1,1,5,1,1,4,1,1,1,5,4,1,1,3,3,2,1,1,1,5,1,1,4,1,1,5,1,1,5,1,2,3,1,5,1,3,2,1,3,1,1,4,1,1,1,1,2,1,2,1,1,2,1,1,1,4,4,1,5,1,1,3,5,1,1,5,1,4,1,1,1,1,1,1,1,1,1,2,2,3,1,1,1,1,1,2,1,1,1,1,1,1,2,1,1,1,5,1,1,1,1,4,1,1,1,1,4,1,1,1,1,3,1,2,1,2,1,3,1,3,4,1,1,1,1,1,1,1,5,1,1,1,1,1,1,1,1,4,1,1,2,2,1,2,4,1,1,3,1,1,1,5,1,3,1,1,1,5,5,1,1,1,1,2,3,4,1,1,1,1,1,1,1,1,1,1,1,1,5,1,4,3,1,1,1,2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,3,3,1,2,2,1,4,1,5,1,5,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,5,1,1,1,4,3,1,1,4};
		BigInteger [] lanternFishyy = {"1" 2, 3,};
		//lanternfishy = arrayToList (lanternFish, lanternfishy);
		//System.out.print(spawn(lanternfishy, 80));
		bigFish = arrayToListt (lanternFish, bigFish);
		System.out.print(spawning(bigFish, 256));
		
		
	}
	
	public static int spawn (ArrayList <Integer> lanternfishy, int days) {
	for (int i = 0; i < days; i++) {
		for (int fish = 0; fish < lanternfishy.size(); fish++) {
			if (lanternfishy.get(fish) != 0) {
				lanternfishy.set(fish, lanternfishy.get(fish) -1 ) ;
			} else {
				lanternfishy.set(fish, 6);
				lanternfishy.add(9);
				
			}
		}
	}
	
	return lanternfishy.size();
	}
		
		
		public static ArrayList <Integer> arrayToList (int [] lanternFish, ArrayList <Integer> lanternfishy) {
			for (int i : lanternFish) {
				lanternfishy.add(i);
			}
			return lanternfishy;
		}
		
		public static ArrayList <BigInteger> arrayToListt (int [] lanternFish, ArrayList <BigInteger> lanternfishy) {
			for (BigInteger i : lanternFish) {
				lanternfishy.add(i);
			}
			return lanternfishy;
		}
		
		
		public static BigInteger spawning (ArrayList <Integer> lanternfishy, int days) {
			//ArrayList <BigInteger> bigFish = new ArrayList <> ();
			for (int i = 0; i < days; i++) {
				for (int fish = 0; fish < lanternfishy.size(); fish++) {
					if (lanternfishy.get(fish) != 0) {
						lanternfishy.set(fish, lanternfishy.get(fish) -1 ) ;
					} else {
						lanternfishy.set(fish, 6);
						lanternfishy.add(9);
						
					}
				}
			}
			
			BigInteger  fishhh = new BigInteger ("lanternfishy.size()");
			return fishhh;
		}
		
	}


