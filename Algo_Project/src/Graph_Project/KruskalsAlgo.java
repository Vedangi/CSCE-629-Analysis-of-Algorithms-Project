package Graph_Project;

import java.util.*;

public class KruskalsAlgo {

	int inf = Integer.MAX_VALUE;
	int s;
	int t;
	Graph G;
	int currSize;
	 int[]  dad;
	 String[] status;
	 int[] bandwidth;
	 int[] rank;
	 int[] traceback;
	 
	 int[] parent;
	
	Edge []E_Hp;
	
	public KruskalsAlgo(Graph G,int s, int t) {
		super();
		this.s = s;
		this.t = t;
		this.G = G;
		
		E_Hp = new Edge[G.edges];
		
		dad = new int[G.vertices];
		bandwidth= new int[G.vertices];
		status = new String[G.vertices];
		rank = new int[G.vertices];
		parent = new int[G.vertices];
		traceback = new int[G.vertices];

		
		Arrays.fill(rank, 1);     
		             // wsas 1 or 0
	//	Arrays.fill(parent, 0);                //was khalcha for loop
		
		for(int i=0;i<G.vertices;i++) {
			parent[i]=i; 
			
		}
		
		status[s]="fringe";
		
		
		currSize=0;
		
		
	}

	public void heapSort() {
		
		 for(int i = 0; i < G.vertices; i++) {  
	            for(Node ned: G.adjacencyList[i]){ 
	                if(ned.dest>=i) {
	                	E_Hp[currSize]=new Edge(i,ned.dest,ned.weight);
	            		currSize++;
	                }	
	            } 
	           
	        } 
		 
		 
		 int size=currSize;
		 
		 for(int k =size/2-1;k>=0;k--) {
			 heapify(size,k);
		 }

		 for(int k = size-1;k>=0;k--) {
			 
			 
			 Edge temp = E_Hp[0];
			 E_Hp[0]=E_Hp[k];
			 E_Hp[k]=temp;
		
			 heapify(k,0);      
			 
		 }
		 
		 
	}
	
	
	public void heapify(int n,int i) {
		int max=i;
		int left_child=2*i+1;
		int right_child=2*i+2;
		
		if((left_child < n) && (E_Hp[left_child].weight> E_Hp[max].weight)) {
			max=left_child;
		}
		
		if((right_child < n) && (E_Hp[right_child].weight> E_Hp[max].weight)) {
			max=right_child;
		}
		
		if(max!=i) {
			
			Edge tempr=E_Hp[i];
			E_Hp[i]=E_Hp[max];
			E_Hp[max]=tempr;
			
			heapify(n,max);
		}
	}
	
	
	public void DFS(Graph G,int s,int t,String []status,int []dad,int []bandwidth) {
	
		if(s==t) {
			
			return;
			
		}
		
		status[s]="fringe";
		
		for (Node n:G.adjacencyList[s]) {
			if(status[n.dest].contentEquals("unseen")) {
				bandwidth[n.dest]=minimumOf(bandwidth[s],n.weight);
				dad[n.dest]=s;
				DFS(G,n.dest,t,status,dad,bandwidth);
			}
		}
		status[s]="in_tree";
	}
	
	public void mstPath(Graph newpathG) {
		
		Arrays.fill(dad,-999);	
		Arrays.fill(bandwidth,0);
		Arrays.fill(status, "unseen");
		Arrays.fill(traceback, 0); 
		
		bandwidth[s]=inf;
		int maxb=inf;
		
		DFS(newpathG,s,t,status,dad,bandwidth);
		int i=0;
		
		while(t!=s) {
			
			maxb= minimumOf(maxb,bandwidth[t]);
			traceback[i]=t;
			t=dad[t];
			i++;
			
		}
		traceback[i]=s;
		System.out.println("Maximum BW is "+maxb);
		
		System.out.println(Arrays.toString(traceback));
		
	}
	
	
	public int minimumOf(int a, int b) {
		int min=a;
		if(b<a) {
			min =  b;
		}
		return min;
	}
	
	
	
	public void methodKruskal() {
	
		heapSort();


	
		
		Graph pathG = new Graph(G.vertices);
		for(int i=(E_Hp.length-1);i>=0;i--) {
			Edge ed = E_Hp[i];
			int source = find(ed.src);
			int destination = find(ed.dest);
			
			if(source!=destination) {
				pathG.addEdge(ed.src, ed.dest, ed.weight);
				pathG.addEdge(ed.dest, ed.src, ed.weight);
				union(source,destination);
			}
		}
		
		mstPath(pathG);
		
	}
	
	public void makeSet(int i) {
		parent[i]=i;                                        //was i or 0
		rank[i]=1;                                        // was 1 or 0
	}
	
	public int find(int v) {
		int w=v;
		LinkedList<Integer> list_S=new LinkedList();
		while(parent[w]!=w) {                                            //!=w or 0
			list_S.push(w);
			w=parent[w];
		}
		while(list_S.size()>0) {
			v = list_S.pop();
			parent[v]=w;
			
		}
		return w;
		
		
	}
	
	public void union(int r1,int r2) {
		if(rank[r1]>rank[r2]) {
			parent[r2]=r1;
		}
		else if(rank[r1]<rank[r2]) {
			parent[r1]=r2;
		}
		else 
		{
			parent[r2]=r1;
			rank[r1]=rank[r1]+1;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
