package Graph_Project;
import java.util.*;

public class Graph {
	
	
	 int vertices;
	 int edges;
	 int maxWeight;
     int degree;
	 int prob;
	
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
	
	public int addEdge(int src, int dest, int weight) {
		
        Node snode = new Node(src, weight);
        Node dnode = new Node(dest,weight);
        if (!edgeExists(snode,dnode))
        {
        	 adjacencyList[src].add(dnode); 
             adjacencyList[dest].add(snode);
             edges++;
             return 1;
        }
        return 0;

       
    }
	
	public int init_random(int max,int min) {
		int random_number= (int)((Math.random() * ((max - min) + 1)) + min);
		return random_number;
	}
	
	public void createCycle() {
		for(int i=0;i<vertices-1;i++) {
			int randomWeight= init_random(1000,1);
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
		int iloop= ((vertices*degree1)/2)-vertices+1;
		
		while(iloop!=0) {
			int added = 0;
			int random_v1= init_random(vertices-1,0);
			int random_v2= init_random(vertices-1,0);
			
			if(random_v1!=random_v2) {
				int random_weight=init_random(10000,1);
			    added=addEdge(random_v1,random_v2,random_weight);
			    if(added==1)
			    	iloop--;
			}
			
		}
		
	}
	
	public void generateDenseGraph1() {
		for(int  i=0;i<vertices;i++) {
			for(int j=0;j<vertices;j++) {
				if(i!=j) {
					double random_number=Math.random();
					if(random_number < 0.2) {
						int randomWeight=init_random(10000,1);
						int added= addEdge(i,j,randomWeight);
					}
				}
			}
		}
	}
	 

	public void generateDenseGraph22(int degree2) {
		createCycle();
		int addCounter2=0;
		while(addCounter2<((vertices*degree2)/2)) {
			int random_v1= init_random(vertices-1,0);
			int random_v2= init_random(vertices-1,0);
			
			if(random_v1!=random_v2) {
				int random_weight=init_random(10000,1);
				int added=addEdge(random_v1,random_v2,random_weight);
			}
			addCounter2++;
		}
		
	}
	 
	 
	public void printGraph(){
		System.out.println("Total nodes:"+ vertices);
		
	    int no_edges=0;
		
		 for(int i = 0; i < vertices; i++) 
	        { 
	            System.out.println("Adjacency list of vertex "+ i+"size->"+adjacencyList[i].size());
	            no_edges=no_edges+adjacencyList[i].size();
	            
	            System.out.println("\n"); 
	        } 
		 System.out.println("Total edges by vertices:"+ vertices);
		 System.out.println("Total edges by static:"+ edges);
		 System.out.println("Total edges by printfunction:"+ no_edges);

		 System.out.println("Average degree by print function:"+ ((no_edges/vertices)));
		 System.out.println("-----------------------------------------------------------------------------------------");
     }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int vertices = 100;
         Graph graphSparse = new Graph(vertices);
         graphSparse.generateSparseGraph(6);
         graphSparse.printGraph();
         
         Graph graphSparse2 = new Graph(vertices);
         graphSparse2.generateSparseGraph(5);
         graphSparse2.printGraph();
         
         
//         Graph graphDense1 = new Graph(vertices);
//         graphDense1.generateDenseGraph1();
//         graphDense1.printGraph();
////         
//         Graph graphDense2 = new Graph(vertices);
//         graphDense2.generateDenseGraph22(1000);
//         graphDense2.printGraph();
//         

        

	}

}

