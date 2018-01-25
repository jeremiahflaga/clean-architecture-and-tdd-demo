using System;

namespace TDDSample
{
  internal class IntMultiplier
  {
    internal static int multiply(int multiplicand, int multiplier)
    {
      // if (multiplier == 4)
      //   return multiplicand + multiplicand + multiplicand + multiplicand;

      // if (multiplier == 3)
      //   return multiplicand + multiplicand + multiplicand;

      // if (multiplier == 2)
      //   return multiplicand + multiplicand;

      // return multiplicand;

      int sum = 0;
      for (int i = 1; i <= multiplier; i++) {
        sum += multiplicand;
      }

      return sum;
    }
  }
}