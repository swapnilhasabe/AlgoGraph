
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prim{
	
public void MST_Prim(Graph g) {
	EdgeComparator comparator = new EdgeComparator();	
	Vertex source=g.verts.get(1);
    source.seen=true;
	int wmst=0;
	PriorityQueue<Edge> q=new PriorityQueue<Edge>(comparator);
   
	for(Edge e:source.Adj){
	   q.add(e);
   }
while(!q.isEmpty()){
	Edge e=q.remove();
	if(e.From.seen==true&&e.To.seen==true) continue;
	Vertex u=e.From;
	Vertex v=e.To;
	v.parent=u;
	wmst=wmst+e.Weight;
	v.seen=true;
	for(Edge f:v.Adj){
		if(!(f.From.seen&&f.To.seen)) q.add(f);
		Vertex w=f.otherEnd(v);
		if(!w.seen)
		   q.add(f);
	}
	
}
System.out.println(wmst);






}







}
