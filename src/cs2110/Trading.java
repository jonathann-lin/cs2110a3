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
        // TODO 2: Implement this method according to its specifications. Use a `while` loop
        //  documented with the invariant you visualized in part 1.
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a BuySellTransaction with the maximum achievable profit for the given `prices`
     * window.
     */
    static BuySellTransaction optimalTransaction1(int[] prices) {
        // TODO 3: Implement this method according to its specifications. Uncomment and fill in the
        //  definition of this `while` loop so that it has the given loop invariant. The body of
        //  this loop should call `argMaxTail()` in each iteration.
        BuySellTransaction opt;

        /*
         * Loop invariant: opt references a `Transaction` among all those with `purchaseTime` in
         * `[0..i)` with the maximum achievable profit.
         */
        // while () {
        //
        // }

        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }

}
