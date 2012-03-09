package kistenjunge.org.dungeorithm.util;

import org.apache.commons.math.random.RandomDataImpl;

public class CalcUtils
{
  private CalcUtils()
  {
  }

  public static int randomEvenNumber(int min, int max)
  {
    int lowerRange = (min + 1) / 2;
    int upperRange = max / 2;
    int size = new RandomDataImpl().nextInt(lowerRange, upperRange);
    size *= 2;
    return size;
  }

  public static int randomOddNumber(int min, int max)
  {
    int nbr;
    RandomDataImpl randomizer = new RandomDataImpl();
    do
    {
      nbr = randomizer.nextInt(min, max);
    }
    while (nbr % 2 == 0);
    return nbr;
  }
}
