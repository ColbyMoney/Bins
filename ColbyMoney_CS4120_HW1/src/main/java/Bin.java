import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Bin {
    //static ArrayList<Bin> bins; //each bin
    ArrayList<Double> objects; //items in an individual bin
    static double items[];   //initial input
    double maxWeight;   //max bin weight
    double totalWeight; //total weight in a bin
    static Scanner input;
    static String toReturn;

    public Bin() //default bin constructor
    {
        objects = new ArrayList<Double>();
        maxWeight = 10.0;
        totalWeight = 0;
    }

    public Bin(double maxWeight) //custom max weight constructor
    {
        objects = new ArrayList<Double>();
        this.maxWeight = maxWeight;
        totalWeight = 0;
    }

    public double getTotalWeight()
    {
        return this.totalWeight;
    }

    public static void main(String[] args)
    {
        input = new Scanner(System.in);
        ArrayList<Bin> bins = new ArrayList<Bin>();
        toReturn = "";

        System.out.println("Enter the number of objects: ");
        double items[] = new double[(input.nextInt())];

        System.out.println("\nEnter the weights of the objects: ");
        for (int i = 0; i < items.length; i++)
            items[i] = input.nextDouble();
        Arrays.sort(items);

        for (int i = items.length - 1; i >= 0; i--)
        {
            //testToString(bins);
            for (int j = 0; j <= bins.size(); j++)
            {
                //testToString(bins);
                if (j == bins.size())
                {
                    bins.add(j, new Bin());
                    bins.get(j).objects.add(items[i]);
                    bins.get(j).totalWeight += items[i];
                    break;
                }
                else if (bins.get(j).addItem(items[i]))
                {
                    bins.get(j).objects.add(items[i]);
                    bins.get(j).totalWeight += items[i];
                    break;
                }
            }
        }

        //build the toString string
        for (int k = 0; k < bins.size(); k++) {
            toReturn = toReturn + "Container " + (k + 1) + " contains objects with weight ";
            for (int i = 0; i < bins.get(k).objects.size(); i++) {
                toReturn = toReturn + bins.get(k).objects.get(i) + " ";
            }
            toReturn = toReturn + "\n\n";
        }
        //testToString(bins);
        System.out.println(bins.toString());
    }

    public boolean addItem(double weight)
    {
        return (totalWeight + weight <= maxWeight);
    }

    public int getNumberOfObjects()
    {
        return this.objects.size();
    }


    public static void testToString(ArrayList<Bin> bins)
    {
        for (int k = 0; k < bins.size(); k++) {
            System.out.print("Container " + (k + 1) + " contains objects with weight ");
            for (int i = 0; i < bins.get(k).objects.size(); i++) {
                System.out.print(bins.get(k).objects.get(i) + " ");
            }
            System.out.println("\n");
        }

        /*
        toReturn = "";
        for (int k = 0; k < bins.size(); k++) {
            toReturn = toReturn + "Container " + (k + 1) + " contains objects with weight ";
            for (int i = 0; i < bins.get(k).objects.size(); i++) {
                toReturn = toReturn + bins.get(k).objects.get(i) + " ";
            }
            toReturn = toReturn + "\n";
        }
        */
    }

    @Override
    public String toString()
    {
        return toReturn;
    }
}
