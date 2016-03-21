import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author swapnil
 *
 */
public class Problem5 {

	public void findOddLengthCycle(Graph g) {
		if(isBipartite(g)){
			System.out.println("Graph is Bipartite then It has No ODD cycle");
		}
		else{
			System.out.println("Graph is Non Bipartite. Above List Shows Odd Cycle Length");
		}
	}

	private boolean isBipartite(Graph g) {
	//Run BFS on each component	
		for(int i=1;i<=g.numNodes;i++){
			g.verts.get(i).seen=false;
			g.verts.get(i).parent=null;
	        g.verts.get(i).distance=Integer.MAX_VALUE;
		}
	Queue<Vertex> q=new LinkedList<>();
		for(int i=1;i<=g.numNodes;i++){	
		Vertex source=g.verts.get(i);
			if(!source.seen){
		  source.distance=0;
			q.add(source);
		source.seen=true;
			while(!q.isEmpty()){
			Vertex u=q.remove();
			for(Edge e:u.Adj){
				Vertex v=e.otherEnd(u);
				if(!v.seen){
				v.seen=true;
				v.parent=u;
				v.distance=u.distance+1;
				q.add(v);
				}
				
				else{
					if(u.distance==v.distance){
					ArrayList<Vertex> oddCycle=new ArrayList<>();	
						while(u!=v){
							oddCycle.add(u);
							oddCycle.add(v);
						u=u.parent;
						v=v.parent;
						}
						oddCycle.add(u);
						System.out.println(oddCycle);
						return false;
					
					
					}
				}
			}
					
		}
	}
		
				
}//for loop
		System.out.println("Graph is bipartite");
		for (Vertex u : g) {
		    if (u.distance % 2 == 0) {
			System.out.println(u + " Outer");
		    } else {
			System.out.println(u + " Inner");
		    }
		}	
		
		
		return true;
	}

}
