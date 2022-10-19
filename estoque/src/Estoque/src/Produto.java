public class Produto {
String nome;
Tipo tipo;
double preco;
int quantidade,cod;

public int getCod() {
	return cod;
}
public void setCod(int cod) {
	this.cod = cod;
}
public int getQuantidade() {
	return quantidade;
}
public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public Tipo getTipo() {
	return tipo;
}
public void setTipo(Tipo tipo) {
	this.tipo = tipo;
}
public double getPreco() {
	return preco;
}
public void setPreco(double preco) {
	this.preco = preco;
}

}