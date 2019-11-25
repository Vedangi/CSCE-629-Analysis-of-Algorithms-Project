package Graph_Project;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph testG=new Graph(7);
		
		testG.addEdge(0, 5, 11);
		testG.addEdge(0, 6, 8);
		testG.addEdge(0, 1, 40);
		
		testG.addEdge(1, 6, 29);
		testG.addEdge(1, 2, 17);
		
		testG.addEdge(2, 6, 31);
		testG.addEdge(2, 4, 40);
		testG.addEdge(2, 3, 53);
		
		testG.addEdge(3, 4, 15);
		testG.addEdge(5, 4, 46);
		testG.addEdge(5, 6, 03);
		
		//testG.printGraph();
		
		Graph testSparse=new Graph(5000);
		testSparse.generateSparseGraph(5);
		
		Dijkstra d1 = new Dijkstra(testSparse,5,47);                //tested working fine
		d1.calculate_dijkstra();
		
		System.out.println("/////////////////////////////////////////////////////////////////////////////////////");
		
		DijkstraHeap dh = new DijkstraHeap(testSparse,5,47);
		dh.calculate_dijkstra_Heap();
		
		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
//		
		KruskalsAlgo kal=new KruskalsAlgo(testSparse,5,47);         //tested working fine
		kal.methodKruskal();
//		
		
	}

}
