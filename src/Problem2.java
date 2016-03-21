import java.util.Stack;
/* Algorithm 2. Run DFS on g and push nodes to a stack in the
	 order in which they finish.  Write code without using global variables.
*/
/**
 * @author swapnil
 *
 */
public class Problem2 {
	Stack<Vertex> stack=new Stack<>();
	public void toplogicalOrder2(Graph g) {
		
		//run DFS on Graph
		for(int i=1;i<=g.numNodes;i++){
			if(g.verts.get(i).seen==false)
			 DFS_visited(g.verts.get(i));
			 
		}
		
		
		
	      
	   }

	public void DFS_visited(Vertex u) {
		u.seen=true;
	
		for(Edge e:u.Adj){
		Vertex v=e.otherEnd(u);	
			if(v.seen==false)				
				DFS_visited(v);
			 
		}
		stack.push(u);
	}
public void display(){
	while(!stack.isEmpty())
		System.out.print(stack.pop()+" ");
	
}

}
