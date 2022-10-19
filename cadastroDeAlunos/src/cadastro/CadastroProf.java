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

public class CadastroProf extends JInternalFrame implements ActionListener{
	JLabel lbId,lbNome,lbDis,lbMensagem;
	JTextField txtId,txtNome;
	JComboBox<Disciplina> jbDis;
	JButton btSalvar;
	GridLayout grade;
	JPanel p1,p2,p3,p4,p5;
	public CadastroProf() {
		lbId = new JLabel("ID");
		lbNome = new JLabel("Nome");
		lbDis = new JLabel("Disciplina");
		lbMensagem = new JLabel();
		txtId = new JTextField(15);
		txtNome = new JTextField(15);
		jbDis = new JComboBox<Disciplina>();
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
		setTitle("Cadastro de Professor");
		setClosable(true);
		btSalvar.addActionListener(this);
	}
	public void montarTela() {
		p1.add(lbId);
		p1.add(txtId);
		p2.add(lbNome);
		p2.add(txtNome);
		for(Disciplina d : BancoDeDados.listaDis) {
			jbDis.addItem(d);
		}
		p3.add(lbDis);
		p3.add(jbDis);
		p4.add(lbMensagem);
		p5.add(btSalvar);
		
		add(p1);add(p2);add(p3);add(p4);add(p5);
		setVisible(true);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		Professor p = new Professor();
		p.setId(Integer.parseInt(txtId.getText()));
		p.setNome(txtNome.getText());
		p.setDisciplina((Disciplina)jbDis.getSelectedItem());
		BancoDeDados.inserirProfessor(p);
		lbMensagem.setText("Cadastro concluído!!");
		txtId.setText("");
		txtNome.setText("");
		
		
	}

}
