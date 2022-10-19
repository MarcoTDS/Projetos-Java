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

public class CadastroDis extends JInternalFrame implements ActionListener{
	JLabel lbId, lbNome, lbTurma,lbMensagem;
	JTextField txtId, txtNome;
	JComboBox<Turma> jbTurma;
	JButton btSalvar;
	GridLayout grade;
	JPanel p1,p2,p3,p4,p5;
	public CadastroDis() {
		lbId = new JLabel("ID");
		lbNome = new JLabel("Nome");
		lbTurma = new JLabel("Turma");
		lbMensagem = new JLabel();
		txtId = new JTextField(15);
		txtNome = new JTextField(15);
		jbTurma = new JComboBox<Turma>();
		btSalvar = new JButton("Salvar");
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		grade = new GridLayout(5,1);
	
	}
	public void configurar() {
		setBounds(10,10,300,400);
		setLayout(grade);
		setTitle("Cadastro de Disciplina");
		setClosable(true);
		btSalvar.addActionListener(this);
		
	}
	public void montarTela() {
		p1.add(lbId);
		p1.add(txtId);
		p2.add(lbNome);
		p2.add(txtNome);
		for(Turma t : BancoDeDados.listaTurma) {
			jbTurma.addItem(t);
		}
		p3.add(lbTurma);
		p3.add(jbTurma);
		p4.add(lbMensagem);
		p5.add(btSalvar);
		
		add(p1);add(p2);add(p3);add(p4);add(p5);
		setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) {
		Disciplina d = new Disciplina();
		d.setId(Integer.parseInt(txtId.getText()));
		d.setNome(txtNome.getText());
		d.setTurma((Turma)jbTurma.getSelectedItem());
		BancoDeDados.inserirDisciplina(d);
		lbMensagem.setText("Cadastro coclu�do!!");
		txtId.setText("");
		txtNome.setText("");
		
	}

}
