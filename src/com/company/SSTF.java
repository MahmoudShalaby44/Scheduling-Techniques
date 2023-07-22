package com.company;

import java.util.*;

public class SSTF {

    private  List<Integer> temp;
    private  List<Integer> difference = new ArrayList<>();;
    private  ArrayList<Integer> Visited= new ArrayList<>();
    private  List<Integer> temp2;
    private int seekTime = 0;


    SSTF(ArrayList<Integer> Queue,int head){

       temp = new ArrayList<>(Queue);

        for (Integer integer : temp) {
            difference.add(Math.abs(integer - head));

        }
      temp2 =  new ArrayList<>(difference);
     Collections.sort(temp2);

      for(int i = 0 ; i < temp.size() ; i++){

          Visited.add(temp.get(difference.indexOf(temp2.get(i))));

      }

      Visited.add(0,head);

        for (int i = 0; i < Visited.size() - 1; i++)
        {
            seekTime += Math.abs(Visited.get(i) - Visited.get(i+1));
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
