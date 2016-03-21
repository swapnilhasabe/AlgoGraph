import java.util.ArrayList;
import java.util.Stack;

/**
 * @author swapnil
 *
 */
public class Problem4 {

	Stack<Vertex> stack=new Stack<>();
	ArrayList<Vertex> elements=new ArrayList<>();
	public void findStringlyConnectedComponent(Graph g) {
	
		for(int i=1;i<=g.numNodes;i++){
		
			if(g.verts.get(i).seen==false)
		   DFS_visit(g.verts.get(i));		
	}	
//making every vertex seen property false to run dfs again
	for(int i=1;i<=g.numNodes;i++){
	g.verts.get(i).seen=false;
	}
	  
	
	while(!stack.empty()){		
		  elements.add(stack.pop());
	}	 
	// Run DFS2 by popping the elements from the stack
	int finishTime=0;           //Initialize finishing time
	for(Vertex vertexCounter:elements){
	     if(g.verts.get(vertexCounter.name).seen==false){
	    	 finishTime++;
	    	 DFS_visit2(g.verts.get(vertexCounter.name), finishTime);
	     }	
	
	}
	 
	
	
	
	}

	private void DFS_visit2(Vertex u,int finish_time) {
		u.seen=true;
	    u.componentNumber=finish_time;
		for(Edge e:u.revAdj){
			Vertex v=e.otherEnd(u);
			if(v.seen==false){
				
				DFS_visit2(v,finish_time);
			}
		
		}
		stack.push(u);
			
	}
	public void display() {

		for(Vertex vertexCounter:stack) {
             
			System.out.println(vertexCounter + "component: " + vertexCounter.componentNumber);
		}
	}

	private void DFS_visit(Vertex u) {
	u.seen=true;
	for(Edge e:u.Adj){
		Vertex v=e.otherEnd(u);
		if(v.seen==false){
			DFS_visit(v);
	
		}
	}
	stack.push(u);
	
	}

}
