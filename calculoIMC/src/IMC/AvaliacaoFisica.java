package IMC;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AvaliacaoFisica extends JFrame implements ActionListener{
	JLabel jlNome, jlPeso, jlAltura, jlSexo, jlResultado;
	JTextField txtNome, txtPeso, txtAltura;
	JRadioButton rbMasculino, rbFeminino;
	JButton btCalcular;
	JPanel p1,p2,p3,p4,p5,p6;
	final double MIN_H = 19,MAX_H = 26,MIN_M = 16,MAX_M = 24;
	double pesoMa;
	double pesoMi;
	
	public AvaliacaoFisica() {
		jlNome = new JLabel("Nome");
		jlAltura = new JLabel("Altura");
		jlPeso = new JLabel("Peso");
		jlSexo = new JLabel("Sexo");
		jlResultado = new JLabel("Resultado");
		
		
		txtNome = new JTextField(20);
		txtAltura = new JTextField(5);
		txtPeso = new JTextField(5);
		
		rbFeminino = new JRadioButton("Feminino");
		rbMasculino = new JRadioButton("Masculino");
		
		btCalcular = new JButton("Calcular");
		
		p1= new JPanel();p2= new JPanel();
		p3= new JPanel();p4= new JPanel();
		p5= new JPanel();p6= new JPanel();
	}
	public void configuracoes() {
		setBounds(0,0,600,600);
		GridLayout grade = new GridLayout(6,1);
		setLayout(grade);
		btCalcular.addActionListener(this);
		
	}
	public void montarTela() {
		p1.add(jlNome);p1.add(txtNome);
		p2.add(jlPeso);p2.add(txtPeso);
		p3.add(jlAltura);p3.add(txtAltura);
		p4.add(jlSexo);p4.add(rbMasculino);
		p4.add(rbFeminino);
		p5.add(btCalcular);
		p6.add(jlResultado);
		add(p1);add(p2);add(p3);
		add(p4);add(p5);add(p6);
		setVisible(true);
	}
	public void calcularIMC(Atletas a) {
		double imc = a.getPeso()/(a.getAltura()*a.getAltura());
		if(a instanceof Mulher) {
			if(imc<MIN_M) { 
				pesoMa=(a.getPeso()*MIN_M)/imc;
				pesoMi=(a.getPeso()*MAX_M)/imc;
				jlResultado.setText("Abaixo do peso, seu peso ideal: "+pesoMi+" entre "+pesoMa);
			}
			else if(imc>MAX_M) {
				pesoMa=(a.getPeso()*MIN_M)/imc;
				pesoMi=(a.getPeso()*MAX_M)/imc;
				jlResultado.setText("Acima do peso, seu peso ideal: "+pesoMi+" entre "+pesoMa);
			}
			else
				jlResultado.setText("Seu IMC é de :"+imc+", está ideal");
		}
		else {
			if(imc< MIN_H ) {
				pesoMa=(a.getPeso()*MIN_H)/imc;
				pesoMi=(a.getPeso()*MAX_H)/imc;
				jlResultado.setText("Abaixo do peso, seu peso ideal: "+pesoMi+" entre "+pesoMa);
			}
			else if(imc>MAX_H) {
				pesoMa=(a.getPeso()*MIN_H)/imc;
				pesoMi=(a.getPeso()*MAX_H)/imc;
				jlResultado.setText("Acima do peso, seu peso ideal: "+pesoMi+" entre "+pesoMa);
			}
			else
				jlResultado.setText("Seu IMC é de :"+imc+", está ideal");
		}
	}
	public void prepararCalculoIMC() {
		Atletas a=null;
		double peso=Double.parseDouble(txtPeso.getText());
		double altura=Double.parseDouble(txtAltura.getText());
		if(rbFeminino.isSelected()) {
			a = new Mulher();
		}
		else {
			a = new Homem();
		}
		a.setAltura(altura);
		a.setPeso(peso);
		calcularIMC(a);
	}

	public static void main(String[] args) {
		AvaliacaoFisica av = new AvaliacaoFisica();
		av.configuracoes();
		av.montarTela();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		prepararCalculoIMC();
		
	}

}
