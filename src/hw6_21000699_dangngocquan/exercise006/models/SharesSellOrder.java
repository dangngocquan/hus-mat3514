package hw6_21000699_dangngocquan.exercise006.models;

public class SharesSellOrder
        extends SharesOrder
        implements Comparable<SharesSellOrder> {
    public SharesSellOrder(int numberShares, int pricePerShare) {
        super(numberShares, pricePerShare);
    }

    @Override
    public int compareTo(SharesSellOrder o) {
        return Integer.compare(pricePerShare, o.pricePerShare);
    }


}
