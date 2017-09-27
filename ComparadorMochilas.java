import java.util.Comparator;


public class ComparadorMochilas implements Comparator <Mochila> {

	@Override
	public int compare(Mochila o1, Mochila o2) {
		// TODO Auto-generated method stub
		if(o1.getUnit()>o2.getUnit())
			return +1;
		else
			if(o1.getUnit()<o2.getUnit())
				return -1;
		else
			return 0;
				
		
	}


}
