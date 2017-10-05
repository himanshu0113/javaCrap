import java.util.*;

public class test {
	public ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    int[] sum = new int[a.size()+1];
	    int[] len = new int[a.size()+1];
	    int j = 0, p = -1, max =-1, maxp =-1;
	    ArrayList<Integer> b = new ArrayList<Integer>();

	    for(int i =0; i<a.size(); i++)
	    {
          if(a.get(i)<0) j++;
	        else
	        {sum[j]+=a.get(i); len[j]++;}
	    }

	    for(int z =0; z<=j; z++)
	    {

	        if((sum[z]>max) || (sum[z]==max && len[maxp]<len[z]))
	        { max = sum[z]; maxp = z;System.out.println(sum[z]);}
	    }

      int temp = maxp;
	    for(int z=0; z<a.size(); z++)
	    {
        if(a.get(z) < 0) --temp;
	        if(a.get(z) >=0 && temp == 0)
	        {

	            for(int i=z; i<len[maxp]+z; i++)
	            {b.add(a.get(i));}
              break;
	        }
	    }
	    return b;
	}

  public static void main(String[] args)
  {
    ArrayList<Integer> a =new ArrayList<Integer>();
    a.add(1967513926);
    a.add(1540383426);
    a.add(-1303455736);
    a.add(-521595368);
    //a.add(2);
    //a.add(5);

      test t = new test();
      ArrayList<Integer> b = t.maxset(a);

      System.out.println(b);
  }
}
