package com.company;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    //98 183 37 122 14 124 65 67 done

    static ArrayList<Integer> Queue = new ArrayList<>();
    static ArrayList<Integer> Visited = new ArrayList<>();
    static int head;
    static int size;
    static int previous;

    /*static int Scan()
    {
        Scanner input = new Scanner(System.in);
        int seekTime = 0;
        Collections.sort(Queue);
        int ind = Queue.indexOf(head);

        System.out.println("Scan:");

        if (previous < head)
        {
            for (int i = ind; i < Queue.size(); i++)
            {
                Visited.add(Queue.get(i));
            }

            for(int i = ind-1; i > 0; i--)
            {
                Visited.add(Queue.get(i));
            }

            for (int i = 0; i < Visited.size() - 1; i++)
            {
                System.out.print(Visited.get(i) + " -> ");
                seekTime += Math.abs(Visited.get(i) - Visited.get(i+1));
            }
            System.out.print(Visited.get(Visited.size() -1 ));
        }

        else
        {
            for (int i = ind; i >= 0; i--)
            {
                Visited.add(Queue.get(i));
            }

            for(int i = ind+1; i < Queue.size()-1; i++)
            {
                Visited.add(Queue.get(i));
            }

            for (int i = 0; i < Visited.size() - 1; i++)
            {
                System.out.print(Visited.get(i) + " -> ");
                seekTime += Math.abs(Visited.get(i) - Visited.get(i+1));
            }
            System.out.print(Visited.get(Visited.size() -1 ));
        }

        System.out.println();
        Visited.removeAll(Visited);
        System.out.println("Seek time is: " + seekTime + " cylinders.");
        return seekTime;
    }*/

    /*static int C_Scan()
    {
        Scanner input = new Scanner(System.in);
        int seekTime = 0;
        Collections.sort(Queue);
        int ind = Queue.indexOf(head);

        System.out.println("C-Scan:");

        if (previous < head)
        {
            for (int i = ind; i < Queue.size(); i++)
            {
                Visited.add(Queue.get(i));
            }

            for(int i = 0; i < ind; i++)
            {
                Visited.add(Queue.get(i));
            }

            for (int i = 0; i < Visited.size() - 1; i++)
            {
                System.out.print(Visited.get(i) + " -> ");
                seekTime += Math.abs(Visited.get(i) - Visited.get(i+1));
            }
            System.out.print(Visited.get(Visited.size() -1 ));
        }

        else
        {
            for (int i = ind; i >= 0; i--)
            {
                Visited.add(Queue.get(i));
            }

            for(int i = Queue.size() - 1; i > ind; i--)
            {
                Visited.add(Queue.get(i));
            }

            for (int i = 0; i < Visited.size() - 1; i++)
            {
                System.out.print(Visited.get(i) + " -> ");
                seekTime += Math.abs(Visited.get(i) - Visited.get(i+1));
            }
            System.out.print(Visited.get(Visited.size() -1 ));
        }

        System.out.println();
        Visited.removeAll(Visited);
        System.out.println("Seek time is: " + seekTime + " cylinders.");
        return seekTime;
    }*/

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of sectors.");
        size = input.nextInt();
        //Queue.add(0);
        //Queue.add(size-1);

        System.out.println("Enter the position of the head.");
        head = input.nextInt();
        //Queue.add(head);

        System.out.println("enter the request queue.");

        while(true)
        {
            String in = input.next();

            if (in.equals("done"))
            {
                break;
            }

            else
            {
                int n = Integer.parseInt(in);
                Queue.add(n);
            }

        }

        System.out.println("Enter the position of the previous cylinder.");
        previous = input.nextInt();

        ArrayList<Integer> algorithms = new ArrayList<>();
        //System.out.println(Queue);

        FCFS first = new FCFS(Queue,head);
        System.out.println(first.getSequence());
        System.out.println("total head movement is: " + first.getHead_movements());

        Scan scan = new Scan(Queue,size,head,previous);
        System.out.println(scan.getSequence());
        System.out.println("total head movement is: " + scan.getTotalHedMovement());

        C_Scan c_scan = new C_Scan(Queue,size,head,previous);
        System.out.println(c_scan.getSequence());
        System.out.println("total head movement is: " + c_scan.getTotalHedMovement());

        Look look = new Look(Queue,head,previous);
        System.out.println(look.getSequence());
        System.out.println("total head movement is: " + look.getHead_movements());

        C_Look c_look = new C_Look(Queue,head,previous);
        System.out.println(c_look.getSequence());
        System.out.println("total head movement is: " + c_look.getHead_movements());

        OptimizedAlgo modified = new OptimizedAlgo(Queue);
        System.out.println(modified.getSequence());
        System.out.println("total head movement is: " + modified.getHead_movements());
    }
}
