import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
public class RelatorioTipo extends JInternalFrame implements ActionListener{
JTable tabela;
String[] cabecalho= {"Código","Nome","Tipo","Preço","Quantidade"};
JScrollPane painel;
DefaultTableModel modelo;
JButton btBebida, btAlimento, btSobremesa;
JPanel p;
public RelatorioTipo() {
	modelo = new DefaultTableModel(null, cabecalho);
	tabela = new JTable(modelo);
	painel = new JScrollPane(tabela);
	btBebida = new JButton("Bebida");
	btAlimento = new JButton("Alimento");
	btSobremesa = new JButton("Sobremesa");
	p= new JPanel();
	configurar();
}
public void configurar() {
	setLayout(null);
	painel.setBounds(0,50,700,440);
	p.setBounds(0,0,700,50);
	btBebida.addActionListener(this);
	btAlimento.addActionListener(this);
	btSobremesa.addActionListener(this);
	setBounds(0, 0, 700, 500);
	setClosable(true);
	montarTela();
}
public void montarTela() {
	p.add(btAlimento);
	p.add(btBebida);
	p.add(btSobremesa);
	add(p);
	add(painel);
	
	
	
	setVisible(true);
}
public void listaProdutos(String tipo) { 
	modelo.setNumRows(0);
	for (Produto produto : BancoDeDados.listaProduto) {
		if(produto.getTipo().getNome().equals(tipo)) {
			String[] linha= {String.valueOf(produto.getCod()),
					         produto.getNome(),
					         produto.getTipo().getNome(),
					         String.valueOf(produto.getPreco()),
					         String.valueOf(produto.getQuantidade())};
			
			
		    modelo.addRow(linha);
	}
	}
}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==btBebida) {
		listaProdutos("Bebida");
	}
	else if(e.getSource()==btAlimento) {
		listaProdutos("Alimento");
	}
	else if(e.getSource()==btSobremesa) {
		listaProdutos("Sobremesa");
	}
	
}
}
