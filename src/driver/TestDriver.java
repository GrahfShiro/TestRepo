package driver;

import java.util.Set;

import org.jgraph.graph.DefaultEdge;

public class TestDriver {

	/*public static void main(String[] args) {
		
		Activities A = new Activities(0, "First", 5, 0, 0);
		Activities B = new Activities(1, "Second", 6, 1, 1);
		Activities C = new Activities(2, "Third", 7, 2, 2);
		Activities D = new Activities(3, "Fourth", 8, 3, 3);
		Activities E = new Activities(4, "Fifth", 9, 4, 4);
		Activities F = new Activities(5, "Sixth", 10, 5, 5);
		Activities G = new Activities(6, "Seventh", 11, 6, 6);
		Activities H = new Activities(7, "Eighth", 12, 7, 7);
		
		Users[] members = new Users[5];
		Projects tester = new Projects(123, "Test Project", members, "May 26 2016");
		
		tester.getActivityGraph().addVertex(A);
		tester.getActivityGraph().addVertex(B);
		tester.getActivityGraph().addVertex(C);
		tester.getActivityGraph().addVertex(D);
		tester.getActivityGraph().addVertex(E);
		tester.getActivityGraph().addVertex(F);
		tester.getActivityGraph().addVertex(G);
		tester.getActivityGraph().addVertex(H);
		
		tester.getActivityGraph().addEdge(A, B);
		tester.getActivityGraph().addEdge(A, C);
		tester.getActivityGraph().addEdge(B, D);
		tester.getActivityGraph().addEdge(C, D);
		tester.getActivityGraph().addEdge(D, E);
		tester.getActivityGraph().addEdge(D, F);
		tester.getActivityGraph().addEdge(E, G);
		tester.getActivityGraph().addEdge(F, G);
		tester.getActivityGraph().addEdge(G, H);
		
		Set<Activities> vertices = tester.getActivityGraph().vertexSet();
		Set<DefaultEdge> edges = tester.getActivityGraph().edgeSet();
		
		for(Activities e : vertices)
		{
			System.out.println(e.getId() + " " + e.getDescription());
			System.out.println("Connected to: ");
			Set<DefaultEdge> edgelist = tester.getActivityGraph().edgesOf(e);
			for(DefaultEdge f : edgelist)
			{
				if (tester.getActivityGraph().getEdgeTarget(f).getId() == e.getId())
					continue;
				System.out.println(tester.getActivityGraph().getEdgeTarget(f).getId() + " " + tester.getActivityGraph().getEdgeTarget(f).getDescription());
			}
			System.out.println("-------------------------");
			System.out.println("Incoming edges from: ");
			for(DefaultEdge f : edgelist)
			{
				if (tester.getActivityGraph().getEdgeSource(f) == null)
					continue;
				if (tester.getActivityGraph().getEdgeSource(f).getId() == e.getId())
					continue;
				
				System.out.println(tester.getActivityGraph().getEdgeSource(f).getId() + " " + tester.getActivityGraph().getEdgeSource(f).getDescription());
			}
			System.out.println("-----------------------------------------------------------------");
		}
	
		

	}*/

}
