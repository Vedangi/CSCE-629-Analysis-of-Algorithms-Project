package Graph_Project;

import java.util.*;

//status
//in_tree
//unseen
//fringe


public class Dijkstra {

	double inf = Double.POSITIVE_INFINITY;
	static int V;
	int s;
	int t;
	Graph G ;
	static int[]  dad;
	static String[] status;
	static double[] bandwidth;
	
	
	public Dijkstra(Graph g,int s, int t) {
		super();
	
		this.s = s;
		this.t = t;
		G = g;
		
		dad = new int[G.vertices];
		bandwidth= new double[G.vertices];
		status = new String[G.vertices];
		
		Arrays.fill(dad,-999);	
		Arrays.fill(bandwidth,0);
		Arrays.fill(status, "unseen");
		
		status[s]="in_tree";
		bandwidth[s]=inf;
		
		
	}
	
	public void calculate_dijkstra() {
		
		for(Node nod:G.adjacencyList[s]) {
			bandwidth[nod.dest]=nod.dest;
			dad[nod.dest]=s;
			status[nod.dest]="fringe";
			
		}
		
		while(!(status[t].contentEquals("in_tree"))) {
			int v=bestFringe(status,bandwidth);
			status[v]="in_tree";
			
			for(Node ed:G.adjacencyList[v]) {
				int w = ed.dest;
				if(status[w].contentEquals("unseen")) {
					status[w]="fringe";
					dad[w]=v;
					bandwidth[w]=minimum(bandwidth[v],ed.weight);
					}
					
				else if((status[w].equals("fringe")) && (bandwidth[w]<minimum(bandwidth[v],ed.weight))) {
					dad[w]=v;
					bandwidth[w]=minimum(bandwidth[v],ed.weight);
					
				}	
					
				}
			
			
			}
		System.out.println("bandwidth of t"+ bandwidth[t]);
			
		
	}

	public double minimum(double a,int b) {
		int min = b;
		if(a<b) {
			return a;
		}
		return b;
	}
	
	public int bestFringe(String[] status, double[] bandwidth) {
		// TODO Auto-generated method stub
		double tempBW=0;
		int best=0;
		
		for(int i=0;i<G.vertices;i++) {
			if(status[i].contentEquals("fringe") && tempBW < bandwidth[i]) {
				tempBW=bandwidth[i];
				best = i;
				
			}
		return best;
		
		}
		
		
		
		
		return 0;
	}
	


	
	
}
