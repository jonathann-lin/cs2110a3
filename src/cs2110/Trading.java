package cs2110;

import java.util.Random;

/**
 * Contains methods for computing the optimal achievable profit of a stock transaction based on its
 * price history in a given time window.
 */
public class Trading {

    /**
     * Represents a stock transaction in which a share is purchased at the `purchaseTime` and sold
     * at the `sellTime`. Requires that `purchaseTime < sellTime`.
     */
    record BuySellTransaction(int purchaseTime, int sellTime) {

    }

    /**
     * Returns the profit earned through the given `BuySellTransaction t` for the given `prices`
     * array.
     */
    static int profit(int[] prices, BuySellTransaction t) {
        return prices[t.sellTime()] - prices[t.purchaseTime];
    }

    /**
     * Returns the *index* of the maximum value in `prices(i..]`. Requires that `0 <= i <
     * prices.length-1`.
     */
    static int argmaxTail(int[] prices, int i) {
        //defensive programming
        assert prices != null;
        assert i >= 0 && i < prices.length - 1;
        /*
        Loop invariant:
        max = index of max value in the range [i+1,k)
         */
        int max = i + 1;
        for (int k = i + 2; k < prices.length; k++) {
            if (prices[k] > prices[max]) {
                max = k;
            }
        }
        return max;
    }

    /**
     * Returns a BuySellTransaction with the maximum achievable profit for the given `prices`
     * window.
     */
    static BuySellTransaction optimalTransaction1(int[] prices) {

        BuySellTransaction opt = new BuySellTransaction(0, 1);

        /*
         * Loop invariant: opt references a `Transaction` among all those with `purchaseTime` in
         * `[0..i)` with the maximum achievable profit.
         */
        int i = 0;
        while (i < prices.length - 1) {
            BuySellTransaction comparison = new BuySellTransaction(i, argmaxTail(prices, i));
            if (profit(prices, comparison) > profit(prices, opt)) {
                opt = comparison;
            }
            i++;
        }

        return opt;
    }

    /**
     * Returns a BuySellTransaction with the maximum achievable profit for the given `prices`
     * window.
     */
    static BuySellTransaction optimalTransaction2(int[] prices) {
        // TODO 5: Implement this method according to its specifications. For each time `i` in
        //  `[1..prices.length-1]`, you should compute the `BuySellTransaction` with `sellTime == i`
        //  with the maximum achievable profit. Be sure to document the invariants of any loop(s)
        //  you write. Your implementation should have worst-case runtime complexity O(N), where
        //  N=prices.length, and worst-case space complexity O(1).

        BuySellTransaction best = new BuySellTransaction(0, 1);
        int minPrice = 0; //records index of lowest price seen so far
        //TODO do loop invariant
        for (int i = 1; i < prices.length; i++) {
            BuySellTransaction test = new BuySellTransaction(minPrice, i);
            if (profit(prices, test) > profit(prices, best)) {
                best = test; //update best to be the current transaction being checked
            }

            //Updates minPrice if current price is lowest
            if (prices[i] < prices[minPrice]) {
                minPrice = i;
            }
        }
        return best;

    }

}
