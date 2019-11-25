package Graph_Project;

import java.util.*;



public class Dijkstra {

	Integer inf = Integer.MAX_VALUE;
	static int V;
	int s;
	int t;
	Graph G ;
    int[]  dad;
	String[] status;
	int [] bandwidth;
	
	
	public Dijkstra(Graph G,int s, int t) {
		super();
	
		this.s = s;
		this.t = t;
		this.G = G;
		
		dad = new int[G.vertices];
		bandwidth= new int[G.vertices];
		status = new String[G.vertices];
		
		Arrays.fill(dad,-999);	
		Arrays.fill(bandwidth,0);
		Arrays.fill(status, "unseen");
		
		status[s]="in_tree";
		bandwidth[s]=inf;
		//System.out.println("in constructr");
		
	}
	
	public void calculate_dijkstra() {
		//System.out.println("inside calc dijks func");
		
		for(Node nod:G.adjacencyList[s]) {
			bandwidth[nod.dest]=nod.weight;
			dad[nod.dest]=s;
			status[nod.dest]="fringe";
			
		//	System.out.println("in for loop thru graph");
			
		}
		
		while(!(status[t].contentEquals("in_tree"))) {
			
			//System.out.println("in while loop ");
			
			int v=bestFringe(status,bandwidth);
			status[v]="in_tree";
			
			for(Node ed:G.adjacencyList[v]) {
			//	System.out.println("inn for loop of while loop");
				int w = ed.dest;
				
				if(status[w].contentEquals("unseen")) {
					status[w]="fringe";
					dad[w]=v;
					bandwidth[w]=minimum(bandwidth[v],ed.weight);
					}
					
				else if((status[w].contentEquals("fringe")) && (bandwidth[w]<minimum(bandwidth[v],ed.weight))) {
					dad[w]=v;
					bandwidth[w]=minimum(bandwidth[v],ed.weight);
					
				}	
					
				}
			
			
			}
		System.out.println("bandwidth of t"+ bandwidth[t]);

		System.out.println("Path of max bw:");
		LinkedList<Integer> pathList = new LinkedList<>();
		int p=t;
		while(p!=-999) {
			pathList.push(p);
			p=dad[p];
		}
		System.out.println(pathList);

			
		
	}
	

	public int minimum(int a,int b) {
	//	System.out.println("inside minimum func");
		int min = b;
		if(a<b) {
			min=a;
		}
		return min;
	}
	
	public int bestFringe(String[] status, int[] bandwidth) {
		// TODO Auto-generated method stub
		//System.out.println("inside bestfringe funct");
		int tempBW=0;
		String tempStatus="in_tree";
		int best=0;
		
		for(int i=0;i<G.vertices;i++) {
			//System.out.println("in best fring cha for loop");
			if(status[i].contentEquals("fringe") && tempBW < bandwidth[i]) {
				tempBW=bandwidth[i];
				best = i;
				
			}
		
		
		}
		
		return best;
	}
	


	
	
}
