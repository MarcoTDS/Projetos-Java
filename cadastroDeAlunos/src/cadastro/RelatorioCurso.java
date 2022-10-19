package cadastro;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RelatorioCurso extends JInternalFrame{
	JTable tabela;
	DefaultTableModel modelo;
	JScrollPane painel;
	String cabecalho[]= {"ID","Nome"};
	public RelatorioCurso() {
		modelo = new DefaultTableModel(null,cabecalho);
		tabela = new JTable(modelo);
		painel = new JScrollPane(tabela);
	}
	public void configurar() {
		setBounds(0,0,300,300);
		setTitle("Tabela dos Cursos");
		setClosable(true);
	}
	public void montarTela() {
		for(Curso c : BancoDeDados.listaCurso) {
			modelo.addRow(new Object[] {c.getId(),c.getNome()});
		}
		add(painel);
		setVisible(true);
		
	}

}
