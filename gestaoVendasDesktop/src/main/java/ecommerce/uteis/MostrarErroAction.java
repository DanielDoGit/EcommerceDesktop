package ecommerce.uteis;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;
import limasoftware.uteis.Interface;

public class MostrarErroAction extends MostrarErro{

	private Exception ex;
	
	public MostrarErroAction(Shell pai, String mensagem, Exception e) {
		super(pai);
		this.ex = e;
		labelTexto.setText(mensagem);
		tratareventosLabel();
		tratareventosBotao();
		Interface.centralizarShell(janela);
		janela.open();
		Interface.manterJanelaModal(janela);
	}
	
	private void tratareventosLabel() {
		labelDetalhes.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				new MostrarExceptionAction(janela, ex);
			}
		});
	}
	
	private void tratareventosBotao() {
		btnOk.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				janela.close();
			}
		});
		
	}
	

}
