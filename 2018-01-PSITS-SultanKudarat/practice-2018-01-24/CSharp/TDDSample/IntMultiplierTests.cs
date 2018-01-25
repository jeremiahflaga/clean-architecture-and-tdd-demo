using System;
using Xunit;

namespace TDDSample
{
    public class IntMultiplierTests
    {
        [Theory]
        [InlineData(1)]
        [InlineData(2)]
        [InlineData(3)]
        [InlineData(12345)]
        public void multiplyByOne(int multiplicand)
        {
            int result = IntMultiplier.multiply(multiplicand, 1);
            Assert.Equal(result, multiplicand);
        } 

        [Theory]
        [InlineData(1)]
        [InlineData(2)]
        [InlineData(3)]
        [InlineData(12345)]
        public void multiplyByTwo(int multiplicand)
        {
            int result = IntMultiplier.multiply(multiplicand, 2);
            Assert.Equal(result, multiplicand + multiplicand);
        } 

        [Theory]
        [InlineData(1)]
        [InlineData(2)]
        [InlineData(3)]
        [InlineData(12345)]
        public void multiplyByThree(int multiplicand)
        {
            int result = IntMultiplier.multiply(multiplicand, 3);
            Assert.Equal(result, multiplicand + multiplicand + multiplicand);
        } 
        
        [Theory]
        [InlineData(1)]
        [InlineData(2)]
        [InlineData(3)]
        [InlineData(12345)]
        public void multiplyByFour(int multiplicand)
        {
            int result = IntMultiplier.multiply(multiplicand, 4);
            Assert.Equal(result, multiplicand + multiplicand + multiplicand + multiplicand);
        }
    }
}