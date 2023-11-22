package hw6_21000699_dangngocquan.exercise006.models;

public abstract class SharesOrder {
    public int numberShares;
    public int pricePerShare;

    public SharesOrder(int numberShares, int pricePerShare) {
        this.numberShares = numberShares;
        this.pricePerShare = pricePerShare;
    }

    @Override
    public String toString() {
        return numberShares + " shares with $" + pricePerShare + " per share.";
    }
}
