package cadastro;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class Principal extends JFrame implements ActionListener{
	JMenuBar barra;
	JMenu menuCadastro, menuTabela;
	JMenuItem cadastroAl, cadastroProf, cadastroDis, cadastroTurma, 
	cadastroCurso,relatorioAl, relatorioProf, relatorioDis, relatorioTurma,relatorioCurso;
	JDesktopPane dsk;
	public Principal() {
		barra = new JMenuBar();
		menuCadastro = new JMenu("Cadastro");
		menuTabela = new JMenu("Relatório");
		cadastroAl = new JMenuItem("Alunos");
		cadastroProf = new JMenuItem("Professores");
		cadastroDis = new JMenuItem("Disciplinas");
		cadastroTurma = new JMenuItem("Turmas");
		cadastroCurso = new JMenuItem("Cursos");
		relatorioAl = new JMenuItem("Alunos");
		relatorioProf = new JMenuItem("Professores");
		relatorioDis = new JMenuItem("Disciplinas");
		relatorioTurma = new JMenuItem("Turmas");
		relatorioCurso = new JMenuItem("Cursos");
		dsk = new JDesktopPane();
	}
	public void configurarComponente() {
		setTitle("Cadastro geral");
		setBounds(0,0,800,600);
		dsk.setBackground(Color.blue);
		cadastroAl.addActionListener(this);
		cadastroProf.addActionListener(this);
		cadastroDis.addActionListener(this);
		cadastroTurma.addActionListener(this);
		cadastroCurso.addActionListener(this);
		relatorioAl.addActionListener(this);
		relatorioProf.addActionListener(this);
		relatorioDis.addActionListener(this);
		relatorioTurma.addActionListener(this);
		relatorioCurso.addActionListener(this);
		setContentPane(dsk);
	}
	public void montarTela() {
		menuCadastro.add(cadastroAl);
		menuCadastro.add(cadastroProf);
		menuCadastro.add(cadastroDis);
		menuCadastro.add(cadastroTurma);
		menuCadastro.add(cadastroCurso);
		menuTabela.add(relatorioAl);
		menuTabela.add(relatorioProf);
		menuTabela.add(relatorioDis);
		menuTabela.add(relatorioTurma);
		menuTabela.add(relatorioCurso);
		barra.add(menuCadastro);
		barra.add(menuTabela);
		setJMenuBar(barra);
		setVisible(true);
	}
	public static void main(String[] args) {
		Principal p = new Principal();
		p.configurarComponente();
		p.montarTela();
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cadastroCurso) {
			CadastroCurso janela = new CadastroCurso();
        	dsk.add(janela);
        	janela.configurar();
        	janela.montarTela();
			
		}
		else if(e.getSource()==cadastroTurma) {
			CadastroTurma janela = new CadastroTurma();
			dsk.add(janela);
			janela.configurar();
			janela.montarTela();
			
		}
		else if(e.getSource()==cadastroDis) {
			CadastroDis janela = new CadastroDis();
			dsk.add(janela);
			janela.configurar();
			janela.montarTela();
			
		}
		else if(e.getSource()==cadastroProf) {
			CadastroProf janela = new CadastroProf();
			dsk.add(janela);
			janela.configurar();
			janela.montarTela();
			
		}
        else if(e.getSource()==cadastroAl) {
        	CadastroAluno janela = new CadastroAluno();
        	dsk.add(janela);
        	janela.configurar();
        	janela.montarTela();
			
		}
		else if(e.getSource()==relatorioAl) {
			RelatorioAluno ra = new RelatorioAluno();
			ra.configurar();
			ra.montarTela();
			dsk.add(ra);
			
		}
		else if(e.getSource()==relatorioProf) {
			RelatorioProf rp = new RelatorioProf();
			rp.configurar();
			rp.montarTela();
			dsk.add(rp);
			
		}
		else if(e.getSource()==relatorioDis) {
			RelatorioDis rd = new RelatorioDis();
			rd.configurar();
			rd.montarTela();
			dsk.add(rd);
			
		}
		else if(e.getSource()==relatorioTurma){
			RelatorioTurma rt = new RelatorioTurma();
			rt.configurar();
			rt.montarTela();
			dsk.add(rt);
			
		}
		else {
			RelatorioCurso rc = new RelatorioCurso();
			rc.configurar();
			rc.montarTela();
			dsk.add(rc);
			
		}
		
	}

}
