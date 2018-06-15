import java.util.*;
import java.lang.*;
import java.io.*;

public class createGraph {

    public static final int n = 10;


    // Generate a uniformly random number between 0 and 1
    public static int genEdge(){
        Random random = new Random();
        double rv = random.nextDouble();
        if (rv < 0.5)
            return 0;
        else
            return 1;
    }

    public static int genNode(int n){
        Random random = new Random();
        int rv = 0;
        while (rv < 2)
            rv = random.nextInt(n);
        return rv;
    }

    public static int genSetA(int n){
        Random random = new Random();
        int rv = 0;
        while (rv == 0 || rv == n)
            rv = random.nextInt(n);
        return rv;
    }


    public static void main(String[] args) {

        // create bipartite graph
        for (int i = 0; i < 10; i++){

            String fileName = "bipartite"+i+".txt";
            File file = new File(fileName);

            try{
            	PrintWriter printWriter = new PrintWriter(file);
                printWriter.println("vi vj e");
                int node = genNode(n);
                int nodeA = genSetA(node);
                // System.out.println("node="+node+" nodeA="+nodeA);

                boolean[] setA = new boolean[nodeA];
                boolean[] setB = new boolean[node-nodeA];

                for (int j = 0; j < nodeA; j++){
                    // if j is the last node of setA
                    if (j == nodeA-1){
                        // make sure that every node in setB is connected
                        for (int z = nodeA; z < node; z++){
                            // if node z in setB has not been connected, connect it with j
                            if (setB[z-nodeA] == false)
                                printWriter.println(j+" "+z+" "+1);
                            // if node j in setA has not been connceted, connect it with the last node in setB
                            else if (z == node-1 && setA[j] == false)
                                printWriter.println(j+" "+z+" "+1);
                            else
                                printWriter.println(j+" "+z+" "+genEdge());
                        }
                    }
                    else{
                        for (int z = nodeA; z < node;z++){
                            //if node j from setA is not matched to any node z from setB, assign an edge jz
                            if ((z == node-1) && (setA[j] == false)){
                                printWriter.println(j+" "+(node-1)+" "+1);
                                setB[z-nodeA] = true;
                            }
                            else{
                                int edge = genEdge();
                                printWriter.println(j+" "+z+" "+edge);
                                if (edge == 1){
                                    setA[j] = true;
                                    setB[z-nodeA] = true;
                                }
                            }
                        }  
                    }
                }

                printWriter.close();
            } catch (FileNotFoundException err) {
                err.printStackTrace();
            }
        }




        // create non-bipartite graph
        for (int i = 0; i < 10; i++){

            String fileName = "non-bipartite"+i+".txt";
            File file = new File(fileName);

            try{
                PrintWriter printWriter = new PrintWriter(file);
                printWriter.println("vi vj e");
                int node = genNode(n);
                int nodeA = genSetA(node);
                // System.out.println("node="+node+" nodeA="+nodeA);

                boolean[] setA = new boolean[nodeA];
                boolean[] setB = new boolean[node-nodeA];

                // first create a bipartite graph
                for (int j = 0; j < nodeA; j++){
                    // if j is the last node of setA
                    if (j == nodeA-1){
                        // make sure that every node in setB is connected
                        for (int z = nodeA; z < node; z++){
                            // if node z in setB has not been connected, connect it with j
                            if (setB[z-nodeA] == false)
                                printWriter.println(j+" "+z+" "+1);
                            // if node j in setA has not been connceted, connect it with the last node in setB
                            else if (z == node-1 && setA[j] == false)
                                printWriter.println(j+" "+z+" "+1);
                            else
                                printWriter.println(j+" "+z+" "+genEdge());
                        }
                    }
                    else{
                        for (int z = nodeA; z < node;z++){
                            //if node j from setA is not matched to any node z from setB, assign an edge jz
                            if ((z == node-1) && (setA[j] == false)){
                                printWriter.println(j+" "+(node-1)+" "+1);
                                setB[z-nodeA] = true;
                            }
                            else{
                                int edge = genEdge();
                                printWriter.println(j+" "+z+" "+edge);
                                if (edge == 1){
                                    setA[j] = true;
                                    setB[z-nodeA] = true;
                                }
                            }
                        }  
                    }
                }
                // add edges to make the bipartite into non-bipartite
                for (int j = 0; j < nodeA; j++){
                    for (int z = j+1; z < nodeA; z++){
                        printWriter.println(j+" "+z+" "+genEdge());
                    }
                }
                for (int j = nodeA; j < node; j++){
                    for (int z = j+1; z < node; z++){
                        printWriter.println(j+" "+z+" "+genEdge());
                    }
                }   

                printWriter.close();
            } catch (FileNotFoundException err) {
                err.printStackTrace();
            }
        }

    }
}







