import java.util.Scanner;

/*
 * Uses int array of length N to store a union's "id".
 * p and q are connected if they have the same 'root' 
 * 
 * id[i] is 'parent' of i
 *
 * id[id[id[...id[i]...]]] is 'root' of i
 *
 * Find: check if p and q have same root
 * 
 * Union: when merging components containing p and q,
 * root of p becomes 'child' of root of q 
 * 		--> id of p's root = id of q's root 
 * 
 * Steps:
 * 
 * 1. All entries initially have different 
 * ids (meaning no two or more objects form a component)
 * 		- set the id of each object i to i ( id[i]=i )
 * 
 * 2. if root(p)==root(q) then p and q connected, else not connected
 * 
 * 3. when creating a union between p and q, 
 * 		id[root(p)] = id[root(q)] 
 */

public class QuickUnion
{

	private static int id[];

	public QuickUnion(int N)
	{
		id = new int[N];
		for (int i = 0; i < N; i++)
		{
			id[i] = i;
		}
	}

	int root(int i)
	{
		// root of i
		while (i != id[i]) // while i is not its own parent
		{
			i = id[i]; // set i equal to its parent
		}
		// now i==id[i], meaning current i is equal to the root of the argument
		// passed into the method
		return i; // return the root of passed parameter
	}

	boolean connected(int p, int q)
	{
		// checks if p and q are connected
		return root(p) == root(q); // if p and q have same root, they are
									// connected, else not connected
	}

	void union(int p, int q)
	{
		// combine components containing p and q
		id[root(p)] = id[root(q)];
		/*
		 * id of root(p) is equal to root(p) id of root(q) is equal to root(q)
		 * set root of p to now equal rot of q, so the root of p is now a child
		 * of the component containing q, whose root is root(q)
		 */
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine().trim());
		QuickUnion qu = new QuickUnion(N);
		
		String s;

		while(true)
		{
			s = sc.nextLine().trim();
			if (s.toLowerCase().equals("x")) break;

			int p = Integer.parseInt(s.charAt(0)+"");
			int q = Integer.parseInt(s.charAt(2)+"");

			qu.union(p,q);
		}
		
		
	}
}