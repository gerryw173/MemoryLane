import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;

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
        int length = max * max + max; // length of array
        board = new Domino[length - 1];

        for (int i = 0; i < board.length; i++)
        {
            board[i] = null;
        }

        for (int i = 1; i < max + 1; i++)
        {
            for (int j = 1; j < max + 1; j++)
            {
                Domino kek = new Domino(i, j);
                addObject(kek);
            }
        }

        shuffle();
    }

    /**
     * Adds the domino to the next index that is null
     * @param domino
     * @return true if object is add false if not
     */
    private boolean addObject(Domino domino)
    {
        for (int i = 0; i < board.length - 1; i++)
        {
            if(board[i] == null)
            {
                board[i] = domino;
                board[i + 1] = domino;
                return true;
            }
        }

        return false;
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
            if(board[i].equals(other));
            return true;
        }

        return false;

    }

    /**
     * Shuffles board
     * Precondition: board does not contain null elements
     *
     * @return
     */
    private void shuffle()
    {
        ArrayList<Domino> kek = new ArrayList<Domino>();
        for (int i = 0; i < board.length; i++)
        {
            kek.add(board[i]);
        }

        Collections.shuffle(kek);

        for (int i = 0; i < board.length; i++)
        {
            board[i] = kek.get(i);
        }
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
        if(board[i].equals(board[k]))
        {
            board[i].setRevealed(true);
            board[k].setRevealed(true);
            return true;
        }

        return false;
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
        String str = "";
        for (int i = 0; i < indexes.length; i++)
        {
            int index = indexes[i];
            str += "[" + board[index].getTop() + "]" + "\n" +
                    "[" + board[index].getBottom() + "]" + " ";
        }

        return str;
    }

    /**
     * @return true if the number of revealed Dominoes is equal to the
     *          length of the board
     */
    public boolean gameOver()
    {
        for (int i = 0; i < board.length; i++)
        {
            if(board[i].isRevealed() == false) // if any dominos reveal equals false
            {
                return false;
            }
        }

        return true;
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
        String str = "";

        for (int i = 0; i < board.length; i++)
        {
            if(board[i].isRevealed() == true)
            {
                str += board[i].dominoToString() + " ";
            }

            else
                str += "[ ]" + "\n" + "[ ]";
        }

        return str;
    }
}
