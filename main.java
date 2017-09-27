import java.util.ArrayList;

public class main{

	static  ArrayList<PMochila> Apm;
	static int[] vt = {11,31,101,201,1001};
	
public static void main(String[] args){
	PMochila pm;
	int i;
	int populacao = 200;
	
	//Apm = new ArrayList<PMochila>(5);	
	//for(i=0;i<vt.length;i++){
		Apm = new ArrayList<PMochila>();
			
		//i=4;
		
		Apm.add(new PMochila(vt[4]));
		/*
		for(i=0;i<Apm.get(0).getPesos().length;i++)
			System.out.println("valores:"+ Apm.get(0).getValores()[i]);
		for(i=0;i<Apm.get(0).getPesos().length;i++)
			System.out.println("pesos:"+ Apm.get(0).getPesos()[i]);
		*/
		//for(i=0;i<5;i++)
	//	Apm.get(i).printar();
	// instanciando problema generico
	//System.out.println("problema i =" + i);
	System.out.println("peso max: "+Apm.get(0).peso);
	long  timeinicial = System.currentTimeMillis();
	AG ag = new AG(Apm.get(0).getTm_entrada(),Apm.get(0).getValores(),Apm.get(0).getPesos(),populacao,Apm.get(0).getPeso());
	while(ag.fFitnes(Apm.get(0).getTm_entrada()));	
	//ag.mostrar();
	long timefinal = System.currentTimeMillis();
	 System.out.println("\n tempo de: AG "+ (timefinal-timeinicial));
	 timeinicial = System.currentTimeMillis();
	 pd Pd = new pd(Apm.get(0).getPesos(), Apm.get(0).getValores(), Apm.get(0).getPeso());
	 timefinal = System.currentTimeMillis();
	 System.out.println("Melhor valor de pd: " +Pd.getLucro2());
	 System.out.println("\n tempo de pd: "+ (timefinal-timeinicial));
	 //System.out.println("peso da mochila: " +Pd.getMochila());
	Apm.clear();
	
	}
	
	
	
	
	
//}

}