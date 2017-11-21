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
        board = new Domino[length];

        int boardcounter = 0; // index of board array

        for (int i = 1; i < max + 1; i++)
        {
            for (int j = i; j < max + 1; j++) // j = i to make sure bottom is either equal or more than top
            {
                Domino kek = new Domino(i, j);
                board[boardcounter] = kek;
                boardcounter++;
                board[boardcounter] = kek;
                boardcounter++;
            }
        }

        shuffle();
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
            if(board[i].equals(other) == true);
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
        if(board[i].equals(board[k]) == true)
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
        String one = "";
        String two = "";
        for (int i = 0; i < indexes.length; i++)
        {
            int index = indexes[i];

            one += "[" + board[index].getTop() + "] ";
            two += "[" + board[index].getBottom() + "] ";
        }

        return one + "\n" + two;

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
       String one = "";
       String two = "";

        for (int i = 0; i < board.length ; i++)
        {
            one += "[" + board[i].getTop() + "] ";
            two += "[" + board[i].getBottom() + "] ";
        }

       return one + "\n" + two;
    }
}
