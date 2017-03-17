package com.example.uberv;


public class StockObserver implements Observer {

    private double ibmPrice, aaplPrice, googPrice;

    private static int observerIDTracker = 0;

    private int observerID;

    private Subject stockGrabber;

    public StockObserver(Subject stockGrabber) {
        this.stockGrabber = stockGrabber;
        this.observerID = ++observerIDTracker;
        System.out.println("New Observer " + this.observerID);
        stockGrabber.register(this);
    }

    @Override
    public void update(double ibmPrice, double aaplPrice, double googPrice) {
        this.ibmPrice = ibmPrice;
        this.aaplPrice = aaplPrice;
        this.googPrice = googPrice;

        printPrices();
    }

    public void printPrices() {
        System.out.printf("%d) ibmPrice: %.2f, aaplPrice: %.2f, googPrice: %.2f\n", observerID, ibmPrice, aaplPrice, googPrice);
    }


}
