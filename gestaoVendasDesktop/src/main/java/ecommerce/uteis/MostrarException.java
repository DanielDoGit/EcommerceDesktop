package ecommerce.uteis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public abstract class MostrarException {

	protected Shell janela;
	protected Shell pai;
	protected Button btnSair;
	protected Text text;
	protected Button btnSalvar;

	public MostrarException(Shell pai) {
		this.pai = pai;
		createContents();
	}

	private void createContents() {
		janela = new Shell(pai, SWT.SHELL_TRIM);
		janela.setSize(825, 626);
		janela.setText("Detalhes da exceção ocorrida");
		GridLayout gl_shlLimasoftware = new GridLayout(1, false);
		gl_shlLimasoftware.marginBottom = 10;
		gl_shlLimasoftware.marginRight = 10;
		gl_shlLimasoftware.marginTop = 10;
		gl_shlLimasoftware.marginLeft = 10;
		janela.setLayout(gl_shlLimasoftware);

		text = new Text(janela, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
		text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		btnSalvar = new Button(janela, SWT.NONE);
		GridData gd_btnSalvar = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_btnSalvar.heightHint = 26;
		gd_btnSalvar.minimumHeight = 26;
		gd_btnSalvar.widthHint = 80;
		gd_btnSalvar.minimumWidth = 80;
		btnSalvar.setLayoutData(gd_btnSalvar);
		btnSalvar.setText("Salvar");

		btnSair = new Button(janela, SWT.NONE);
		GridData gd_btnSair = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_btnSair.heightHint = 26;
		gd_btnSair.minimumHeight = 26;
		gd_btnSair.widthHint = 80;
		gd_btnSair.minimumWidth = 80;
		btnSair.setLayoutData(gd_btnSair);
		btnSair.setText("Sair");

	}
}
