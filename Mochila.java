import java.util.Random;

public class Mochila  {

	private String[] objetos;
	private int peso;
	private int valor;	
	private int unit;
	
	
	public int getUnit() {
		return unit;
	}



	public void setUnit(int unit) {
		this.unit = unit;
	}



	public Mochila(int n){
		//super();
		this.objetos = new String[n];
		this.peso=this.valor=0;
	}
	
	
	
	public void colocarO(String bit,int pos,int[]valores,int[] pesos){
		if(!objetos[pos].equals(bit)){
			if(bit.equals("1")){
				valor=valor+valores[pos];
				peso=peso+pesos[pos];
			}else{
				valor=valor-valores[pos];
				peso=peso-pesos[pos];
			}	
		}
		this.objetos[pos]=bit;
		
	}
	
	
	
public void colocarC(String[] bit,int pos,int[]valores,int[] pesos, int n){
	int i;	
	//System.out.println("String: " + objetos);	
	for(i=pos;i<n;i++){
		
		if(!this.objetos[i].equals(bit[i])){
			//System.out.println("passsou aqui uma vez");	
				if(bit[i].equals("1")){
					valor=valor+valores[i];
					peso=peso+pesos[i];
					objetos[i]=bit[i];
				}else{
					if((valor!=0)&&(peso!=0)){
					valor=valor-valores[i];
					peso=peso-pesos[i];
					objetos[i]=bit[i];
					}else
						System.out.println("fudeu");
				}	
			}			
	}
	}
	
	
	public void setobjetos(String[] objetos){
		this.objetos=objetos;
	}
	
	public String[] getobjetos(){
		return this.objetos;
	}
	
	
	public Mochila(){
		//super();
	}
	
	public  Mochila(Mochila mochila, int n){
		//Mochila mochila2;
		//this(n);
		//super();
		//System.out.println("pesos aqui:" + this.peso);
		
		int i;
		this.peso=mochila.getpeso();
		this.objetos=mochila.getobjetos();
		this.valor=mochila.getvalor();
		this.unit=mochila.getUnit();
		//mochila2 = new Mochila(n);
		//mochila2 = this(n); 
		//System.out.println("vai aqui");
		
		//return
		//mochila2.setobjetos(mochila.getobjetos());
		
		//for(i=0;i<mochila.getobjetos().length;i++)
		//	System.out.println("mostrar objetos: "+ mochila2.getobjetos()[i]);
		//mochila2.setpeso(mochila.getpeso());
		//mochila2.setvalor(mochila.getvalor());
		//System.out.println("mochila 2:"+ mochila2.getpeso());
		//return mochila2;
	} 
	
	public Mochila crossover(int a_partir,Mochila mochila2, int n, int[] valores, int[] pesos){
		Mochila mochila3;
		//System.out.println("v : " +this.getvalor());
		mochila3 = new Mochila(mochila2, n);
		//System.out.println("peso2 "+mochila2.getpeso());
		//System.out.println("peso3 :"+ mochila3.getpeso());
		//System.out.println("mochila3 "+ mochila3.getobjetos());
		mochila3.colocarC(mochila2.getobjetos(), a_partir, valores, pesos, n);
		return mochila3;
	}
	
	public Mochila(int n,int[] valores, int[] pesos){
		int i;
		this.peso=0;
		this.valor=0;
		this.objetos = new String[n];
		Random gerador = new Random();
		//super();
		for(i=0;i<n;i++){
			objetos[i]= Integer.toString(gerador.nextInt(2));	
			if(objetos[i].equals("1")){
				this.peso=this.peso+pesos[i];
				this.valor=this.valor+valores[i];
			}
		}	
		//System.out.println("objetos "+ objetos.length);
	}
		
	
public	void setpesopos(int i,String[] objetos2 ,String g){
		String[] objeto3;
		objeto3=objetos2;
		objeto3[i]=g;
}
	
public Mochila mutacao(int n,int j,int[] pesos,int[] valores, int pesoMax){
		//int i;
		Mochila mochila2;
		mochila2 = new Mochila(this,n);
		//Random gerador = new Random();
		//i=gerador.nextInt(n);
		if(mochila2.getobjetos()[j].equals("1")){	
			if((mochila2.getpeso()>=0) && (mochila2.getvalor() >=0)){
			//mochila2.setpeso( mochila2.getpeso() - pesos[j]);
			//mochila2.setvalor( mochila2.getvalor() -valores[j]);
			mochila2.setpesopos(j,mochila2.getobjetos(),"0");
			mochila2.alteravalores(mochila2, valores, pesos,pesoMax);
			}else
				System.out.println("fudeuu");
		}else{
			if((mochila2.getpeso()>=0) && (mochila2.getvalor() >=0)){
			//mochila2.setpeso( mochila2.getpeso() + pesos[j]);
			//mochila2.setvalor( mochila2.getvalor() +valores[j]);
				mochila2.setpesopos(j,mochila2.getobjetos(),"1");
				mochila2.alteravalores(mochila2, valores, pesos,pesoMax);
				
			} 
			int a=0;
		} 
	return mochila2;
	}
	
	
private void alteravalores(Mochila mochila2,int[] valores, int[] pesos, int pesoMax){
	int i;
	mochila2.setpeso(0);
	mochila2.setvalor(0);
	mochila2.setUnit(0);
	for(i=0;i<mochila2.getobjetos().length;i++){
		//System.out.println(":" + mochila2.getobjetos()[i]);
		if(mochila2.getobjetos()[i].equals("1")){
			mochila2.setpeso(mochila2.getpeso()+ pesos[i]);
			mochila2.setvalor(mochila2.getvalor()+ valores[i]);
			//mochila2.setUnit(mochila2.getvalor());
		}
	}
		if(pesoMax>=mochila2.getpeso()){
			mochila2.setUnit(mochila2.getvalor());
		}else
			mochila2.setUnit(-1);
}

	public int getpeso(){
		return peso;
	}

	public int getvalor(){
		return valor;
	}

	public void setpeso(int peso){
		this.peso=peso;
	}
	
	public void setvalor(int valor){
		this.valor=valor;	
	}
}
