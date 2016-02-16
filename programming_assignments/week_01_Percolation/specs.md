# Intro

- 從底部能連通到最上層就是一個 percolated 的零件

![Percolation](https://secure-assets.readability.com/b69996787ebae7113b62c8bd20b4e2c5f51fb261/687474703a2f2f636f7572736572612e63732e7072696e6365746f6e2e6564752f616c6773342f61737369676e6d656e74732f706572636f6c617465732e706e67)

```java
public class Percolation {
   public Percolation(int N)               // create N-by-N grid, with all sites blocked
   public void open(int i, int j)          // open site (row i, column j) if it is not open already
   public boolean isOpen(int i, int j)     // is site (row i, column j) open?
   public boolean isFull(int i, int j)     // is site (row i, column j) full?
   public boolean percolates()             // does the system percolate?

   public static void main(String[] args)  // test client (optional)
}
```
# Model

- N*N 的 grid

- 每一格可能是 open 或 blocked

# Problem

- 假如這個圖有 n 個是 open 的，那這個系統是 perlocated 的機率為 p