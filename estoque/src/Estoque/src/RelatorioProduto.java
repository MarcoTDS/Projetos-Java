import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RelatorioProduto extends JInternalFrame{
JTable tabela;
String[] cabecalho= {"Código","Nome","Tipo","Preço","Quantidade"};
JScrollPane painel;
DefaultTableModel modelo;

public RelatorioProduto() {
	modelo = new DefaultTableModel(null, cabecalho);
	tabela = new JTable(modelo);
	painel = new JScrollPane(tabela);
	
	configurar();
}
public void configurar() {
	setBounds(0, 0, 700, 500);
	setClosable(true);
	montarTela();
}
public void montarTela() {
	add(painel);
	listaProdutos();
	setVisible(true);
}
public void listaProdutos() { 
	for (Produto produto : BancoDeDados.listaProduto) {
		String[] linha= {String.valueOf(produto.getCod()),
				         produto.getNome(),
				         produto.getTipo().getNome(),
				         String.valueOf(produto.getPreco()),
				         String.valueOf(produto.getQuantidade())};
		
		
	 modelo.addRow(linha);
	}
}
}
