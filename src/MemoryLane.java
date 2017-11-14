import java.util.Random;

public class MemoryLane
{
    private Domino[] board;

    /**
     * Constructs a Memory Lane game with max^2 + max Dominoes.
     *
     *      Example: max <-- 2
     *              [1] [1] [1] [1] [2] [2]
     *              [1] [1] [2] [2] [2] [2]
     *
     *      Example: max <-- 3
     *              [1] [1] [1] [1] [1] [1] [2] [2] [2] [2] [3] [3]
     *              [1] [1] [2] [2] [3] [3] [2] [2] [3] [3] [3] [3]
     *
     * Postcondition: board is random
     *
     * @param max the largest number of pips on the Dominoes
     */
    public MemoryLane(int max)
    {
        Random randy = new Random(4);
        board = new Domino[(max^2 + max) - 1];
        for (int i = 0; i < board.length; i++)
        {
            board[i] = new Domino(randy.nextInt(), randy.nextInt());
        }
    }

    /**
     * Returns true if board contains other
     * Note: elements may be null
     *
     * @param other
     * @return
     */
    private boolean contains(Domino other)
    {
        for (int i = 0; i < board.length; i++)
        {
            if(other.get)
        }
    }

    /**
     * Shuffles board
     * Precondition: board does not contain null elements
     *
     * @return
     */
    private void shuffle()
    {

    }

    /**
     * Reveals the Dominoes at index i and k if they match
     *
     * @param i
     * @param k
     * @return true if the Dominoes at i and k match; false otherwise
     */
    public boolean guess(int i, int k)
    {

    }

    /**
     * Returns a String representation of the Dominoes at the specified indexes
     *      in the following format:
     *
     *          [top] [top] [top]
     *          [bot] [bot] [bot]
     *
     * Precondition: the elements at the specified indexes are not null
     *
     * @param indexes variable arguments; any number of indexes;
     *                indexes if effectively an int[]
     * @return
     */
    public String peek(int... indexes)
    {

    }

    /**
     * @return true if the number of revealed Dominoes is equal to the
     *          length of the board
     */
    public boolean gameOver()
    {

    }

    /**
     * Returns a String representation of the board in the following format:
     *
     *        0     1     2     3     4     5
     *      [top] [   ] [top] [   ] [top] [top]
     *      [bot] [   ] [bot] [   ] [bot] [bot]
     *
     * Note: the top and bottom numbers of an unrevealed Domino are represented with
     *          an empty space
     *
     * @return
     */
    public String toString()
    {
        
    }
}
