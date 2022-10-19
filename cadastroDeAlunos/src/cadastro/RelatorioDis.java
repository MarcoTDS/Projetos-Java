package cadastro;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RelatorioDis extends JInternalFrame{
	JTable tabela;
	DefaultTableModel modelo;
	JScrollPane painel;
	String cabecalho[]= {"ID","Nome","Turma"};
	public RelatorioDis() {
		modelo = new DefaultTableModel(null,cabecalho);
		tabela = new JTable(modelo);
		painel = new JScrollPane(tabela);
	}
	public void configurar() {
		setBounds(0,0,300,300);
		setTitle("Tabela das Disciplinas");
		setClosable(true);
		
	}
	public void montarTela() {
		for(Disciplina d : BancoDeDados.listaDis) {
			modelo.addRow(new Object[] {d.getId(),d.getNome(),d.getTurma()});
		}
		add(painel);
		setVisible(true);
	}

}
