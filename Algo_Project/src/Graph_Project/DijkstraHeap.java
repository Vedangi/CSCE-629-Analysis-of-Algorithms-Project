package Graph_Project;
import java.util.*;

public class DijkstraHeap {

	Integer inf = Integer.MAX_VALUE;
	int V;
	int s;
	int t;
	Graph G ;
	 int[]  dad;
	 String[] status;
	 int[] bandwidth;
	
	Heap2 Hp;
	
	
	
	public DijkstraHeap(Graph G,int s, int t) {
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

		Hp = new Heap2(G.vertices);
		
	}
	
	public void calculate_dijkstra_Heap() {
		Hp.insert(s, bandwidth[s]);
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
					
				else if((status[w].contentEquals("fringe")) && (bandwidth[w]<minimum(bandwidth[v],ed.weight))) {
					Hp.delete(w);
					dad[w]=v;
					bandwidth[w]=minimum(bandwidth[v],ed.weight);
					Hp.insert(w, bandwidth[w]);
				}	
					
				}
			
			
			}
		System.out.println("Bandwidth of t using Dijkstra with  Heap is  "+"--->"+ Hp.maxBandwidth(t));
		
		LinkedList<Integer> pathListH = new LinkedList<>();
		int p=t;
		while(p!=-999) {
			pathListH.push(p);
			p=dad[p];
		}
		System.out.println(pathListH);
		
	
		
		
	}



	public int minimum(int dt, int wt) {
		// TODO Auto-generated method stub
		int min = wt;
		if(dt<wt) {
			min=dt;
		}
		return min;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
