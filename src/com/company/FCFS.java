package com.company;
import java.util.*;

public class FCFS
{
    int head_movements = 0;
    int current_pos;

    ArrayList<Integer> Sequence = new ArrayList<>();

    public FCFS(ArrayList<Integer> queue, int head)
    {
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
