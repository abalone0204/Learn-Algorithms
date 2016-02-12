
- Lazy approach

- 是一個樹狀圖，用 array 表示時，裡面都放著該節點的 root

- 如果沒指定節點，那 root 就會是自己

假設節點 1 的 root 是 2 的話:

index 0 1 2
value 0 2 2

- `find`: 看 p 跟 q 是不是有一樣的 root

- `union`: to merge p and q, set id of q's root to id of p's root

```java
private root(int n) {
  while(i != id[i]) i = id[i];
  return i;
}
```


|  algorithm  | initialize | union | find |
|-------------|------------|-------|------|
|  quick-find |     N      |   N   |  1   |
| quick-union |     N      |   N   |  N   |
|-----------------------------------------|


- Quick-find 
  - defect:
    - union 太貴了（要去更改每個相關的節點）
    - 樹很扁平，但是讓樹扁平的成本太高

- Quick-union
  - defect:
    - 樹可能會太高
    - find 的成本可能會太高


