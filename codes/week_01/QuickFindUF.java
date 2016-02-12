import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class QuickFindUF {
    private int[] id;
    private int count;
    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0 ; i < N; i++) {
            id[i] = i;
        }
    }
    public int count() {
        return count;
    }
    /**
    * Returns the component identifier for the component containing site <tt>p</tt>.
    * 找到 p 對應到的 identifier
    * @param  p the integer representing one site
    * @return the component identifier for the component containing site <tt>p</tt>
    * @throws IndexOutOfBoundsException unless <tt>0 &le; p &lt; N</tt>
    */
    public int find(int p) {
        validate(p);
        return id[p];
    }
    private void validate(int p) {
        int N = id.length;
        if (p < 0 || p >= N) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (N-1));
        }
    }
    // 測試 p 跟 q 兩點有沒有連結
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }
    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(N); 
        StdOut.println(uf.connected(N-2, N-1));
    }
}
