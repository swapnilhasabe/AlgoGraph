import java.util.ArrayList;

/**
 * @author swapnil
 *
 */
public class Problem6 {
ArrayList<Vertex> result=new ArrayList<>();
int count=0;	
public void testEulerian(Graph g) {
		// TODO Auto-generated method stub
	int countEvenDegreeVertices=0;	
	ArrayList<Vertex> oddEdges=new ArrayList<>();
	if(checkConnectivity(g)){
		//System.out.println("Graph is connected");
	for(int i=1;i<=g.numNodes;i++){
		if(g.verts.get(i).degree%2==0){
			
			countEvenDegreeVertices++;
		}		
		else{
			oddEdges.add(g.verts.get(i));
		}
	
	}
	//graph contains exactly two vertices and each has odd degree
	if(oddEdges.size()==2&&g.numNodes==2) {
		System.out.println("Graph has an Eulerian Path between vertices"+oddEdges.get(0) +"and"+oddEdges.get(1) );
	}
	else if(countEvenDegreeVertices==g.numNodes) System.out.println("Graph is Eulerian");
	    else{
		System.out.println("Graph is Not Eulerian It has"+ oddEdges.size() +"vertices of odd degree");
	     }
	}//end if loop checking connectivity	
	
	else {
	System.out.println("Graph is not Connected");	
	}
	}

	private boolean checkConnectivity(Graph g) {
		
			DFSVisit(g.verts.get(1));
			
	
		if(count==g.numNodes) return true;
		else return false;
	
	}

	private void DFSVisit(Vertex u) {
		
		u.seen=true;
        count++;	
		for(Edge e:u.Adj){
			Vertex v=e.otherEnd(u);
			if(!v.seen){
				v.seen=true;
			    DFSVisit(v);
			}
		}
	

	}

}
