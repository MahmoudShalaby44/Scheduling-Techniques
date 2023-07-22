package com.company;
import java.util.*;

public class C_Look
{
    int head_movements = 0;
    int distance = 0;
    int check_direction;
    int current_pos;


    ArrayList<Integer> Sequence = new ArrayList<Integer>();
    ArrayList<Integer> Left = new ArrayList<Integer>();
    ArrayList<Integer> Right = new ArrayList<Integer>();


    public C_Look(ArrayList<Integer> requests, int head, int prev_pos)
    {
        int initial_head = head;
        check_direction = prev_pos - head;
        for(int j = 0; j < requests.size(); j++)
        {
            if(requests.get(j) > head)
                Right.add(requests.get(j));
            if(requests.get(j) < head)
                Left.add(requests.get(j));
        }
        Collections.sort(Left);
        Collections.sort(Right);

        if(check_direction < 0)
        {
            for(int i = 0; i < Right.size(); i++)
            {
                current_pos = Right.get(i);
                Sequence.add(current_pos);
                distance = Math.abs(current_pos - head);
                head_movements += distance;
                head = current_pos;
            }
            for (int z = 0; z < Left.size(); z++)
            {
                current_pos = Left.get(z);
                Sequence.add(current_pos);
                distance = Math.abs(current_pos - head);
                head_movements += distance;
                head = current_pos;
            }
        }
        else
        {
            Collections.reverse(Left);
            Collections.reverse(Right);
            for (int k = 0; k < Left.size(); k++)
            {
                current_pos = Left.get(k);
                Sequence.add(current_pos);
                distance = Math.abs(current_pos - head);
                head_movements += distance;
                head = current_pos;
            }
            for(int x = 0; x < Right.size(); x++)
            {
                current_pos = Right.get(x);
                Sequence.add(current_pos);
                distance = Math.abs(current_pos - head);
                head_movements += distance;
                head = current_pos;
            }
        }
        Sequence.add(0,initial_head);
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
