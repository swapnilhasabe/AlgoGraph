import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* Algorithm 1. Remove vertices with no incoming edges, one at a
	 time, along with their incident edges, and add them to a list.
*/
/**
 * @author swapnil
 *
 */
public class Problem1 {
	List<Vertex> result=new ArrayList<>();
	public void toplogicalOrder1(Graph g) {
		
		Queue<Vertex> q=new LinkedList<>(); //contain vertices with incoming degree 0
		Vertex u=null;
		//for each node u, compute the incoming degree
		int count=0;
		for(int i=1;i<=g.numNodes;i++){
			if(g.verts.get(i).incomingDegree==0){
				q.add(g.verts.get(i));
			}
			
		}
		
		int top=1;
		while(!q.isEmpty()){
			u=q.remove();			
			count++;
			result.add(u);
			u.top=top++;
			for(Edge e: u.Adj){
				Vertex v= e.otherEnd(u);
				v.incomingDegree--;
				if(v.incomingDegree==0)
					q.add(v);
				
			}	
		
		}
		
		if(count!=g.numNodes){
			System.out.println("Graph is Not DAG");
		System.exit(0);
		}
		
		
		
	}   
public void display(){
	for(Vertex v:result){
		System.out.print(v+" ");
	}
}


}
