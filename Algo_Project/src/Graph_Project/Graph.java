package Graph_Project;
import java.util.*;

public class Graph {
	
	
	static int vertices;
	static long edges;
	static int maxWeight;
	static int degree;
	static int prob;
	
	LinkedList<Node> [] adjacencyList;
	

	public Graph(int vertices) {
		super();
		this.vertices = vertices;
		adjacencyList = new LinkedList[vertices];
        for (int i = 0; i <vertices ; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
        edges=0;
        
	}
	
	public void addEdge(int src, int dest, int weight) {
		
        Node snode = new Node(src, weight);
        Node dnode = new Node(dest,weight);
        if (!edgeExists(snode,dnode))
        {
        	 adjacencyList[src].add(dnode); 
             adjacencyList[dest].add(snode);
             edges++;
        }

       
    }
	
	public int init_random(int max,int min) {
		int random_number= (int)((Math.random() * ((max - min) + 1)) + min);
		return random_number;
	}
	
	public void createCycle() {
		for(int i=0;i<vertices-1;i++) {
			int randomWeight= init_random(100,1);
			addEdge(i,i+1,randomWeight);
		}
		
	}
	
	public boolean edgeExists(Node u,Node v) {
		for(Node ed: adjacencyList[u.dest]){ 
            if (ed.dest==v.dest)
            	return true;
            
        } 	
		return false;
	}
	
	
	
	public void generateSparseGraph(int degree1) {
		createCycle();
		int addCounter=0;
		while(addCounter<((vertices*degree1)/2)-vertices) {
			int random_v1= init_random(vertices-1,0);
			int random_v2= init_random(vertices-1,0);
			
			if(random_v1!=random_v2) {
				int random_weight=init_random(100,1);
				addEdge(random_v1,random_v2,random_weight);
			}
			addCounter++;
		}
		
	}
	
	public void generateDenseGraph1() {
		for(int  i=0;i<vertices;i++) {
			for(int j=1;j<vertices;j++) {
				if(i!=j) {
					double random_number=Math.random();
					if(random_number < 0.2) {
						int randomWeight=init_random(100,1);
						addEdge(i,j,randomWeight);
					}
				}
			}
		}
	}
	 

	public void generateDenseGraph22(int degree2) {
		createCycle();
		int addCounter2=0;
		while(addCounter2<((vertices*degree2)/2)-vertices) {
			int random_v1= init_random(vertices-1,0);
			int random_v2= init_random(vertices-1,0);
			
			if(random_v1!=random_v2) {
				int random_weight=init_random(100,1);
				addEdge(random_v1,random_v2,random_weight);
			}
			addCounter2++;
		}
		
	}
	 
	 
	public void printGraph(){
		System.out.println("Total nodes:"+ vertices);
		
	
		
		 for(int i = 0; i < vertices; i++) 
	        { 
	            System.out.println("Adjacency list of vertex "+ i+"size->"+adjacencyList[i].size());
	            edges=edges+adjacencyList[i].size()-1;
	            
	            System.out.println("\n"); 
	        } 
		 System.out.println("Total edges:"+ edges);
		 System.out.println("Average degree:"+ (edges/vertices));
		 System.out.println("-----------------------------------------------------------------------------------------");
     }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int vertices = 5000;
//         Graph graphSparse = new Graph(vertices);
//         graphSparse.generateSparseGraph(6);
//         graphSparse.printGraph();
//         
//         Graph graphDense1 = new Graph(vertices);
//         graphDense1.generateDenseGraph1();
//         graphDense1.printGraph();
//         
         Graph graphDense2 = new Graph(vertices);
         graphDense2.generateDenseGraph22(1000);
         graphDense2.printGraph();
         

        

	}

}

