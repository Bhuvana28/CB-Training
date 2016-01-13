import java.text.DecimalFormat;

public class RoundValue 
{
    public static void main(String[] args)
    {	
			
	Integer kilobytes = 1205;
	
	System.out.println("kilobytes : " + kilobytes);
	
	double newKB = Math.round(kilobytes*100.0)/100.0;
	System.out.println("kilobytes (Math.round) : " + newKB);
		
	DecimalFormat df = new DecimalFormat("###.##");
	System.out.println("kilobytes (DecimalFormat) : " + df.format(kilobytes));
    }
}