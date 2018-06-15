import java.util.*;
import java.lang.*;
import java.io.*;

public class testGraph {

	public static final int node = 1000;

	public static boolean testBipartite(int[][] m){
		// set up an array to record which subset a node is in
		int[] set = new int[node];
		set[0] = 1;

		// to record the next node we need to check
		Queue<Integer> next = new LinkedList<Integer>();
		next.add(0);

		while(!next.isEmpty()){
			int i = next.remove();
			for (int j = 0; j < node; j++){
				if (m[i][j] == 1){
					// i and j are connected but they are on the same side
					if (set[i] == set[j])
						return false;
					// i and j are connected and they are on different sides
					else if (set[i] == 0 && set[j] != 0){
						set[i] = -1*set[j];
						next.add(j);
					}
					else if (set[i] !=0 && set[j] == 0){
						set[j] = -1*set[i];
						next.add(j);
					}
				}
			}
		}
		return true;
	}


	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10; i++){
			String fileName = "/Users/xinyuezhang/Google Drive/CS591/HW1/non-bipartite/non-bipartite"+i+".txt";
			File file = new File(fileName);
			BufferedReader br = new BufferedReader(new FileReader(file));
		  	String str= br.readLine();

		  	System.out.print("Graph "+i+": ");
		  	int[][] matrix = new int[node][node];
		  	while ((str = br.readLine()) != null){
		    	String[] splited = str.split(" ");
		    	int node1 = Integer.parseInt(splited[0]);
		    	int node2 = Integer.parseInt(splited[1]);
		    	int edge = Integer.parseInt(splited[2]);
		  		matrix[node1][node2] = edge;
		  		matrix[node2][node1] = edge;
		  	}

		  	// print matrix
		 //  	System.out.println("\n   0 1 2 3 4 5 6 7 8 9\n");
		 //  	for (int z = 0; z < 10 ; z++){
			// 	System.out.print(z+"  ");
			// 	for (int j = 0; j < 10 ; j++){
			// 		System.out.print(matrix[z][j]+" ");
			// 	}
			// 	System.out.println();
			// }

			boolean result = testBipartite(matrix);
		  	System.out.println(result);
		}
	}
}








