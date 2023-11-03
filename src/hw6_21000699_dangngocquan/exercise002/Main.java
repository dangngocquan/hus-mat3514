package hw6_21000699_dangngocquan.exercise002;

public class Main {
    public static void main(String[] args) {
        new Test().run();

/*

TEST MIN HEAP PRIORITY QUEUE
Action                                    Return                          Priority queue after action
--------------------------------------------------------------------------------------------------------------------------------------
size()                                    0                               PriorityQueue[]
isEmpty()                                 true                            PriorityQueue[]
insert([5, a])                                                            PriorityQueue[[5, a]]
insert(key=3, value=b)                                                    PriorityQueue[[3, b], [5, a]]
insert(key=1, value=c)                                                    PriorityQueue[[1, c], [5, a], [3, b]]
min()                                     [1, c]                          PriorityQueue[[1, c], [5, a], [3, b]]
removeMin()                               [1, c]                          PriorityQueue[[3, b], [5, a]]
insert(key=4, value=d)                                                    PriorityQueue[[3, b], [5, a], [4, d]]
insert(key=2, value=e)                                                    PriorityQueue[[2, e], [3, b], [4, d], [5, a]]
insert(key=6, value=f)                                                    PriorityQueue[[2, e], [3, b], [4, d], [5, a], [6, f]]
size()                                    5                               PriorityQueue[[2, e], [3, b], [4, d], [5, a], [6, f]]
isEmpty()                                 false                           PriorityQueue[[2, e], [3, b], [4, d], [5, a], [6, f]]
min()                                     [2, e]                          PriorityQueue[[2, e], [3, b], [4, d], [5, a], [6, f]]
removeMin()                               [2, e]                          PriorityQueue[[3, b], [5, a], [4, d], [6, f]]
removeMin()                               [3, b]                          PriorityQueue[[4, d], [5, a], [6, f]]
removeMin()                               [4, d]                          PriorityQueue[[5, a], [6, f]]
removeMin()                               [5, a]                          PriorityQueue[[6, f]]

*/
    }
}
