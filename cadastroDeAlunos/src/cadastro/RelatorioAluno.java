package cadastro;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RelatorioAluno extends JInternalFrame{
	JTable tabela;
	DefaultTableModel modelo;
	JScrollPane painel;
	String cabecalho[]= {"RA","Nome","Turma"};
	public RelatorioAluno() {
		modelo = new DefaultTableModel(null,cabecalho);
		tabela = new JTable(modelo);
		painel = new JScrollPane(tabela);
		
	}
	public void configurar() {
		setBounds(0,0,300,300);
		setTitle("Tabela dos Alunos");
		setClosable(true);
		
	}
	public void montarTela() {
		for(Aluno a : BancoDeDados.listaAluno) {
			modelo.addRow(new Object[] {a.getRa(),a.getNome(),a.getTurma()});
		}
			add(painel);
			setVisible(true);
		
	}

}
