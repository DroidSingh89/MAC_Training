package com.example.user.analytics;

import java.util.ArrayList;

/**
 * Created by singh on 10/31/17.
 */

public class test {
    public static void main(String[] args) {

    }

    public ArrayList<String> makeNewList(ArrayList<String> originalList)
    {
        ArrayList<String> newList = new ArrayList<>();

        for(int i=0;i<originalList.size();i++)
        {
            String temp= originalList.get(i);
            originalList.add(i,"");
            if(originalList.contains(temp))
            {
                if(!newList.contains(temp))
                {
                    newList.add(temp);
                }
            }

        }

        return newList;

    }



    public Integer sum (ArrayList<Integer> integerList)
    {
        Integer temp = integerList.get(integerList.size()-1);
        integerList.remove(integerList.size()-1);
        Integer Summation= temp + sum(integerList);
        return Summation;
    }


    public Integer getMostFrequent(ArrayList<Integer> originalList)
    {
        ArrayList<Integer> newList = new ArrayList<>();
        ArrayList<Integer> counts= new ArrayList<>();

        for(int i=0;i<originalList.size();i++)
        {
            Integer temp= originalList.get(i);


            if(!newList.contains(temp))
            {
                newList.add(temp);
                int pos = newList.indexOf(temp);
                counts.set(1, pos);
            }

            else
            {

                int pos = newList.indexOf(temp);
                int tempCount = counts.get(pos);
                counts.set(tempCount+1, pos);

            }




        }

        int highestCount=counts.get(0);
        int highestPos=0;

        for(int x=1;x<counts.size();x++)
        {
            if(counts.get(x)>highestCount)
            {
                highestCount = counts.get(x);
                highestPos = x;
            }
        }



        return newList.get(highestPos);

    }



}
