
3.

-----
index: 0 1 2 3 4 5 6 7 8 9
value: 5 1 4 4 4 7 9 8 4 8 
size : 1 1 1 1   2 1   

=> 5 不可能連接到 7， since size(5) > size(7)

-----

index: 0 1 2 3 4 5 6 7 8 9
value: 0 7 5 3 4 5 6 7 6 9
size : 1 1 1 1 1 2 2 2 1 1

=> 可以藉由 weighted quick-union 創造出來

-----

index: 0 1 2 3 4 5 6 7 8 9
value: 5 7 1 5 0 6 6 6 1 1
size : 2 3 1 1 1 4     1 1

=> 1 不會連接到 7，since size(1) > size(7)

-----

index: 0 1 2 3 4 5 6 7 8 9
value: 1 1 1 1 6 0 9 9 1 1 
size : 2   1 1 1 1 2 1 1 4
