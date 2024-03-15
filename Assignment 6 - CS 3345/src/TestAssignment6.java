import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestAssignment6 {
    public static void main(String[] args) {
    	
    	//Number of States
    	int size = 48;
    	
    	//File path to all the edge weights
    	String filePath = "C:\\Users\\saumi\\Desktop\\myFiles\\education\\Programming\\Eclipse WorkSpace\\Assignment 6 - CS 3345\\src\\edgeWeights";
    	
    	//create the 2D matrix with paths and edgeWeights
    	int[][] matrix = createGraphMat(filePath);

    	//initialize the vertex array that will store the shortest distance information
        Vertex[] vertices = new Vertex[size];

        for(int i=0; i<size; i++) {
            vertices[i] = new Vertex(false, Integer.MAX_VALUE, -1);
        }
        vertices[0].distance = 0;
        
        //the dijkstra's algorithm
        findShortestDistances(vertices, matrix);

        //print the results
        for(int i  = 0; i < size; i++){
        	System.out.println("The shortest distance between state capital " + 0 + " and state capital " + i + " is :: "  + vertices[i].distance);
        }
    }

    //method to find the vertex with the minimum edge weight
    public static int findMinVertex(Vertex[] vertices) {
        int minVertex = -1;
        int minDistance = Integer.MAX_VALUE;

        for(int i=0; i<vertices.length; i++) {
            if(!vertices[i].known && vertices[i].distance < minDistance) {
                minVertex = i;
                minDistance = vertices[i].distance;
            }
        }

        return minVertex;
    }
    
    //method to create the graph matrix from a text file
    public static int[][] createGraphMat(String filePath){
    	int[][] graphMat = new int[48][48];
        try {
           File inputFile = new File(filePath);
           Scanner myReader = new Scanner(inputFile);
           while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              String[] edge = data.split(" ");
              graphMat[Integer.parseInt(edge[0])][Integer.parseInt(edge[1])] = Integer.parseInt(edge[2]);
           }
           myReader.close();
        } catch (FileNotFoundException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
        }
        return graphMat;
    }
    
    //implement the dijkstra's algorithm
    public static void findShortestDistances(Vertex[] vertices, int[][] matrix) {
    	int size = vertices.length;
    	for(int i=0; i<size-1; i++) {
            int currentVertex = findMinVertex(vertices);
            vertices[currentVertex].known = true;

            for(int j=0; j<size; j++) {
                if(matrix[currentVertex][j] != 0 && !vertices[j].known) {
                    int newDistance = vertices[currentVertex].distance + matrix[currentVertex][j];
                    if(newDistance < vertices[j].distance) {
                        vertices[j].distance = newDistance;
                        vertices[j].previousVertex = currentVertex;
                    }
                }
            }
        }
    }
}
