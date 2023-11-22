package hw6_21000709_hoangtuantu.excercise06;


import hw6_21000709_hoangtuantu.excercise02.MinHeapPriorityQueue;

public class StockExchange {
	MinHeapPriorityQueue<Double, StockOrder> buyOrders;
	MinHeapPriorityQueue<Double, StockOrder> sellOrders;

	public StockExchange() {
		buyOrders = new MinHeapPriorityQueue<>(100);
		sellOrders = new MinHeapPriorityQueue<>(100);
	}

	public void placeOrder(boolean isBuyOrder, double price, int quantity) {
		StockOrder order = new StockOrder(isBuyOrder, price, quantity);

		if (isBuyOrder) {
			buyOrders.insert(price, order);
		} else {
			sellOrders.insert(price, order);
		}

		processOrders();
	}

	private void processOrders() {
		while (!buyOrders.isEmpty() && !sellOrders.isEmpty() && buyOrders.min().getKey() >= sellOrders.min().getKey()) {
			StockOrder buyOrder = buyOrders.removeMin().getValue();
			StockOrder sellOrder = sellOrders.removeMin().getValue();

			int minQuantity = Math.min(buyOrder.quantity, sellOrder.quantity);
			System.out.println("Processed order: " + minQuantity + " shares at price $" + sellOrder.price);

			buyOrder.quantity -= minQuantity;
			sellOrder.quantity -= minQuantity;

			if (buyOrder.quantity > 0) {
				buyOrders.insert(buyOrder.price, buyOrder);
			}

			if (sellOrder.quantity > 0) {
				sellOrders.insert(sellOrder.price, sellOrder);
			}
		}
	}

	public static void main(String[] args) {
		StockExchange stockExchange = new StockExchange();

		// Thêm đơn đặt mua và bán
		stockExchange.placeOrder(true, 50, 100);
		stockExchange.placeOrder(false, 45, 50);
		stockExchange.placeOrder(true, 55, 30);

		// In ra màn hình kết quả xử lý đơn đặt hàng
	}
}