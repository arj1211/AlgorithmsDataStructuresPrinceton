/*
 * 
 * Uses int array of length N to store a union's "id".
 * p and q are connected if and only if they have the same id.
 * 
 * Find: check if p and q have same id
 * 
 * Union: when merging p and q components,
 * change all entries whose id is id[p] to id[q]
 * 
 * Steps:
 * 
 * 1. All entries initially have different 
 * ids (meaning no two or more objects form a component)
 * 		- set the id of each object i to i ( id[i]=i )
 * 2. if id[p]==id[q] then p and q connected, else not connected
 * 
 * 3. when creating a union between p and q, 
 * 		id[i] = q , where i is any object connected 
 * 					to p (including p itself, so
 * 					id[p] = q )
 * 
 * 
 * 
 */


package unionfind;

public class QuickFind {

	private int[] id;
	
	public QuickFind(int N)
	{
		id = new int[N+1];
		for (int i=1;i<=N;i++)
		{
			id[i]=i;
		}
	}
	
	void union(int p, int q)
	{
		
	}
	
	boolean connected(int p, int q)
	{
		return id[p]==id[q];
	}
}
