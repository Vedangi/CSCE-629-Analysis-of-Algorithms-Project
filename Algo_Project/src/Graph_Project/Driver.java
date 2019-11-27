package Graph_Project;

import java.time.Duration;
import java.time.Instant;

public class Driver {
	
	String dashedLine()
	{
	    StringBuilder sb = new StringBuilder(5000);
	    for(int n = 0; n < 5000; ++n)
	        sb.append('-');
	    sb.append(System.lineSeparator());
	    return sb.toString();
	}

	String doubleDashedLine()
	{
	    StringBuilder sb = new StringBuilder(5000);
	    for(int n = 0; n < 5000; ++n)
	        sb.append('=');
	    sb.append(System.lineSeparator());
	    return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Driver driver = new Driver();
//		//Graph testG=new Graph(7);
//		
//		testG.addEdge(0, 5, 11);
//		testG.addEdge(0, 6, 8);
//		testG.addEdge(0, 1, 40);
//		
//		testG.addEdge(1, 6, 29);
//		testG.addEdge(1, 2, 17);
//		
//		testG.addEdge(2, 6, 31);
//		testG.addEdge(2, 4, 40);
//		testG.addEdge(2, 3, 53);
//		
//		testG.addEdge(3, 4, 15);
//		testG.addEdge(5, 4, 46);
//		testG.addEdge(5, 6, 03);
//		
		//testG.printGraph();
		
		
		
//		int total_count_sparse=0;
//		
//		while(total_count_sparse!=0) {
//			
//		Instant startG= Instant.now();
//		Graph testSparse=new Graph(5000);
//		testSparse.generateSparseGraph(6);
//		Instant endG = Instant.now();
//
//		
//		long timeElapsedG= Duration.between(startG, endG).toMillis();
//		System.out.println("Time for generating sparse G:"+timeElapsedG+"milliseconds");
//	   //System.out.println("**************************************************************************************************");
//
//	   System.out.println(driver.doubleDashedLine());
//		
//
//		int count = 5;
//		while(count!=0) {
//		
//		int source=testSparse.init_random(4999, 0);
//		int destiny=testSparse.init_random(4999, 0);
//		
//		while(source==destiny) {
//			 destiny=testSparse.init_random(4999, 0);
//		}
//		
//		System.out.println("Source--"+ source+" |Destiny--"+destiny);
//
//		
//		Instant startD= Instant.now();
//		Dijkstra d1 = new Dijkstra(testSparse,source,destiny);                
//		d1.calculate_dijkstra();
//		Instant endD= Instant.now();
//		long timeElapsedD= Duration.between(startD, endD).toMillis();
//		System.out.println("Time for dijkstra without heap:"+timeElapsedD+" milliseconds");
//	
//		//System.out.println("-------------------------------------------------------------------------------------------------");
//		System.out.println(driver.dashedLine());
//		
//		Instant startDH= Instant.now();
//		DijkstraHeap dh = new DijkstraHeap(testSparse,source,destiny);
//		dh.calculate_dijkstra_Heap();
//		Instant endDH= Instant.now();
//		long timeElapsedDH= Duration.between(startDH, endDH).toMillis();
//		System.out.println("Time for dijkstra with heap:"+timeElapsedDH+" milliseconds");
//		//System.out.println("----------------------------------------------------------------------------------------------------");
//		System.out.println(driver.dashedLine());
//		
//		Instant startK= Instant.now();
//		KruskalsAlgo kal=new KruskalsAlgo(testSparse,source,destiny);         
//		kal.methodKruskal();
//		Instant endK= Instant.now();
//		long timeElapsedK= Duration.between(startK, endK).toMillis();
//		System.out.println("Time for Kruskal:"+timeElapsedK+" milliseconds");
//		//System.out.println("***************************************************************************************************");
//		System.out.println(driver.doubleDashedLine());
//	
//		count--;
//		}
//		total_count_sparse--;
//		}
		
		
		
		//////////////////////////////////////////////////////////////////////////////////
		
		int total_count_dense=1;
		
		while(total_count_dense!=0) {
			
		
		Instant startG= Instant.now();
		Graph testDense=new Graph(5000);
		testDense.generateDenseGraph1();
		Instant endG = Instant.now();
		
		long timeElapsedG= Duration.between(startG, endG).toMillis();
		System.out.println("Time for generating dense G:"+timeElapsedG+"milliseconds");
	   //System.out.println("**************************************************************************************************");

	   System.out.println(driver.doubleDashedLine());
		

		int count2 = 5;
		while(count2!=0) {
		
		int source=testDense.init_random(4999, 0);
		int destiny=testDense.init_random(4999, 0);
		
		while(source==destiny) {
			 destiny=testDense.init_random(4999, 0);
		}
		
		System.out.println("Source--"+ source+" |Destiny--"+destiny);

		
		Instant startD= Instant.now();
		Dijkstra d1 = new Dijkstra(testDense,source,destiny);                
		d1.calculate_dijkstra();
		Instant endD= Instant.now();
		long timeElapsedD= Duration.between(startD, endD).toMillis();
		System.out.println("Time for dijkstra without heap:"+timeElapsedD+" milliseconds");
	
		//System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println(driver.dashedLine());
		
		Instant startDH= Instant.now();
		DijkstraHeap dh = new DijkstraHeap(testDense,source,destiny);
		dh.calculate_dijkstra_Heap();
		Instant endDH= Instant.now();
		long timeElapsedDH= Duration.between(startDH, endDH).toMillis();
		System.out.println("Time for dijkstra with heap:"+timeElapsedDH+" milliseconds");
		//System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println(driver.dashedLine());
		
		Instant startK= Instant.now();
		KruskalsAlgo kal=new KruskalsAlgo(testDense,source,destiny);         
		kal.methodKruskal();
		Instant endK= Instant.now();
		long timeElapsedK= Duration.between(startK, endK).toMillis();
		System.out.println("Time for Kruskal:"+timeElapsedK+" milliseconds");
		//System.out.println("***************************************************************************************************");
		System.out.println(driver.doubleDashedLine());
	
		count2--;
		}
		total_count_dense--;
		}
		
		
		
		
		
		
		

	}
}
