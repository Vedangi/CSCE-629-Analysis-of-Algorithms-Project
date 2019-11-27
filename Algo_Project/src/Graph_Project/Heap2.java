package Graph_Project;

import java.util.Arrays;

public class Heap2 {
	int vertices;
	int least = Integer.MIN_VALUE;
	 int[] H;
	 int[] D;
	 int[] pos;
	
	 int currentSize;
	 int MaxSize;
	
	
	public Heap2(int vertices) {
		super();
		this.vertices = vertices;
		MaxSize=vertices;
		H = new int[vertices+1];
		D= new int[vertices];
		pos=new int[vertices];
		currentSize=-1;
		
		Arrays.fill(pos,-999);	
		Arrays.fill(D,0);
		Arrays.fill(H,0);
		
	
	}
	
	public int parent(int i) {
		if(i==0) {
			return 0;
		}
		return((i-1)/2);
	}
	public int leftChild(int i) {
		return (2*i + 1);
	}
	public int rightChild(int i) {
		return (2*i + 2	);
	}
	
	int maxValue() {
		return H[0];
		
	}
	int maxBandwidth(int t) {
		return D[t];
	}

	public void insert(int v,int bw) {
		
		if (currentSize==MaxSize){
			System.out.println("Error in Insert");
		}
		currentSize++;
		H[currentSize]=v;
		pos[v]=currentSize;
		
		D[v]=bw;
		
	   fixHeap(currentSize);
				
	}
	public int getIndex(int v) {
		return pos[v];
	}
	
	public void delete(int v) {
		deleteByIndex(getIndex(v));
	}
	
	public void deleteByIndex(int i) {
		if(pos[H[i]]==-999) {
			System.out.println("node not there");
		}
		pos[H[i]]=-999;
		//D[H[i]] = least;
		H[i]=H[currentSize];
		pos[H[i]]=i;
		currentSize--;
		fixHeap(i);
	}
	
	public void swap(int i, int j){
		int tmp = H[i];
		H[i] = H[j];
		H[j] = tmp;
		tmp = pos[H[i]];
		pos[H[i]] = pos[H[j]];
		pos[H[j]] = tmp;
	}
	
	public void fixHeap(int i) {
		if(i>0 && D[H[i]] > D[H[((i-1)/2)]]){
			
			while(i>0 && D[H[i]]>D[H[(i-1)/2]]){
			
				swap(i, (i-1)/2);
				i = (i-1)/2;
			}
		}
		
		else{
			while((2*i+1<=currentSize && D[H[i]] < D[H[2*i+1]]) || (2*i+2<=currentSize && D[H[i]] < D[H[2*i+2]])){
				if(2*i +2 <= currentSize && D[H[2*i+2]]>D[H[2*i+1]]){
					swap(i, 2*i+2);
					i = 2*i+2;
				}
				else{
					swap(i, 2*i+1);
					i=2*i+1;
				}
			}
		}
	}
	
	
	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Heap2 h=new Heap2(100);
		 h.insert(32,7812);
		 h.insert(34,2507);
		 h.insert(9,9545);
		 h.insert(18,8052);

		
		        System.out.println("max"+h.maxValue());
		
		        h.delete(h.H[0]);
		      
		        System.out.println("max"+ h.H[0]);
		        
		 h.insert(8,6664);
		 h.insert(10,8255);
		 h.insert(17,5941);
		 h.insert(20,6049);
		 h.insert(37,748);
		 h.insert(23,4798);
		 h.insert(1,5790);
		 h.insert(21,2706);
		 h.insert(11,4651);
//		 
		 System.out.println("max"+ h.H[0]);
		 h.delete(h.H[0]);
		 System.out.println("max"+ h.H[0]);
		 h.insert(22,7045);
//		 for(int i=0;i<100;i++) {
//				System.out.print(h.H[i]+",");
//			}
		// h.print();
		// cout<<h.max()<<" "<<h.maxValue()<<endl;
		 System.out.println("max"+h.H[0]);
		 h.delete(h.H[0]);
		 System.out.println("max"+h.H[0]);

	}

}
