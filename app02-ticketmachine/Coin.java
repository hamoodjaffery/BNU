
/**
 * Coin enumerations, accepting 10p, 20p,GBP 1.00 and GBBP 2.00
 *
 * @author Hamood Jaffery
 * @date 19.10.2020
 */
public enum Coin
{
        P10 (10),
        P20 (20),
        P100 (100),
        P200 (200);

        private final int value;

        private Coin(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }
}
