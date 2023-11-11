package hw6_21000699_dangngocquan.exercise006.models;

public class SharesBuyOrder
        extends SharesOrder
        implements Comparable<SharesBuyOrder> {
    public SharesBuyOrder(int numberShares, int pricePerShare) {
        super(numberShares, pricePerShare);
    }

    @Override
    public int compareTo(SharesBuyOrder o) {
        return Integer.compare(o.pricePerShare, pricePerShare);
    }
}
