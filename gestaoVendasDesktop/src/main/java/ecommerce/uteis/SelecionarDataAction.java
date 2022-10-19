package ecommerce.uteis;

import java.util.Date;


import org.eclipse.swt.widgets.Shell;
import limasoftware.conversao.ConverteDatas;
import limasoftware.mascara.MascaraDatas;
import limasoftware.uteis.Interface;
import limasoftware.uteis.Saida;

public class SelecionarDataAction extends SelecionarData {

	private boolean confirmou = false;
	private Date data;

	public SelecionarDataAction(Shell pai) {
		super(pai);
		adicionarEventoButton();
		adicionarEventoText();
		adicionarEventoLabel();
		iniciarCampos();
		Interface.centralizarShell(sShell);
		sShell.open();
		Interface.manterJanelaModal(sShell);
	}

	public SelecionarDataAction(Shell pai, Date data) {
		super(pai);
		adicionarEventoButton();
		adicionarEventoText();
		adicionarEventoLabel();
		txtData.setText(ConverteDatas.convDateBeanUser(data));
		txtData.selectAll();
		Interface.centralizarShell(sShell);
		sShell.open();
		Interface.manterJanelaModal(sShell);
	}

	private void iniciarCampos() {
		txtData.setText(ConverteDatas.getCurrentUserDate());
		txtData.selectAll();
	}

	private void adicionarEventoText() {
		txtData.addFocusListener(MascaraDatas.getFormatarDatas());
	}

	private void adicionarEventoLabel() {
		lblCalendario.addMouseListener(new org.eclipse.swt.events.MouseAdapter() {
			public void mouseDown(org.eclipse.swt.events.MouseEvent e) {
				new Calendario(txtData);
			}
		});
	}

	private void adicionarEventoButton() {
		btnCancelar.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				sShell.close();
			}
		});
		btnAceitar.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				if (ConverteDatas.convertDateUserBean(txtData.getText()) != null) {
					data = ConverteDatas.convertDateUserBean(txtData.getText());
					confirmou = true;
					sShell.close();
				} else {
					Saida.exibirMensagem(txtData, "Verifique a data informada!");
				}
			}
		});
	}

	public boolean isConfirmou() {
		return confirmou;
	}

	public Date getData() {
		return data;
	}
}
