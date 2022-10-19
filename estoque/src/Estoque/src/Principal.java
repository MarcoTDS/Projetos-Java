import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Principal extends JFrame implements ActionListener {
	JMenuBar barra;
	JMenu produto,relatorio;
	JMenuItem entrada,saida,geral,tipo;
	JDesktopPane dsk;
	
	public Principal() {
		barra = new JMenuBar();
		produto = new JMenu("Produto");
		relatorio = new JMenu("Relatório");
		dsk = new JDesktopPane();
		entrada = new JMenuItem("Entrada");
		saida = new JMenuItem("Saída");
		geral = new JMenuItem("Geral");
		tipo = new JMenuItem("tipo");
		
		configurar();
	}
	
public void configurar() {
	setBounds(0, 0, 800, 600);
	setContentPane(dsk);
	geral.addActionListener(this);
	saida.addActionListener(this);
	tipo.addActionListener(this);
	montarTela();
}

public void montarTela() {
	produto.add(entrada);
	produto.add(saida);
	relatorio.add(geral);
	relatorio.add(tipo);
	barra.add(produto);
	barra.add(relatorio);
	setJMenuBar(barra);
	setVisible(true);
}

public static void main (String[] arg ){
	new Principal();
	BancoDeDados bd = new BancoDeDados();
	bd.insereTipo();
	bd.insereProduto();
	
}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()== geral) {
		RelatorioProduto rp = new RelatorioProduto();
		dsk.add(rp);
	}
	else if(e.getSource()==saida) {
		SaidaProduto sp = new SaidaProduto();
		dsk.add(sp);
	}
	else if(e.getSource()==tipo) {
		RelatorioTipo rt = new RelatorioTipo();
		dsk.add(rt);
	}
}
}
