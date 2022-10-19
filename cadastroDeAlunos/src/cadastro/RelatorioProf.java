package cadastro;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RelatorioProf extends JInternalFrame{
	JTable tabela;
	DefaultTableModel modelo;
	JScrollPane painel;
	String cabecalho[]= {"ID","Nome","Disciplina"};
	public RelatorioProf() {
		modelo = new DefaultTableModel(null,cabecalho);
		tabela = new JTable(modelo);
		painel = new JScrollPane(tabela);
	}
	public void configurar() {
		setBounds(0,0,300,300);
		setTitle("Tabela dos Professores");
		setClosable(true);
	}
	public void montarTela() {
		for(Professor p : BancoDeDados.listaProf) {
			modelo.addRow(new Object[] {p.getId(),p.getNome(),p.getDisciplina()});
		}
		add(painel);
		setVisible(true);
	}

}
