package com.company;
import java.util.*;

public class OptimizedAlgo
{
    //The idea of this algorithm is that we always assign the initial head position to zero.
    //We then sort the request queue in ascending order.
    //After sorting, the head traverses the cylinders.
    //This is useful because it assures us that the head will always move in one direction and will reduce the head movements.


    int head_movements = 0;
    int current_pos;

    ArrayList<Integer> Sequence = new ArrayList<>();

    public OptimizedAlgo(ArrayList<Integer> queue)
    {
        int head = 0;
        Collections.sort(queue);
        Sequence.add(0,head);
        for(int i = 0; i < queue.size(); i++)
        {
            current_pos = queue.get(i);
            Sequence.add(current_pos);
            head_movements += Math.abs(current_pos - head);
            head = current_pos;

        }
    }

    public ArrayList<Integer> getSequence()
    {
        return Sequence;
    }

    public int getHead_movements()
    {
        return head_movements;
    }
}
