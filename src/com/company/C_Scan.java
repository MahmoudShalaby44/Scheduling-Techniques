package com.company;
import java.util.Collections;
import java.util.ArrayList;

public class C_Scan {
    int seekTime = 0;
    ArrayList<Integer> Visited = new ArrayList<>();

    C_Scan(ArrayList<Integer> Queue, int trackSize, int head, int previous)
    {
        ArrayList<Integer> temp = new ArrayList(Queue);
        temp.add(head);
        Collections.sort(temp);
        int ind = temp.indexOf(head);

        if (previous < head)
        {
            for (int i = ind; i < temp.size(); i++)
            {
                Visited.add(temp.get(i));
            }

            Visited.add(trackSize - 1);
            Visited.add(0);

            for(int i = 0; i < ind; i++)
            {
                Visited.add(temp.get(i));
            }

            for (int i = 0; i < Visited.size() - 1; i++)
            {
                seekTime += Math.abs(Visited.get(i) - Visited.get(i+1));
            }
        }

        else
        {
            for (int i = ind; i >= 0; i--)
            {
                Visited.add(temp.get(i));
            }

            Visited.add(0);
            Visited.add(trackSize - 1);

            for(int i = temp.size() - 1; i > ind; i--)
            {
                Visited.add(temp.get(i));
            }

            for (int i = 0; i < Visited.size() - 1; i++)
            {
                seekTime += Math.abs(Visited.get(i) - Visited.get(i+1));
            }
        }
    }

    ArrayList<Integer> getSequence()
    {
        return Visited;
    }

    int getTotalHedMovement()
    {
        return seekTime;
    }
}
