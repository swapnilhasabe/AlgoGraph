import java.util.Stack;

/**
 * @author swapnil
 *
 */
public class Problem7 {
Stack<Vertex> s=new Stack<>();
	public void testCycle(Graph g) {
		Vertex src=g.verts.get(1);
		src.seen=false;
	if(!src.seen)
		DFS_visit(src);
	}

	private void DFS_visit(Vertex u) {
		u.seen=true;
		
		s.push(u);
		
		for(Edge e:u.Adj){
			Vertex v=e.otherEnd(u);
			if(!v.seen){
			v.parent=u;
				DFS_visit(v);
			}
			else {
				if(v!=u.parent){
					System.out.println("Cycle");
				}
			}
				
			
		}
		
	}

}
