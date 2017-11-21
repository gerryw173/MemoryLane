public class Domino
{
    private int top, bottom;
    private boolean revealed;

    /**
     * Constructs an unrevealed Domino from x and y.
     *      The minimum of x and y is top number.
     *      The maximum of x and y is the bottom number.
     * @param x
     * @param y
     */
    public Domino(int x, int y)
    {
        if(x < y) // makes sure the lowest value is top
        {
            top = x;
            bottom = y;
        }

        else // if x is more than y or if the two values are equal
        {
            top = y;
            bottom = x;
        }

        revealed = false;
    }

    /**
     * @return top
     */
    public int getTop()
    {
        return top;
    }

    /**
     * @return bottom
     */
    public int getBottom()
    {
        return bottom;
    }

    /**
     * @return revealed
     */
    public boolean isRevealed()
    {
        return revealed;
    }

    /**
     * Sets revealed to the specified value
     * @param revealed
     */
    public void setRevealed(boolean revealed)
    {
        this.revealed = revealed;
    }

    /**
     * Returns true if this Domino has the same top and bottom as other
     * @param other
     * @return
     */
    public boolean equals(Domino other)
    {
        if(top == other.getTop() && bottom == other.getBottom())
        {
            return true;
        }

        return false;
    }

    public String dominoToString()
    {
        String one = "[" + top + "]"; // string that holds all the tops
        String two = "[" + bottom + "]"; // string that holds all the bottoms

        return one + "\n" + two;
    }
}
