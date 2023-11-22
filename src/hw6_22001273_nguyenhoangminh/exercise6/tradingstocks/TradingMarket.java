package hw6_22001273_nguyenhoangminh.exercise6.tradingstocks;

import hw6_22001273_nguyenhoangminh.exercise2.MinHeapPriorityQueue;

public class TradingMarket {
    private MinHeapPriorityQueue<Double, Integer> sellOrder;
    private MinHeapPriorityQueue<Double, Integer> buyOrder;

    public TradingMarket(int capacity) {
        sellOrder = new MinHeapPriorityQueue<>(capacity);
        buyOrder = new MinHeapPriorityQueue<>(capacity);
    }

    public TradingMarket() {
        sellOrder = new MinHeapPriorityQueue<>(1000);
        buyOrder = new MinHeapPriorityQueue<>(1000);
    }

    public void createSellOrder(double price, int sellQuantity) {
        sellOrder.insert(price, sellQuantity);
    }

    public void createBuyOrder(double price, int buyQuantity) {
        buyOrder.insert(price, buyQuantity);
    }

    public void revalidate() {
        if (sellOrder.isEmpty() || buyOrder.isEmpty()) {
            System.out.println("No change");
            return;
        }
        Double sellPrice = sellOrder.min().getKey();
        Double buyPrice = buyOrder.max().getKey();

        Integer sellQuantity = sellOrder.min().getValue();
        Integer buyQuantity = buyOrder.max().getValue();

        if (sellPrice.compareTo(buyPrice) <= 0) {
            if (sellQuantity.compareTo(buyQuantity) > 0) {
                sellOrder.min().setValue(sellQuantity - buyQuantity);
                buyOrder.removeMax();
                System.out.print("Newest change: ");
                System.out.print("Sold: " + buyQuantity + " stocks of " + sellPrice + "         ");
                System.out.println("Current min price/number of stocks: " + sellPrice + " / " + (sellQuantity - buyQuantity));

                revalidate();

            } else if (sellQuantity.compareTo(buyQuantity) == 0) {
                sellOrder.removeMin();
                buyOrder.removeMax();
                System.out.print("Newest change: ");
                System.out.print("Sold: " + buyQuantity + " stocks of " + sellPrice + "         ");
                System.out.println("Current min price/number of stocks: " + sellOrder.min().getKey() + " / " +
                        sellOrder.min().getValue());
            } else {
                sellOrder.removeMin();
                buyOrder.max().setValue(buyQuantity - sellQuantity);
                System.out.print("Newest change: ");
                System.out.print("Sold: " + sellQuantity + " stocks of " + sellPrice + "        ");
                System.out.println("Current min price/number of stocks: " + sellOrder.min().getKey()
                        + " stocks of " + sellOrder.min().getValue());
            }
        } else {
            System.out.println("No change.");
            System.out.println("Current min price/number of stocks: " + sellOrder.min().getKey() + " / " +
                    sellOrder.min().getValue());
        }
    }
}
