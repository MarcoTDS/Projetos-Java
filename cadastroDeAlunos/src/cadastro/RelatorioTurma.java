package cadastro;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class RelatorioTurma extends JInternalFrame{
	JTable tabela;
	DefaultTableModel modelo;
	JScrollPane painel;
	String cabecalho[]= {"ID","Nome","Curso"};
	
	public RelatorioTurma() {
		modelo = new DefaultTableModel(null,cabecalho);
		tabela = new JTable(modelo);
		painel = new JScrollPane(tabela);
        
	}
	public void configurar() {
		setBounds(0,0,300,300);
		setTitle("Tabela das Turmas");
		setClosable(true);
		
	}
	public void montarTela() {
		for(Turma t: BancoDeDados.listaTurma) {
			modelo.addRow(new Object[] {t.getId(),t.getNome(),t.getCurso()});
		}
		add(painel);
	setVisible(true);
	}
	

}
