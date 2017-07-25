package UnionFind;


public class PercolationStats
{
    public PercolationStats(int n, int trials) // perform trials independent experiments on an n*n grid
    {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("n or trials <= 0");

    }

    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
    }

    public double mean() // sample mean of percolation threshold
    {

    }

    public double stddev() // sample standard deviation of percolation threshold
    {

    }

    public double confidenceLo() // low endpoint of 95% confidence interval
    {

    }

    public double confidenceHi() // high endpoint of 95% confidence interval
    {

    }
}

