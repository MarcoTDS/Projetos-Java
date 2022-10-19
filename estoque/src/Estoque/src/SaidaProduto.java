import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SaidaProduto extends JInternalFrame implements ActionListener {
JTextField txtCod, txtQuantidade;
JButton btBusca,btSubtrai,btConfirma;
JLabel lbProduto;
JPanel p1, p2; 
public SaidaProduto() {
	txtCod = new JTextField(5);
	txtQuantidade = new JTextField(10);
	btBusca = new JButton("Buscar");
	btSubtrai = new JButton("Retirar");
	btConfirma = new JButton("Confirmar");
	lbProduto = new JLabel();
	p1 = new JPanel();
	p2 = new JPanel();
	configurar();
	
}
public void configurar() {
	setBounds(200, 150, 300, 200);
	setLayout(new GridLayout(2, 1));
	btConfirma.addActionListener(this);
	btBusca.addActionListener(this);
	setClosable(true);
	montarTela();
}
public void montarTela() {
p1.add(txtCod);
p1.add(btBusca);
p1.add(lbProduto);

p2.add(txtQuantidade);
p2.add(btConfirma);

add(p1);
add(p2);
setVisible(true);
}
@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==btConfirma) {
		for (Produto produto : BancoDeDados.listaProduto) {
			if(produto.getCod()==Integer.parseInt(txtCod.getText())) {
				int aux=produto.getQuantidade() -Integer.parseInt(txtQuantidade.getText());
				produto.setQuantidade(aux);
			}
		}
	}
	else if(e.getSource()==btBusca) {
		for (Produto produto : BancoDeDados.listaProduto) {
			if(produto.getCod()==Integer.parseInt(txtCod.getText())) {
				lbProduto.setText(produto.getNome());
			}
		}
	}
	}
}