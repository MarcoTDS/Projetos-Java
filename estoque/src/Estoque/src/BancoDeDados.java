import java.util.ArrayList;
import java.util.Random;

public class BancoDeDados {
 static ArrayList<Tipo>listaTipo= new ArrayList<Tipo>();
 static ArrayList<Produto>listaProduto= new ArrayList<Produto>();

public void insereTipo() {
	Tipo t = new Tipo();
	t.setNome("Bebida");
	Tipo t1 = new Tipo();
	t1.setNome("Alimento");
	Tipo t2 = new Tipo();
	t2.setNome("Sobremesa");
	
	listaTipo.add(t1);
	listaTipo.add(t2);
	listaTipo.add(t);
}
public void insereProduto() {
	int i,j=0;
	Random r = new Random();
	
	for(i=0;i<50;i++) {
		Produto p = new Produto();
		p.setNome("Produto"+i);
		int x= r.nextInt(3);
		
		//definir tipo aleatório
		for (Tipo tipo : listaTipo) {
			if(x==j)
			p.setTipo(tipo);
			j++;
		}
		j=0;
		
		p.setPreco(r.nextDouble());
		p.setQuantidade(r.nextInt(100));
		p.setCod(i+100);
		listaProduto.add(p);
	}
	
}
	

}
