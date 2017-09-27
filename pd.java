
public class pd {



//public class main {
// desconsiderar as posições zero dos vetores 0
private int[]  v={0,30,14,16,9,11,15};
private int[]  W={0,8 , 3, 4,2,1 , 5}; 
private int Mochila = 10;
private int[] lucro= new int[7];
private int lucro2=0;

/*
public static void main(String[] args){
	//funcaoMelhor();
	pd Pd;
	 int[] f = {0,30,14,16,9,11,15};
	 int[] per = {0,6 , 3, 4,2,1 , 5};
	 Pd = new pd(per,f,11);
	
	
} */

public int getLucro2() {
	return lucro2;
}

public void setLucro2(int lucro2) {
	this.lucro2 = lucro2;
}

public  pd(int[] w,int[] v,int Mochila ){
	this.W=w;
	this.v=v;
	this.Mochila=Mochila;
	int j,i;
	int [][] matriz= new int[w.length][Mochila];
	//System.out.println("peso max dentro de pd : "+ this.Mochila);
	//long  timeinicial = System.currentTimeMillis();
	// zerando toda a matriz
	for(j=0;j<w.length;j++)
		for(i=0;i<Mochila;i++)
			matriz[j][i]=0;
	// colocando os primeiros valores na matriz
	//System.out.println("peso da mochila aqui 34:"+Mochila);
	for(i=0,j=w[i];i<w.length ;j=w[i],i++)
			if(matriz[i][w[i]]==0){
			  matriz[i][w[i]]=v[i];		
			//System.out.println("matriz:"+ matriz[i][j]);
			}
	for(i=1;i<w.length;i++)
		for(j=1;j<Mochila;j++){ // && (j-w[i]<j-1)
				if((j-w[i]>=0)&&(matriz[i-1][j-w[i]]+v[i]>=matriz[i-1][j]))
					matriz[i][j]=matriz[i-1][j-w[i]]+v[i];
				else
					matriz[i][j]=matriz[i-1][j];
		}
	lucro2=matriz[w.length-1][Mochila-1];
	//for(int j=0;j<2;j++){
//	for(i=0;i<v.length;i++){
		//Mochila=10;
	//	f(i);
	//System.out.println(Mochila);
	//return 0;
	//mostrar2(matriz);	
	//System.out.println("lucro de:"+ lucro2);
	//	System.out.println("peso da moc:"+ Mochila);
	//}
	//}
//long timefinal = System.currentTimeMillis();
	//System.out.println("\n tempo de: pd2 "+ (timefinal-timeinicial));
}

public int getMochila() {
	return Mochila;
}


public void setMochila(int mochila) {
	Mochila = mochila;
}

private void mostrar2(int [][] matriz){
	int i,j;
	for(i=0;i<W.length;i++)
		for(j=0;j<Mochila;j++){
			if(j==0)
				System.out.print("linha:"+ i);
			System.out.print(":valor: "+ matriz[i][j]);
			if(j==Mochila-1)
				System.out.print("\n");
		}
	System.out.println("melhor valor eh 2:"+matriz[W.length-1][Mochila-1]);
}

/*
private  void f(int i){
	if(i<=0||Mochila==0)
		return ;
	else{
		if(Mochila-W[i]>=0)
			if(lucro2>=lucro2+v[i]){
				lucro2=lucro2+v[i];
				Mochila=Mochila-W[i];
				//lucro2=lucro2;
				//return;
			}else{
				//lucro2=lucro2+v[i];
				//Mochila=Mochila-W[i];
			//return;
			}else
				//lucro[i]=0;
				return;
		}
		
	}





public static void f(int i){
	if(i<=0||Mochila==0)
		return ;
	else
		if(Mochila-W[i]>=0)
			if(lucro[i-1]>=lucro[i-1]+v[i])
				lucro[i]=lucro[i-1];
			else{
				lucro[i]=lucro[i-1]+v[i];
				Mochila=Mochila-W[i];
			}else
				//lucro[i]=0;
				i=0;
} */










}





//}
