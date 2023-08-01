public class BitVector 
{
    private int size;
    private int[] arr;

    public BitVector(int initialSize) 
    {
        if(initialSize < (Integer.BYTES * 8))
        {
            this.size = (Integer.BYTES * 8)/ (((Integer.BYTES * 8) / initialSize) * initialSize);
        }
        else
        {
            this.size = initialSize / (Integer.BYTES * 8);
        }
        
        this.arr = new int[this.size];
        
    }

    public void set(int index) 
    {                                                                           // 00000000_00000000_00000000_00000000 00000000_00000000_00000000_00000000
        int arrIndex = index / (Integer.BYTES * 8);                             // 00000000_00000000_00000000_00000000 00000000_00000000_00000000_10000010
        //int countforShift = index % (Integer.BYTES * 8);                      // 00000000_00000000_00000000_00000000 00000000_00000000_00000000_10000000
        this.arr[arrIndex] = this.arr[arrIndex] | (1 << index);                 // 00000000_00000000_00000000_00000001
                                                                                // 0_00000000_00000000_10000000
    }                                                                           // 11111111_11111111_11111111_11111110

    public void reset(int index)
    {
        int arrayIndex = index / (Integer.BYTES * 8);
        int countForShift = index % (Integer.BYTES * 8);   
        this.arr[arrayIndex] = this.arr[arrayIndex] & (0B10111111_11111111_11111111_11111111 >> ((Integer.BYTES * 8 - 2) - countForShift)); //01111111_11111111_11111111_11111111
    }

    public boolean get(int index) 
    {
        int arrIndex = index / (Integer.BYTES * 8);
        // countForShift = index;
        int[] tempArr = this.arr;
        boolean result = (((tempArr[arrIndex] >> index) & 1) == 1) ? true : false;
        return result;
    }



    @Override
    public String toString() 
    {
        StringBuilder str = new StringBuilder();
        int countOfLines = 0;
        for (int i = this.size * (Integer.BYTES * 8) - 1; i >= 0; --i) 
        {
            if ((str.length() - countOfLines) % 8 == 0 && str.length() >= 8) 
            {
                str.append('_');
                ++countOfLines;
            }

            if (this.get(i) == true) 
            {
                str.append(1);
            } 
            else 
            {
                str.append(0);
            }

        }
        return str.toString();
    }

}
