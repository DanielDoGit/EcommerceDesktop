package ecommerce.uteis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public abstract class MostrarErro {

	protected Shell janela;
	protected Shell pai;
	protected Button btnOk;
	protected Label labelTexto;
	protected CLabel labelImagem;
	protected Label labelDetalhes;

	public MostrarErro(Shell pai) {
		this.pai = pai;
		createContents();
	}

	private void createContents() {
		janela = new Shell(pai, SWT.SHELL_TRIM | SWT.APPLICATION_MODAL);
		janela.setSize(435, 144);
		janela.setText("Limasoftware");
		GridLayout gl_shlLimasoftware = new GridLayout(3, false);
		gl_shlLimasoftware.marginBottom = 10;
		gl_shlLimasoftware.marginRight = 10;
		gl_shlLimasoftware.marginTop = 10;
		gl_shlLimasoftware.marginLeft = 10;
		janela.setLayout(gl_shlLimasoftware);

		labelImagem = new CLabel(janela, SWT.NONE);
		labelImagem.setText("");
		labelImagem.setImage(Display.getCurrent().getSystemImage(SWT.ICON_INFORMATION));

		labelTexto = new Label(janela, SWT.WRAP);
		labelTexto.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		labelTexto.setText("Essa label mostrar o texto da mensagem para o usuário. O objetivo é que ela consiga fazer o wrap do texto.");
		new Label(janela, SWT.NONE);

		labelDetalhes = new Label(janela, SWT.NONE);
		labelDetalhes.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, true, 1, 1));
		labelDetalhes.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_BLUE));
		labelDetalhes.setText("Exibir detalhes");

		btnOk = new Button(janela, SWT.NONE);
		GridData gd_btnOk = new GridData(SWT.RIGHT, SWT.BOTTOM, false, true, 1, 1);
		gd_btnOk.widthHint = 80;
		gd_btnOk.minimumWidth = 60;
		gd_btnOk.minimumHeight = 10;
		gd_btnOk.heightHint = 26;
		btnOk.setLayoutData(gd_btnOk);
		btnOk.setText("OK");

	}
	
}
