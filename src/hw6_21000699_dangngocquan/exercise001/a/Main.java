package hw6_21000699_dangngocquan.exercise001.a;

public class Main {
    public static void main(String[] args) {
        new Test().run();

        // Sample

/*

TEST UNSORTED ARRAY PRIORITY QUEUE
Action                                    Return                          Priority queue after action
--------------------------------------------------------------------------------------------------------------------------------------
size()                                    0                               PriorityQueue[]
isEmpty()                                 true                            PriorityQueue[]
insert([10, a])                                                           PriorityQueue[[10, a]]
insert(key=4, value=b)                                                    PriorityQueue[[10, a], [4, b]]
insert(key=7, value=c)                                                    PriorityQueue[[10, a], [4, b], [7, c]]
min()                                     [4, b]                          PriorityQueue[[10, a], [4, b], [7, c]]
removeMin()                               [4, b]                          PriorityQueue[[10, a], [7, c]]
insert(key=1, value=d)                                                    PriorityQueue[[10, a], [7, c], [1, d]]
insert(key=5, value=e)                                                    PriorityQueue[[10, a], [7, c], [1, d], [5, e]]
insert(key=3, value=f)                                                    PriorityQueue[[10, a], [7, c], [1, d], [5, e], [3, f]]
size()                                    5                               PriorityQueue[[10, a], [7, c], [1, d], [5, e], [3, f]]
isEmpty()                                 false                           PriorityQueue[[10, a], [7, c], [1, d], [5, e], [3, f]]
min()                                     [1, d]                          PriorityQueue[[10, a], [7, c], [1, d], [5, e], [3, f]]
removeMin()                               [1, d]                          PriorityQueue[[10, a], [7, c], [5, e], [3, f]]
removeMin()                               [3, f]                          PriorityQueue[[10, a], [7, c], [5, e]]
removeMin()                               [5, e]                          PriorityQueue[[10, a], [7, c]]
removeMin()                               [7, c]                          PriorityQueue[[10, a]]

*/
    }
}
