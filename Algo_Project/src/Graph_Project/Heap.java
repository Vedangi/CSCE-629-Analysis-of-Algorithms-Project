package Graph_Project;
import java.util.*;

public class Heap {

	 int vertices;
	 int[] H;
	 int[] D;
	 int[] pos;
	
	 int currentSize;
	 int MaxSize;
	
	
	public Heap(int vertices) {
		super();
		this.vertices = vertices;
		
		H = new int[vertices+1];
		D= new int[vertices];
		pos=new int[vertices];
		currentSize=0;
		
		Arrays.fill(pos,-999);	
		Arrays.fill(D,0);
		
	
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
	
	
	
	public void insert(int v,int bw) {
		
		if (currentSize==vertices){
			System.out.println("Error in Insert");
		}
		
		H[currentSize]=v;
		currentSize++;
		D[v]=bw;
		int i=currentSize-1;
		pos[v]=i;
		
		
		while(i!=0 && (D[H[parent(i)]] < D[H[i]])) {
			
			int temp = H[i];
			H[i]=H[parent(i)];
			H[parent(i)]=temp;
			
			pos[H[i]]=i;
			pos[H[parent(i)]]=parent(i);
			i=parent(i);
			
		}
		
				
	}

	public void delete(int v) {
		int pos_inHeap = pos[v];
		if (pos_inHeap > vertices) {
			System.out.println("Error in delete");;
		}
		
		int temp;
		int i = currentSize - 1;     
		
		temp = H[i];
		H[i] = H[pos_inHeap];
		H[pos_inHeap] = temp;
		
		pos[H[pos_inHeap]]= pos_inHeap;
		currentSize--;
		pos[v]=-999;
		
		maxHeapify(pos_inHeap);
		
		
		
	}
	
	private void maxHeapify(int i) {
		// TODO Auto-generated method stub
		int max=i;
		int parent_i=parent(i);
		int left_child_i=leftChild(i);
		int right_child_i=rightChild(i);
		
		if(left_child_i < currentSize && D[H[left_child_i]]>D[H[max]])
			max=left_child_i;
		if(right_child_i < currentSize && D[H[right_child_i]]>D[H[max]])
		    max=right_child_i;
		
		if(max!=i) {
			int tempr=H[i];
			H[i]=H[max];
			H[max]=tempr;
			
			pos[H[i]]=i;
			pos[H[max]]=max;
			
			maxHeapify(max);
		}
		
		
	}


	int maxValue() {
		return H[0];
		
	}
	int maxBandwidth(int t) {
		return D[t];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
