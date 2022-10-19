package cadastro;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastroTurma extends JInternalFrame implements ActionListener{
	JLabel lbId,lbNome,lbCurso,lbMensagem;
	JTextField txtId, txtNome;
	JComboBox<Curso> jbCurso;
	JButton btSalvar;
	JPanel p1,p2,p3,p4,p5;
	GridLayout grade;
	public CadastroTurma() {
		lbNome = new JLabel("Nome");
		lbId = new JLabel("ID");
		lbCurso = new JLabel("Curso");
		lbMensagem = new JLabel();
		txtNome = new JTextField(15);
		txtId = new JTextField(15);
		jbCurso = new JComboBox<Curso>();
		btSalvar = new JButton("Salvar");
		grade = new GridLayout(5,1);
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
	}
	public void configurar() {
		setBounds(10,10,300,400);
		setLayout(grade);
		setTitle("Cadastro de Turma");
		setClosable(true);
		btSalvar.addActionListener(this);
	}
	public void montarTela() {
		p1.add(lbId);
		p1.add(txtId);
		p2.add(lbNome);
		p2.add(txtNome);
		for(Curso c : BancoDeDados.listaCurso) {
			jbCurso.addItem(c);
		}
		p3.add(lbCurso);
		p3.add(jbCurso);
		p4.add(lbMensagem);
		p5.add(btSalvar);
		
		add(p1);add(p2);add(p3);add(p4);add(p5);
		setVisible(true);
	}

	
	public void actionPerformed(ActionEvent arg0) {
		Turma t = new Turma();
		t.setId(Integer.parseInt(txtId.getText()));
		t.setNome(txtNome.getText());
		t.setCurso((Curso)jbCurso.getSelectedItem());
		BancoDeDados.inserirTurma(t);
		lbMensagem.setText("Cadastro concluído");
		txtId.setText("");
		txtNome.setText("");
		
	}
	

}
