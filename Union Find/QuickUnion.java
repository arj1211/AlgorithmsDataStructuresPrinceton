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
 * 		--> id of p's root = q's root 
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
 * 		id[root(p)] = root(q) 
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
		id[root(p)] = root(q);
		/*
		 * id of root(p) is equal to root(q)
		 * set parent of root of p to root of q, so the root of p is now a child of root(q)
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
		
		for (int i=0;i<id.length;i++)
		{
			System.out.println("node: "+i+", parent: "+id[i]+", root: "+qu.root(i));
		}
	}
}


/*

Sample Input:

4 3
3 8
6 5
9 4
2 1
5 0
7 2
6 1
7 3

Output:

node: 0, parent: 1, root: 8
node: 1, parent: 8, root: 8
node: 2, parent: 1, root: 8
node: 3, parent: 8, root: 8
node: 4, parent: 3, root: 8
node: 5, parent: 0, root: 8
node: 6, parent: 5, root: 8
node: 7, parent: 1, root: 8
node: 8, parent: 8, root: 8
node: 9, parent: 8, root: 8

*/