package cadastro;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastroCurso extends JInternalFrame implements ActionListener{
	JLabel lbId, lbNome,lbMensagem;
	JTextField txtId, txtNome;
	JButton btSalvar;
	GridLayout grade;
	JPanel p1,p2,p3,p4;
	public CadastroCurso() {
		lbId = new JLabel("ID");
		lbNome = new JLabel("Nome");
		lbMensagem = new JLabel();
		txtId = new JTextField(15);
		btSalvar = new JButton("Salvar");
		txtNome = new JTextField(15);
		grade = new GridLayout(4,1);
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
	}
	public void configurar() {
		setBounds(10,10,300,300);
		setLayout(grade);
		setTitle("Cadastro de Cursos");
		setClosable(true);
		btSalvar.addActionListener(this);
	}
	public void montarTela() {
		p1.add(lbId);
		p1.add(txtId);
		p2.add(lbNome);
		p2.add(txtNome);
		p3.add(lbMensagem);
		p4.add(btSalvar);
		
		add(p1);add(p2);add(p3);add(p4);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Curso c = new Curso();
		c.setId(Integer.parseInt(txtId.getText()));
		c.setNome(txtNome.getText());
		BancoDeDados.inserirCurso(c);
		lbMensagem.setText("Cadastro concluído!!");
		txtId.setText("");
		txtNome.setText("");
	
		
	}

}
