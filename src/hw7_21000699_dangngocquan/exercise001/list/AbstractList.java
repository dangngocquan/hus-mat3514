package hw7_21000699_dangngocquan.exercise001.list;

import java.util.Iterator;

public abstract class AbstractList<E> implements ListInterface<E> {
    @Override
    public String toString() {
        Iterator<E> iterator = iterator();
        StringBuilder sb = new StringBuilder("[");
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append(", ");
        }
        if (sb.length() > 1) sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
