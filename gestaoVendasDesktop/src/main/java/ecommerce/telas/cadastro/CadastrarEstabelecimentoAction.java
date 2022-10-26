package ecommerce.telas.cadastro;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Shell;

import limasoftware.uteis.Interface;

public class CadastrarEstabelecimentoAction extends CadastrarEstabelecimento {

	public CadastrarEstabelecimentoAction(Shell pai) {
		super(pai);
		iniciarTela();
	}
	
	private void iniciarTela() {
		adicionarEventosLabel();
		Interface.centralizarShell(shell);
		shell.open();
		Interface.manterJanelaModal(shell);
	}
	
	private void adicionarEventosLabel() {
		labelIconePesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
			}
		});
	}

}
