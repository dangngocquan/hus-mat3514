package hw6_21000699_dangngocquan.exercise001.e;

public class MainE {
    public static void main(String[] args) {
        new TestE().run();

/*

TEST UNSORTED ARRAY PRIORITY QUEUE

TEST 1
Action                                    Return                          Priority queue after action
--------------------------------------------------------------------------------------------------------------------------------------
size()                                    0                               PriorityQueue[]
isEmpty()                                 true                            PriorityQueue[]
insert([10, 10])                                                          PriorityQueue[[10, 10]]
insert(key=4, value=4)                                                    PriorityQueue[[10, 10], [4, 4]]
insert(key=7, value=7)                                                    PriorityQueue[[10, 10], [4, 4], [7, 7]]
min()                                     [4, 4]                          PriorityQueue[[10, 10], [4, 4], [7, 7]]
removeMin()                               [4, 4]                          PriorityQueue[[10, 10], [7, 7]]
insert(key=1, value=1)                                                    PriorityQueue[[10, 10], [7, 7], [1, 1]]
insert(key=5, value=5)                                                    PriorityQueue[[10, 10], [7, 7], [1, 1], [5, 5]]
insert(key=3, value=3)                                                    PriorityQueue[[10, 10], [7, 7], [1, 1], [5, 5], [3, 3]]
size()                                    5                               PriorityQueue[[10, 10], [7, 7], [1, 1], [5, 5], [3, 3]]
isEmpty()                                 false                           PriorityQueue[[10, 10], [7, 7], [1, 1], [5, 5], [3, 3]]
min()                                     [1, 1]                          PriorityQueue[[10, 10], [7, 7], [1, 1], [5, 5], [3, 3]]
removeMin()                               [1, 1]                          PriorityQueue[[10, 10], [7, 7], [5, 5], [3, 3]]
removeMin()                               [3, 3]                          PriorityQueue[[10, 10], [7, 7], [5, 5]]
removeMin()                               [5, 5]                          PriorityQueue[[10, 10], [7, 7]]
removeMin()                               [7, 7]                          PriorityQueue[[10, 10]]

TEST 2
Action                                    Return                          Priority queue after action
--------------------------------------------------------------------------------------------------------------------------------------
size()                                    0                               PriorityQueue[]
isEmpty()                                 true                            PriorityQueue[]
insert([10.04, Item A])                                                   PriorityQueue[[10.04, Item A]]
insert(key=4.01, value=Item B)                                            PriorityQueue[[10.04, Item A], [4.01, Item B]]
insert(key=7.14, value=Item C)                                            PriorityQueue[[10.04, Item A], [4.01, Item B], [7.14, Item C]]
min()                                     [4.01, Item B]                  PriorityQueue[[10.04, Item A], [4.01, Item B], [7.14, Item C]]
removeMin()                               [4.01, Item B]                  PriorityQueue[[10.04, Item A], [7.14, Item C]]
insert(key=1.04, value=Item D)                                            PriorityQueue[[10.04, Item A], [7.14, Item C], [1.04, Item D]]
insert(key=5.01, value=Item E)                                            PriorityQueue[[10.04, Item A], [7.14, Item C], [1.04, Item D], [5.01, Item E]]
insert(key=3.01, value=Item F)                                            PriorityQueue[[10.04, Item A], [7.14, Item C], [1.04, Item D], [5.01, Item E], [3.01, Item F]]
size()                                    5                               PriorityQueue[[10.04, Item A], [7.14, Item C], [1.04, Item D], [5.01, Item E], [3.01, Item F]]
isEmpty()                                 false                           PriorityQueue[[10.04, Item A], [7.14, Item C], [1.04, Item D], [5.01, Item E], [3.01, Item F]]
min()                                     [1.04, Item D]                  PriorityQueue[[10.04, Item A], [7.14, Item C], [1.04, Item D], [5.01, Item E], [3.01, Item F]]
removeMin()                               [1.04, Item D]                  PriorityQueue[[10.04, Item A], [7.14, Item C], [5.01, Item E], [3.01, Item F]]
removeMin()                               [3.01, Item F]                  PriorityQueue[[10.04, Item A], [7.14, Item C], [5.01, Item E]]
removeMin()                               [5.01, Item E]                  PriorityQueue[[10.04, Item A], [7.14, Item C]]
removeMin()                               [7.14, Item C]                  PriorityQueue[[10.04, Item A]]


TEST SORTED ARRAY PRIORITY QUEUE

TEST 1
Action                                    Return                          Priority queue after action
--------------------------------------------------------------------------------------------------------------------------------------
size()                                    0                               PriorityQueue[]
isEmpty()                                 true                            PriorityQueue[]
insert([10, 10])                                                          PriorityQueue[[10, 10]]
insert(key=4, value=4)                                                    PriorityQueue[[4, 4], [10, 10]]
insert(key=7, value=7)                                                    PriorityQueue[[4, 4], [7, 7], [10, 10]]
min()                                     [4, 4]                          PriorityQueue[[4, 4], [7, 7], [10, 10]]
removeMin()                               [4, 4]                          PriorityQueue[[7, 7], [10, 10]]
insert(key=1, value=1)                                                    PriorityQueue[[1, 1], [7, 7], [10, 10]]
insert(key=5, value=5)                                                    PriorityQueue[[1, 1], [5, 5], [7, 7], [10, 10]]
insert(key=3, value=3)                                                    PriorityQueue[[1, 1], [3, 3], [5, 5], [7, 7], [10, 10]]
size()                                    5                               PriorityQueue[[1, 1], [3, 3], [5, 5], [7, 7], [10, 10]]
isEmpty()                                 false                           PriorityQueue[[1, 1], [3, 3], [5, 5], [7, 7], [10, 10]]
min()                                     [1, 1]                          PriorityQueue[[1, 1], [3, 3], [5, 5], [7, 7], [10, 10]]
removeMin()                               [1, 1]                          PriorityQueue[[3, 3], [5, 5], [7, 7], [10, 10]]
removeMin()                               [3, 3]                          PriorityQueue[[5, 5], [7, 7], [10, 10]]
removeMin()                               [5, 5]                          PriorityQueue[[7, 7], [10, 10]]
removeMin()                               [7, 7]                          PriorityQueue[[10, 10]]

TEST 2
Action                                    Return                          Priority queue after action
--------------------------------------------------------------------------------------------------------------------------------------
size()                                    0                               PriorityQueue[]
isEmpty()                                 true                            PriorityQueue[]
insert([10.04, Item A])                                                   PriorityQueue[[10.04, Item A]]
insert(key=4.01, value=Item B)                                            PriorityQueue[[4.01, Item B], [10.04, Item A]]
insert(key=7.14, value=Item C)                                            PriorityQueue[[4.01, Item B], [7.14, Item C], [10.04, Item A]]
min()                                     [4.01, Item B]                  PriorityQueue[[4.01, Item B], [7.14, Item C], [10.04, Item A]]
removeMin()                               [4.01, Item B]                  PriorityQueue[[7.14, Item C], [10.04, Item A]]
insert(key=1.04, value=Item D)                                            PriorityQueue[[1.04, Item D], [7.14, Item C], [10.04, Item A]]
insert(key=5.01, value=Item E)                                            PriorityQueue[[1.04, Item D], [5.01, Item E], [7.14, Item C], [10.04, Item A]]
insert(key=3.01, value=Item F)                                            PriorityQueue[[1.04, Item D], [3.01, Item F], [5.01, Item E], [7.14, Item C], [10.04, Item A]]
size()                                    5                               PriorityQueue[[1.04, Item D], [3.01, Item F], [5.01, Item E], [7.14, Item C], [10.04, Item A]]
isEmpty()                                 false                           PriorityQueue[[1.04, Item D], [3.01, Item F], [5.01, Item E], [7.14, Item C], [10.04, Item A]]
min()                                     [1.04, Item D]                  PriorityQueue[[1.04, Item D], [3.01, Item F], [5.01, Item E], [7.14, Item C], [10.04, Item A]]
removeMin()                               [1.04, Item D]                  PriorityQueue[[3.01, Item F], [5.01, Item E], [7.14, Item C], [10.04, Item A]]
removeMin()                               [3.01, Item F]                  PriorityQueue[[5.01, Item E], [7.14, Item C], [10.04, Item A]]
removeMin()                               [5.01, Item E]                  PriorityQueue[[7.14, Item C], [10.04, Item A]]
removeMin()                               [7.14, Item C]                  PriorityQueue[[10.04, Item A]]


TEST UNSORTED LINKED PRIORITY QUEUE

TEST 1
Action                                    Return                          Priority queue after action
--------------------------------------------------------------------------------------------------------------------------------------
size()                                    0                               PriorityQueue[]
isEmpty()                                 true                            PriorityQueue[]
insert([10, 10])                                                          PriorityQueue[[10, 10]]
insert(key=4, value=4)                                                    PriorityQueue[[10, 10], [4, 4]]
insert(key=7, value=7)                                                    PriorityQueue[[10, 10], [4, 4], [7, 7]]
min()                                     [4, 4]                          PriorityQueue[[10, 10], [4, 4], [7, 7]]
removeMin()                               [4, 4]                          PriorityQueue[[10, 10], [7, 7]]
insert(key=1, value=1)                                                    PriorityQueue[[10, 10], [7, 7], [1, 1]]
insert(key=5, value=5)                                                    PriorityQueue[[10, 10], [7, 7], [1, 1], [5, 5]]
insert(key=3, value=3)                                                    PriorityQueue[[10, 10], [7, 7], [1, 1], [5, 5], [3, 3]]
size()                                    5                               PriorityQueue[[10, 10], [7, 7], [1, 1], [5, 5], [3, 3]]
isEmpty()                                 false                           PriorityQueue[[10, 10], [7, 7], [1, 1], [5, 5], [3, 3]]
min()                                     [1, 1]                          PriorityQueue[[10, 10], [7, 7], [1, 1], [5, 5], [3, 3]]
removeMin()                               [1, 1]                          PriorityQueue[[10, 10], [7, 7], [5, 5], [3, 3]]
removeMin()                               [3, 3]                          PriorityQueue[[10, 10], [7, 7], [5, 5]]
removeMin()                               [5, 5]                          PriorityQueue[[10, 10], [7, 7]]
removeMin()                               [7, 7]                          PriorityQueue[[10, 10]]

TEST 2
Action                                    Return                          Priority queue after action
--------------------------------------------------------------------------------------------------------------------------------------
size()                                    0                               PriorityQueue[]
isEmpty()                                 true                            PriorityQueue[]
insert([10.04, Item A])                                                   PriorityQueue[[10.04, Item A]]
insert(key=4.01, value=Item B)                                            PriorityQueue[[10.04, Item A], [4.01, Item B]]
insert(key=7.14, value=Item C)                                            PriorityQueue[[10.04, Item A], [4.01, Item B], [7.14, Item C]]
min()                                     [4.01, Item B]                  PriorityQueue[[10.04, Item A], [4.01, Item B], [7.14, Item C]]
removeMin()                               [4.01, Item B]                  PriorityQueue[[10.04, Item A], [7.14, Item C]]
insert(key=1.04, value=Item D)                                            PriorityQueue[[10.04, Item A], [7.14, Item C], [1.04, Item D]]
insert(key=5.01, value=Item E)                                            PriorityQueue[[10.04, Item A], [7.14, Item C], [1.04, Item D], [5.01, Item E]]
insert(key=3.01, value=Item F)                                            PriorityQueue[[10.04, Item A], [7.14, Item C], [1.04, Item D], [5.01, Item E], [3.01, Item F]]
size()                                    5                               PriorityQueue[[10.04, Item A], [7.14, Item C], [1.04, Item D], [5.01, Item E], [3.01, Item F]]
isEmpty()                                 false                           PriorityQueue[[10.04, Item A], [7.14, Item C], [1.04, Item D], [5.01, Item E], [3.01, Item F]]
min()                                     [1.04, Item D]                  PriorityQueue[[10.04, Item A], [7.14, Item C], [1.04, Item D], [5.01, Item E], [3.01, Item F]]
removeMin()                               [1.04, Item D]                  PriorityQueue[[10.04, Item A], [7.14, Item C], [5.01, Item E], [3.01, Item F]]
removeMin()                               [3.01, Item F]                  PriorityQueue[[10.04, Item A], [7.14, Item C], [5.01, Item E]]
removeMin()                               [5.01, Item E]                  PriorityQueue[[10.04, Item A], [7.14, Item C]]
removeMin()                               [7.14, Item C]                  PriorityQueue[[10.04, Item A]]


TEST SORTED LINKED PRIORITY QUEUE

TEST 1
Action                                    Return                          Priority queue after action
--------------------------------------------------------------------------------------------------------------------------------------
size()                                    0                               PriorityQueue[]
isEmpty()                                 true                            PriorityQueue[]
insert([10, 10])                                                          PriorityQueue[[10, 10]]
insert(key=4, value=4)                                                    PriorityQueue[[4, 4], [10, 10]]
insert(key=7, value=7)                                                    PriorityQueue[[4, 4], [7, 7], [10, 10]]
min()                                     [4, 4]                          PriorityQueue[[4, 4], [7, 7], [10, 10]]
removeMin()                               [4, 4]                          PriorityQueue[[7, 7], [10, 10]]
insert(key=1, value=1)                                                    PriorityQueue[[1, 1], [7, 7], [10, 10]]
insert(key=5, value=5)                                                    PriorityQueue[[1, 1], [5, 5], [7, 7], [10, 10]]
insert(key=3, value=3)                                                    PriorityQueue[[1, 1], [3, 3], [5, 5], [7, 7], [10, 10]]
size()                                    5                               PriorityQueue[[1, 1], [3, 3], [5, 5], [7, 7], [10, 10]]
isEmpty()                                 false                           PriorityQueue[[1, 1], [3, 3], [5, 5], [7, 7], [10, 10]]
min()                                     [1, 1]                          PriorityQueue[[1, 1], [3, 3], [5, 5], [7, 7], [10, 10]]
removeMin()                               [1, 1]                          PriorityQueue[[3, 3], [5, 5], [7, 7], [10, 10]]
removeMin()                               [3, 3]                          PriorityQueue[[5, 5], [7, 7], [10, 10]]
removeMin()                               [5, 5]                          PriorityQueue[[7, 7], [10, 10]]
removeMin()                               [7, 7]                          PriorityQueue[[10, 10]]

TEST 2
Action                                    Return                          Priority queue after action
--------------------------------------------------------------------------------------------------------------------------------------
size()                                    0                               PriorityQueue[]
isEmpty()                                 true                            PriorityQueue[]
insert([10.04, Item A])                                                   PriorityQueue[[10.04, Item A]]
insert(key=4.01, value=Item B)                                            PriorityQueue[[4.01, Item B], [10.04, Item A]]
insert(key=7.14, value=Item C)                                            PriorityQueue[[4.01, Item B], [7.14, Item C], [10.04, Item A]]
min()                                     [4.01, Item B]                  PriorityQueue[[4.01, Item B], [7.14, Item C], [10.04, Item A]]
removeMin()                               [4.01, Item B]                  PriorityQueue[[7.14, Item C], [10.04, Item A]]
insert(key=1.04, value=Item D)                                            PriorityQueue[[1.04, Item D], [7.14, Item C], [10.04, Item A]]
insert(key=5.01, value=Item E)                                            PriorityQueue[[1.04, Item D], [5.01, Item E], [7.14, Item C], [10.04, Item A]]
insert(key=3.01, value=Item F)                                            PriorityQueue[[1.04, Item D], [3.01, Item F], [5.01, Item E], [7.14, Item C], [10.04, Item A]]
size()                                    5                               PriorityQueue[[1.04, Item D], [3.01, Item F], [5.01, Item E], [7.14, Item C], [10.04, Item A]]
isEmpty()                                 false                           PriorityQueue[[1.04, Item D], [3.01, Item F], [5.01, Item E], [7.14, Item C], [10.04, Item A]]
min()                                     [1.04, Item D]                  PriorityQueue[[1.04, Item D], [3.01, Item F], [5.01, Item E], [7.14, Item C], [10.04, Item A]]
removeMin()                               [1.04, Item D]                  PriorityQueue[[3.01, Item F], [5.01, Item E], [7.14, Item C], [10.04, Item A]]
removeMin()                               [3.01, Item F]                  PriorityQueue[[5.01, Item E], [7.14, Item C], [10.04, Item A]]
removeMin()                               [5.01, Item E]                  PriorityQueue[[7.14, Item C], [10.04, Item A]]
removeMin()                               [7.14, Item C]                  PriorityQueue[[10.04, Item A]]

*/
    }
}
