package org.dpo.hrr.easy;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {
    public static void main(String[] args) {
        double payment = 1213.23123;

        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        System.out.println("US: " + us);

        Locale indiaLocale = new Locale("en", "IN");
        // Get the currency formatter for India
        String india = NumberFormat.getCurrencyInstance(indiaLocale).format(payment);

        System.out.println("India: " + india);

        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        System.out.println("China: " + china);

        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
        System.out.println("France: " + france);

    }
}
