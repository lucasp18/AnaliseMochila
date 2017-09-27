import java.util.Random;


public class PMochila {

	//int[] tm_entrada ={10,30,100,200,1000};
	int tm_entrada;
	public int[] getValores() {
		return valores;
	}

	public void setValores(int[] valores) {
		this.valores = valores;
	}

	public int[] getPesos() {
		return pesos;
	}

	public void setPesos(int[] pesos) {
		this.pesos = pesos;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getTm_entrada() {
		return tm_entrada;
	}

	public void setTm_entrada(int tm_entrada) {
		this.tm_entrada = tm_entrada;
	}


	int[] valores;
	int[] pesos;
	//static int pos=0;
	int peso;
	//int B;
	//int tm_entrada;
	
	public PMochila(int tm_entrada){
		//int b;
		int i;
		boolean pod=false;
		this.tm_entrada=tm_entrada;
		this.valores = new int[tm_entrada];
		this.pesos	= new int[tm_entrada];	
		Random gerador = new Random();
		//teste
		
		for(i=0;i<tm_entrada;i++){
		//for(int j=0;j<tm_entrada;j++){
				while(pod==false){
					valores[i] = gerador.nextInt(100); // alterar para gerar outras opcoes de numero
					pesos[i] = gerador.nextInt(100); // alterar para gerar outras opcoes de numero
					if(valores[i] > 0 && pesos[i] > 0)
						pod=true;
				}
			pod=false;
			valores[0]=0;
			pesos[0]=0;
		} 
	
		
		// gerando o peso max da mochila; lembrar de alterar com base na quantidade de entrada
		peso=330*maiorPeso()+gerador.nextInt(mediaPeso());
		//peso=10;
		//peso=200;
	}
	
	public void printar(){
		int i;
	//	System.out.println("tamanho das entradas do problema: "+pos);
		//for(i=0;i<tm_entrada.length;i++)
	//		System.out.print("i :"+ i +" : "+ tm_entrada[i]);
/*
		System.out.print("\npesos   ");
		for(i=0;i<tm_entrada;i++){
			System.out.print(" " +pesos[i]);
		}
		System.out.print("\n");
		System.out.print("\n");
		System.out.print("\n");
		System.out.print("valores ");
		for(i=0;i<tm_entrada;i++){
			System.out.print(" " + valores[i]);
		} */
	}


	public int mediaPeso(){
		int media =0;
		int i;
		for(i=0;i<pesos.length;i++)
				media=media+pesos[i];
		return media/pesos.length;
		
	}
	
	public int maiorPeso(){
		int soma =0;
		int i;
		for(i=0;i<pesos.length;i++)
			if(soma<pesos[i])
				soma=pesos[i];
		return soma;
		
	}
	
/*	
public static void main(String[] args){
int i;
 PMochila pm=null;
 long timeinicial = System.currentTimeMillis();
 //for(i=0;i<5;i++){
	pm = new PMochila(10);
	pm.printar(); 
	//pos++;
//}
long timefinal = System.currentTimeMillis();
 System.out.println("\n tempo de: "+ (timefinal-timeinicial));
 System.out.println("\n tempo de2: "+ (timeinicial));
 System.out.println("\n peso eh:" + pm.peso);
} */
}
