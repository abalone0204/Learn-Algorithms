# Data Structure

前一段我們簡化了點和點之間的連接，

就是為了能不在乎細節，

抽象化的用 integer 來表示 nodes 之間的連接。

- 以一個 int 的 array 來表示

- p 跟 q 有連接的話，兩者會有相同的 id

以下三個 connected components：

{0, 1} {2,3,4} {5,6,7}

表示成陣列會是這樣

index 0 1 2 3 4 5 6 7
value 1 1 2 2 2 5 5 5

union(0, 2)

index 0 1 2 3 4 5 6 7
value 2 2 2 2 2 5 5 5

{0,1,2,3,4} {5,6,7}

實作的 code 會放在[這裡](https://github.com/abalone0204/Learn-Algorithms/blob/master/codes/week_01/QuickFindUF.java)

跟原本實作不一樣的地方是我加了一個 `show_array()`，

這樣更容易去觀察 array 值的變化。




