package UnionFind;


import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats
{

    final private double[] fracOpen;
    final private int T;
    private int openSites = 0;

    public PercolationStats(int n, int trials) // perform trials independent experiments on an n*n grid
    {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("n or trials <= 0");

        fracOpen = new double[trials];
        T = trials;

        for (int i = 0; i < T; i++)
        {
            Percolation percolation = new Percolation(n); // new grid all blocked sites
            while (!percolation.percolates()) // while it isn't percolated
            {
                percolation.open(StdRandom.uniform(1, n + 1), StdRandom.uniform(1, n + 1));
                openSites++;
            }
            fracOpen[i] = (double) openSites / (n * n);
        }


    }

    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats percolationStats = new PercolationStats(n, T);

        // System.out.println("args = [" + args[0] + ", " + args[1] + "]");

        System.out.println("mean                    = " + percolationStats.mean());
        System.out.println("stddev                  = " + percolationStats.stddev());
        System.out.println("95% confidence interval = [" + percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi() + "]");
    }

    public double mean() // sample mean of percolation threshold
    {
        return StdStats.mean(fracOpen);
    }

    public double stddev() // sample standard deviation of percolation threshold
    {
        if (T == 1) return Double.NaN;
        return StdStats.stddev(fracOpen);
    }

    public double confidenceLo() // low endpoint of 95% confidence interval
    {
        return mean() - ((1.96 * stddev()) / Math.sqrt(T));
    }

    public double confidenceHi() // high endpoint of 95% confidence interval
    {
        return mean() + ((1.96 * stddev()) / Math.sqrt(T));
    }
}

