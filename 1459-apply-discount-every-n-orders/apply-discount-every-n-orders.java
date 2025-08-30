class Cashier {
    private int customerNumber;
    private int discountFreq;
    private int discount;
    private Map<Integer, Integer> priceOf;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        customerNumber = 0;
        discountFreq = n;
        this.discount = discount;
        priceOf = new HashMap<>();
        for(int i=0; i<products.length; i++) {
            priceOf.put(products[i], prices[i]);
        }

    }
    
    public double getBill(int[] product, int[] amount) {
        customerNumber = (customerNumber + 1) % discountFreq;
        double totalSum = 0.0;
        for(int i=0; i<product.length; i++) {
            totalSum += priceOf.get(product[i]) * amount[i];
        }
        if(customerNumber == 0) {
            totalSum = (double)totalSum * (100.0 - discount)/100.0;
        }
        return totalSum;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */