package com.example.demo.archive.oa;

import java.util.*;

class  Pair12{
    int first, second;

    public Pair12(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class IMC12 {

   public static void moveVenueCar(Queue<Pair12> venue, Integer lastSecond, Integer lastCar, List<Integer> res)
    {

//        res[venue.front().first - 1] = venue.front().second;
        res.add(venue.peek().first - 1, venue.peek().second);
        lastSecond = venue.peek().second;
        lastCar = 1;
        venue.remove();
    }

    public static void moveMainCar(Queue<Pair12> main, int lastSecond, int lastCar, List<Integer> res)
    {
//        res[main.front().first - 1] = main.front().second;
        res.add(main.peek().first - 1, main.peek().second);
        lastSecond = main.peek().second;
        lastCar = 0;
        main.remove();
    }
    public static List<Integer> getResult(List<Integer> arrival, List<Integer> street) {
        Queue<Pair12> main = new LinkedList<>();;
        Queue<Pair12> venue = new LinkedList<>();;

        for (int i = 0; i < street.size(); i++)
        {
            if (street.get(i) == 0)
            {
                if (i != 0 && arrival.get(i) == arrival.get(i-1))
                {
                    main.add(new Pair12(i+1,arrival.get(i) + 1));
                }
                else
                {
                    main.add(new Pair12(i + 1, arrival.get(i)));
                }
            }
            else
            {
                if (i != 0 && arrival.get(i) == arrival.get(i-1))
                {
                    venue.add(new Pair12(i + 1, arrival.get(i) + 1));
                }
                else
                {
                    venue.add(new Pair12(i + 1, arrival.get(i)));
                }
            }
        }

        Integer lastSecond, lastCar = 1;
        if (!venue.isEmpty())
        {
            lastSecond = venue.peek().second -1;
        }
        else
        {
            lastSecond = main.peek().second - 1;
        }
        List<Integer> res = new ArrayList<>(arrival.size());
        while (!main.isEmpty() && !venue.isEmpty())
        {
            int mainCar = main.peek().first, venueCar = venue.peek().first, mainArrival = main.peek().second, venueArrival = venue.peek().second;
            if (mainArrival > venueArrival)
            {
                moveVenueCar(venue, lastSecond, lastCar, res);
            }
            else if (mainArrival < venueArrival)
            {
                moveMainCar(main, lastSecond, lastCar, res);
            }
            else
            {
                if (lastSecond + 1 < mainArrival)
                {
                    moveVenueCar(venue, lastSecond, lastCar, res);
                }
                else
                {
                    if (lastCar == 0)
                    {
                        moveMainCar(main, lastSecond, lastCar, res);
                    }
                    else
                    {
                        moveVenueCar(venue, lastSecond, lastCar, res);
                    }
                }
            }
        }

        while (!venue.isEmpty())
        {
            moveVenueCar(venue, lastSecond, lastCar, res);
        }

        while (!main.isEmpty())
        {
            moveMainCar(main, lastSecond, lastCar, res);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> arrival = Arrays.asList(0,0,1,4);
        List<Integer> street = Arrays.asList(0,1,1,0);
        List<Integer> res = getResult(arrival, street);
       res.forEach(x -> System.out.println(x));
    }
}
