/**
   Computes the average of a set of data values.
*/
public class DataSetGen<T extends Measurable>
{
   private double sum;
   private Measurable maximum;
   private int count;

   /**
      Constructs an empty data set.
   */
   public DataSetGen()
   {
      sum = 0;
      count = 0;
      maximum = null;
   }

   /**
      Adds a data value to the data set.
      @param x a data value
   */
   public <x extends Measurable> void add(T x)
   {
      sum = sum + x.getMeasure();
      if (count == 0 || maximum.getMeasure() < x.getMeasure())
         maximum = x;
      count++;
   }

   /**
      Gets the average of the added data.
      @return the average or 0 if no data has been added
   */
   public <T> double getAverage()
   {
	  double scale = Math.pow(10, 3);
      if (count == 0) return 0;
      
      else return Math.round((sum / count) * scale)/scale;
   }

   /**
      Gets the largest of the added data.
 * @return 
      @return the maximum or 0 if no data has been added
   */
   public <T> T getMaximum()
   {
      return (T) maximum;
   }
}