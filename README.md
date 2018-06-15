# Create and Test Bipartite Graphs in Java
> - **createGraph.java:** the program will output 10 random bipartite graphs and 10 random non-bipartite graphs in separate txt file. The number of nodes are random within 1000.
> - **testGraph.java:** this program read txt files. If a txt file representing a graph is a bipartite, it will return "true". Otherwise returns "false".
> - **The “Bipartite” folder** contains 10 examples of bipartite graphs.
> - **The “Non-Bipartite” folder** contains 10 examples of non-bipartite graphs.



## Create new Bipartite Graphs:
1. Download **createGraph.java** to your desktop
2. Open terminal and cd to the enclosing folder
3. Type **"javac createGraph.java"** to compile
4. Type **"java testGraph"** to run
5. 10 examples of bipartite graphs will be created in txt files in the folder


## Test whether are Bipartite Graphs:
1. Download **testGraph.java** to your desktop
2. If you are testing with your own graphs in txt files: open **testGraph.java** and go to the main function. Replace the variable fileName with your path to your txt files.<br>
If you are testing one file at a time, comment out the for loop at the beginning. If you wish to test all txt files and there is a pattern in your file name, feel free to use the for loop.
3. Open terminal and cd to the enclosing folder
4. Type **"javac testGraph.java"** to compile
5. Type **"java testGraph"** to run
6. The output will return "true" for bipartite graphs and "false" for non-bipartite graphs.
