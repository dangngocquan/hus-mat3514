package hw6_21000699_dangngocquan.exercise001.d;

public class Main {
    public static void main(String[] args) {
        new Test().run();

        // Sample

/*

TEST SORTED LINKED PRIORITY QUEUE
Action                                    Return                          Priority queue after action
--------------------------------------------------------------------------------------------------------------------------------------
size()                                    0                               PriorityQueue[]
isEmpty()                                 true                            PriorityQueue[]
insert([10, a])                                                           PriorityQueue[[10, a]]
insert(key=4, value=b)                                                    PriorityQueue[[4, b], [10, a]]
insert(key=7, value=c)                                                    PriorityQueue[[4, b], [7, c], [10, a]]
min()                                     [4, b]                          PriorityQueue[[4, b], [7, c], [10, a]]
removeMin()                               [4, b]                          PriorityQueue[[7, c], [10, a]]
insert(key=1, value=d)                                                    PriorityQueue[[1, d], [7, c], [10, a]]
insert(key=5, value=e)                                                    PriorityQueue[[1, d], [5, e], [7, c], [10, a]]
insert(key=3, value=f)                                                    PriorityQueue[[1, d], [3, f], [5, e], [7, c], [10, a]]
size()                                    5                               PriorityQueue[[1, d], [3, f], [5, e], [7, c], [10, a]]
isEmpty()                                 false                           PriorityQueue[[1, d], [3, f], [5, e], [7, c], [10, a]]
min()                                     [1, d]                          PriorityQueue[[1, d], [3, f], [5, e], [7, c], [10, a]]
removeMin()                               [1, d]                          PriorityQueue[[3, f], [5, e], [7, c], [10, a]]
removeMin()                               [3, f]                          PriorityQueue[[5, e], [7, c], [10, a]]
removeMin()                               [5, e]                          PriorityQueue[[7, c], [10, a]]
removeMin()                               [7, c]                          PriorityQueue[[10, a]]

*/
    }
}
