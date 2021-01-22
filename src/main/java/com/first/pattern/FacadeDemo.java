package com.first.pattern;

public class FacadeDemo {
}

// billing Interface
// shipping Interface
// GST interface
// Return Expenses Interface
// Coupon or Offer Deduction

interface BillingAmountCalculator{

    public double getBillingAmount(long productId, String location);

}