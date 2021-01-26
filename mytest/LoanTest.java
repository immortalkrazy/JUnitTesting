package mytest;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class LoanTest {

    @Before
    public void setUp() throws Exception {

    }
    @Test
    public void testPaymentMethods() {
        double annualInterestRate = 2.5;
        int numberOfYears = 5;
        double loanAmount = 1000;

        Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);

        assertTrue(loan.getMonthlyPayment() ==
        getMonthlyPayment(annualInterestRate, numberOfYears, loanAmount));

        assertTrue(loan.getTotalPayment() ==
        getTotalPayment(annualInterestRate, numberOfYears, loanAmount));
    }

    private double getMonthlyPayment(double annualInterestRate, int numberOfYears, double loanAmount) {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
        (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }

    // calculate total payment
    private double getTotalPayment(double annualInterestRate, int numberOfYears, double loanAmount) {
        double totalPayment = getMonthlyPayment(annualInterestRate, numberOfYears, loanAmount) * numberOfYears * 12;
        return totalPayment;
    }



}
