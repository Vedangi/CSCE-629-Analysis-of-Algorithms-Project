package Graph_Project;
import java.util.*;

public class DijkstraHeap {

	double inf = Double.POSITIVE_INFINITY;
	static int V;
	int s;
	int t;
	Graph G ;
	static int[]  dad;
	static String[] status;
	static double[] bandwidth;
	
	Heap Hp;
	
	
	
	public DijkstraHeap(Graph G,int s, int t) {
		super();
	
		this.s = s;
		this.t = t;
		this.G = G;
		
		dad = new int[G.vertices];
		bandwidth= new double[G.vertices];
		status = new String[G.vertices];
		

		Arrays.fill(dad,-999);	
		Arrays.fill(bandwidth,0);
		Arrays.fill(status, "unseen");
		
		status[s]="in_tree";
		bandwidth[s]=inf;

		Heap Hp = new Heap(G.vertices);
		
	}
	
	public void calculate_dijkstra_Heap() {
		
		for(Node nod:G.adjacencyList[s]) {
			
			bandwidth[nod.dest]=nod.weight;
			dad[nod.dest]=s;
			status[nod.dest]="fringe";
			Hp.insert(nod.dest, bandwidth[nod.dest]);
			
		}
		
		while(!(status[t].contentEquals("in_tree"))) {
			
			int v = Hp.maxValue();
			Hp.delete(v);
			
			status[v]="in_tree";
			
			for(Node ed:G.adjacencyList[v]) {
				int w = ed.dest;
				if(status[w].contentEquals("unseen")) {
					status[w]="fringe";
					dad[w]=v;
					bandwidth[w]=minimum(bandwidth[v],ed.weight);
					Hp.insert(w, bandwidth[w]);
					}
					
				else if((status[w].equals("fringe")) && (bandwidth[w]<minimum(bandwidth[v],ed.weight))) {
					Hp.delete(w);
					dad[w]=v;
					bandwidth[w]=minimum(bandwidth[v],ed.weight);
					Hp.insert(w, bandwidth[w]);
				}	
					
				}
			
			
			}
		System.out.println("Bandwidth of t usin Heap and Dijku"+ bandwidth[t]);
		
	
		
		
	}



	public double minimum(double dt, int wt) {
		// TODO Auto-generated method stub
		double min = wt;
		if(dt<wt) {
			min=dt;
		}
		return min;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
