import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;


public class AG {

private  ArrayList<Mochila> mochilas;
private int[] valores ={30,14,16,9,11,15};
private int[] pesos =  {8,3,4,2,1,5};
private int peso;
private int pos_inicial_mutacao=0;
private float tx_mutacao=0.30f;
private float tx_cros=0.70f;
private int p;  
private Random gerador;
private int Spesos;
private int Svalores;
private int temp;

/*
public static void main(String[] args){
AG ag= new AG(6);	
int i,j;
	for(i=0;i<6;i++){
		System.out.println("valores: "+ag.valores[i]);
		System.out.println("pesos: "+ ag.pesos[i]);
	}
	System.out.println("peso max: "+ ag.peso);
	for(i=0;i<10;i++){
	System.out.println("primeiro valor: "+ ag.mochilas.get(i).getvalor());
	System.out.println("primeiro peso: " + ag.mochilas.get(i).getpeso());
	}
	System.out.println("terminando acima");
	ag.fFitnes(6);
	//System.out.println();
	System.out.println("peso max: "+ ag.peso);
	for(i=0;i<ag.mochilas.size();i++){
		for(j=0;j<ag.mochilas.get(i).getobjetos().length;j++)
	System.out.println("primeiro objeto: "+ ag.mochilas.get(i).getobjetos()[j]);
	
		//for(i=0;i<ag.mochilas.size();i++)
	System.out.println("primeiro peso: " + ag.mochilas.get(i).getpeso());
	System.out.println("primeiro valor: " + ag.mochilas.get(i).getvalor());
	}//System.out.println(ag.mochilas.get(0).getobjetos()[i]);
	
}

*/

public AG(int n,int[] valores,int[] pesos,int p,int peso){
int i;
	this.p=p;
	mochilas = new ArrayList<Mochila>(p);
	gerador = new Random();
	this.valores=valores;
	this.peso=peso;
	this.pesos=pesos;
	//this.p=p;
	this.Spesos=0;
	this.Svalores=0;
	this.temp=0;
	//System.out.println("valor p "+ this.p);
	//valores= new int[n];
	//pesos = new int[n];
	//valores= ;
	//pesos ;
	
	/*	
	for(i=0;i<n;i++){
		valores[i]=gerador.nextInt(20);
		pesos[i]=gerador.nextInt(20);
	} */
	//peso = gerador.nextInt(10);
	//peso =10;
	
	for (i=0;i<p;i++){
		mochilas.add(new Mochila(n,valores,pesos));			
		//this.Spesos=this.Spesos+mochilas.get(i).getpeso();
		
	}
	for(i=0;i<valores.length;i++)
		this.Svalores=this.Svalores+valores[i];
	//this.Svalores=this.Svalores+mochilas.get(i).getvalor();
	System.out.println("soma dos valor: "+ this.Svalores);
	//System.out.println("pesos: "+ this.Spesos);
	
}

/*
public void crossover(int n,Mochila mochila1 ,Mochila mochila2){
Random	gerador = new Random();
int i;
String[] objetos2,objetos1;
int indicie_mudar= gerador.nextInt(n);
objetos2=mochila2.getobjetos();
objetos1=mochila1.getobjetos();
	for(i=indicie_mudar;i<n;i++){
		mochila1.colocarO(objetos2[i], i,valores,pesos);
		mochila2.colocarO(objetos1[i], i,valores,pesos);
	}

}
 */


public boolean fFitnes(int n){
	int i,a=0,b,a_partir;
	//int temp=0;
	ArrayList<Mochila> auxC,auxM;
	auxC = new ArrayList<Mochila>(mochilas.size());
	auxM = new ArrayList<Mochila>(mochilas.size());
	
	//System.out.println("tamanho da mochila aqui ff:"+ mochilas.size());
	/*for(i=0;i<mochilas.size();i++)
		for(int j=0;j<mochilas.get(i).getobjetos().length;j++)
			System.out.print(":"+ mochilas.get(i).getobjetos()[j]);
		*/
		for(i=0;i<mochilas.size();i++)
			if(mochilas.get(i).getvalor()*mochilas.get(i).getpeso()/this.peso <= mochilas.get(i).getvalor()){
				mochilas.get(i).setUnit(mochilas.get(i).getvalor());
				auxC.add(mochilas.get(i));	
			}else{
				mochilas.get(i).setUnit(-1);
				auxM.add(mochilas.get(i));				
			}	
		//mostrar();
		//System.out.println("mochila5: "+ auxM.size());
		//System.out.println("mochila6: "+ auxC.size());
		//for(i=0;i<auxC.size();i++)
			//System.out.println(" veja: "+ auxC.get(i).getobjetos()[0]);
		mochilas.clear();
		//System.out.println("e:"+ mochilas.size());
		//pos_inicial_mutacao=auxC.size();
		//for(i=0;i<auxC.size();i++)
			//mochilas.add(auxC.get(i));
		//System.out.println("mochila4: "+ auxC.size());
		//System.out.println("mochila3: "+ mochilas.size());
		//auxC.clear();
		//System.out.println("auxC "+ auxC.size());
		//System.out.println("tam antes do cros "+ mochilas.size());
		if(auxC.size()!=0){
		for(i=0;i<p*tx_cros/2;i++){
			a=gerador.nextInt(auxC.size()); //confirmar se é ate auxC
			b=gerador.nextInt(auxC.size()); // tmb
			a_partir=gerador.nextInt(n);
			//System.out.println();
			//System.out.println("a_apartir "+ a_partir);
			mochilas.add(auxC.get(a).crossover(a_partir, auxC.get(b), n, valores, pesos));
			mochilas.add(auxC.get(b).crossover(a_partir, auxC.get(a), n, valores, pesos));
		}
		}else{
			System.out.println("não terminou");
			return false;
			/*
			for(i=0;i<p*tx_cros;i++){
				a=gerador.nextInt(auxM.size()); //confirmar se é ate auxC
				a_partir=gerador.nextInt(n);
				mochilas.add(auxM.get(a).mutacao(n, a_partir, pesos, valores));
			}*/
}
			
		//System.out.println("depois antes do cros "+ mochilas.size());
			/*for(i=0;i<p*tx_cros/2;i++){
			a=gerador.nextInt(auxM.size()); //confirmar se é ate auxC
			b=gerador.nextInt(auxM.size()); // tmb
			a_partir=gerador.nextInt(n);
			//System.out.println();
			//System.out.println("a_apartir "+ a_partir);
			mochilas.add(auxM.get(a).crossover(a_partir, auxM.get(b), n, valores, pesos));
			mochilas.add(auxM.get(b).crossover(a_partir, auxM.get(a), n, valores, pesos));
		}*/
		
		
		//for(i=0;i<auxM.size();i++)
		//	auxC.add(auxM.get(i));
		//System.out.println("valor de mochila aqui2: " + mochilas.size());
		if(auxC.size()!=0){
		for(i=0;i<p*tx_mutacao;i++){
			a=gerador.nextInt(auxC.size()); //confirmar se é ate auxC
			a_partir=gerador.nextInt(n);
			mochilas.add(auxC.get(a).mutacao(n, a_partir, pesos, valores,peso));
		}	//tx_mutacao=(pos_inicial_mutacao+1-mochilas.size())/mochilas.size();
		
		}else{
			System.out.println("nao terminou");
			return false;
			/*
			for(i=0;i<p*tx_mutacao;i++){
				a=gerador.nextInt(auxM.size()); //confirmar se é ate auxC
				a_partir=gerador.nextInt(n);
				mochilas.add(auxM.get(a).mutacao(n, a_partir, pesos, valores));
		}
		 */
		}
			//tx_cros=(pos_inicial_mutacao)/mochilas.size();
		//if(tx_cros > tx_mutacao)
		//	return true;
		//return false;
		auxC.clear();
		auxM.clear();
		//for(i=0;i<mochilas.size();i++)
			//System.out.println("valor antes de ordenar :"+mochilas.get(i).getUnit() );
		
		//OrdenaInsercao(mochilas);
		//System.out.println("tamanho aqui"+ mochilas.size());
		//for(i=0;i<mochilas.size();i++)
			//if(mochilas.get(i).getvalor()*mochilas.get(i).getpeso()/peso <= mochilas.get(i).getvalor()){
			//	mochilas.get(i).setUnit(mochilas.get(i).getvalor()*mochilas.get(i).getpeso()/peso);
			//	auxC.add(mochilas.get(i));	
			//}else{
			//	mochilas.get(i).setUnit(-1);
			//	auxM.add(mochilas.get(i));				
			//}	
	
		for(i=0;i<mochilas.size();i++)
			if(mochilas.get(i).getvalor()*mochilas.get(i).getpeso()/this.peso <= mochilas.get(i).getvalor()){
				mochilas.get(i).setUnit(mochilas.get(i).getvalor());
				//mochilas.add(mochilas.get(i));	
			}else{
				mochilas.get(i).setUnit(-1);
				//mochilas.add(mochilas.get(i));				
			}
		//System.out.println("tamanho antes da ordenacao: "+ mochilas.size()); 
		Comparator crescente = new ComparadorMochilas();
		Collections.sort(mochilas, crescente);
		//System.out.println("depois da nova ordenação"); 
		//mostrar();
	//	System.out.println("va depois: "+mochilas.size());
	//	System.out.println("vetor de pesos");
	/*
		for(i=0;i<this.pesos.length;i++)
			System.out.println("objeto:"+i+"pesa:"+this.pesos[i]);
		for(i=0;i<this.valores.length;i++)
			System.out.println("valor do objeto na :"+i+"valor:"+this.valores[i]);
		 */
	//	System.out.println("mostrando os bits do ultimo vetor de mochilas");
		//for(i=0;i<mochilas.get(mochilas.size()-1).getobjetos().length;i++)
		//	System.out.print(":"+mochilas.get(mochilas.size()-1).getobjetos()[i]);
		//if(!OrdenaInsercao(mochilas))
		//return true;
		//else
		/*
		temp++;
		if(temp>=100000)	
			return false;
		else
			return true; */
		int j=0;
		
		int d = (int)(0.10*p)-1;
		
	//	System.out.println("valor de d:"+ d);
		int v= mochilas.get(mochilas.size()-1).getvalor();
		i=(int)((mochilas.size())-d);
		//System.out.println("i:" + i );
		for(;i<mochilas.size();i++)
			if(v==mochilas.get(i).getvalor()&&(mochilas.get(i).getUnit()!=0)) 
				j++;
		if(j>=d) {// tem mais de 10% iguais;
			System.out.println("melhor valor de AG ="+ mochilas.get(mochilas.size()-1).getvalor());
			System.out.println("melhor peso de AG="+ mochilas.get(mochilas.size()-1).getpeso());
			return false;
		}else
			return true;
		
		}	

private boolean ordenar(ArrayList<Mochila> moc){
	int maior=0;
	int posi=0;
	int i,t=0;
	Integer x;
	Mochila aux1=null,aux2=null;
	boolean vez=false;
	while(vez==false){
		for(i=t;i<moc.size();i++)			
			if(maior < moc.get(i).getUnit()){
				
			}
		System.out.println("valor melhor"+ moc.get(posi).getUnit());
		//Collections.sort(moc);
		//moc.remove(posi);
		//moc.remove(t);
		aux1=moc.get(t);
		aux2=moc.get(posi);
		//moc.get(posi).setobjetos(aux1.getobjetos());
		//moc.get(posi).setpeso(aux1.getpeso());
		//moc.get(posi).setUnit(aux1.getUnit());
		//moc.get(posi).setvalor(aux1.getvalor());
		/*
		moc.get(t).setobjetos(aux2.getobjetos());
		moc.get(t).setpeso(aux2.getpeso());
		moc.get(t).setUnit(aux2.getUnit());
		moc.get(t).setvalor(aux2.getvalor());
		//moc.set(posi, aux1); */
		t++;	
		//System.out.println("valor melhor 2: "+ moc.get(t-1).getUnit());
		
		if(t>=moc.size())
			vez=true;
		else{
			posi=t;
			maior= moc.get(t).getUnit();
		}
			
		
	
	}	//tem q terminar
	int h = (int)0.10*p;
	int j=0;
	int v= moc.get(0).getvalor();
	for(i=0;i<h;i++)
		if(v==moc.get(i).getvalor()&&(moc.get(i).getUnit()!=0))
			j++;
	if(j==h) // tem mais de 10% iguais;
		return false;
	else
		return true;

}


public boolean OrdenaInsercao(ArrayList<Mochila> moc) {
	 Mochila num,aux=null;
	  ArrayList<Mochila> guia;
	  
	 int posi=0;
	 System.out.println("tamanho moc:"+ moc.size());  
	 System.out.println("antes de ordenar");
	 mostrar();
	 for(int i=0; i < moc.size(); i++) {
	      num = moc.get(i);
	      for(int j = moc.size()-1; (j >i); j--) {
	         if(moc.get(j).getUnit() > num.getUnit()){
		    	aux= new Mochila(moc.get(j),1);
	        	//System.out.println("aux: " +aux.getUnit());
	        	//System.out.println("moc: " +moc.get(j).getUnit());
		    	/*
	        	 moc.get(j+1).setobjetos(moc.get(j).getobjetos());
		         moc.get(j+1).setpeso(moc.get(j).getpeso());
		         moc.get(j+1).setvalor(moc.get(j).getvalor());
		         moc.get(j+1).setUnit(moc.get(j).getUnit());        
		         moc.get(j).setobjetos(num.getobjetos());
		         moc.get(j).setpeso(num.getpeso());
		         moc.get(j).setvalor(num.getvalor());
		         moc.get(j).setUnit(num.getUnit());
		         moc.get(j).setUnit(num.getUnit()) ; */
		         //num= moc.get(j);
	        	 posi=j;
	         }
	         
	      }
	      if(aux!=null){
		         moc.get(posi).setobjetos(moc.get(i).getobjetos());
		         moc.get(posi).setpeso(moc.get(i).getpeso());
		         moc.get(posi).setvalor(moc.get(i).getvalor());
		         moc.get(posi).setUnit(moc.get(i).getUnit());        
		         moc.get(i).setobjetos(aux.getobjetos());
		         moc.get(i).setpeso(aux.getpeso());
		         moc.get(i).setvalor(aux.getvalor());
		         moc.get(i).setUnit(aux.getUnit());
		         //moc.get(i).setUnit(aux.getUnit()) ;
		     }
	 }
	 System.out.println("mostrar depois de ordenar");
	 mostrar();
	   int h = (int)(0.10f*p);
		System.out.println("valor de h"+ h);
	   int i=0;
		int g=0;
	   int v= moc.get(0).getvalor();
		for(i=0;i<h;i++)
			if(v==moc.get(i).getvalor())
				g++;
		System.out.println("valor de g:" + g);
		if(g>=2) // tem mais de 10% iguais;
			return true;
		else
			return false;
		
		//return true;
}




public void mostrar(){
	int i=0;
	System.out.println("peso final "+mochilas.get(0).getpeso());
	for(i=0;i < mochilas.size();i++)
		System.out.println("valor f:" + mochilas.get(i).getUnit()+" valor:"+ mochilas.get(i).getvalor()+ "peso:"+ mochilas.get(i).getpeso());
	
}


}
