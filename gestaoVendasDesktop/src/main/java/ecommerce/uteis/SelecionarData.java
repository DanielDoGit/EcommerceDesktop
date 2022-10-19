package ecommerce.uteis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public abstract class SelecionarData {

	protected Shell sShell;
	protected Shell pai;
	protected Button btnAceitar;
	protected Group group;
	protected Label lblData;
	protected Text txtData;
	protected Label lblCalendario;
	protected Button btnCancelar;

	public SelecionarData(Shell shell) {
		pai = shell;
		createSShell();
	}

	private void createSShell() {
		sShell = new Shell(pai, SWT.SHELL_TRIM);
		sShell.setText("Selecione a data");
		sShell.setSize(new Point(209, 189));
		createGroup();
		btnAceitar = new Button(sShell, SWT.NONE);
		GridData gd_btnAceitar = new GridData(SWT.RIGHT, SWT.BOTTOM, false, false, 1, 1);
		gd_btnAceitar.minimumHeight = 280;
		gd_btnAceitar.minimumWidth = 85;
		gd_btnAceitar.heightHint = 28;
		gd_btnAceitar.widthHint = 85;
		btnAceitar.setLayoutData(gd_btnAceitar);
		btnAceitar.setText("&Aceitar");
		btnCancelar = new Button(sShell, SWT.NONE);
		GridData gd_btnCancelar = new GridData(SWT.RIGHT, SWT.BOTTOM, false, false, 1, 1);
		gd_btnCancelar.minimumHeight = 280;
		gd_btnCancelar.minimumWidth = 85;
		gd_btnCancelar.heightHint = 28;
		gd_btnCancelar.widthHint = 85;
		btnCancelar.setLayoutData(gd_btnCancelar);
		btnCancelar.setText("&Cancelar");

	}

	private void createGroup() {
		GridLayout gl_sShell = new GridLayout(1, false);
		gl_sShell.marginBottom = 5;
		gl_sShell.marginRight = 5;
		gl_sShell.marginTop = 5;
		gl_sShell.marginLeft = 5;
		sShell.setLayout(gl_sShell);
		group = new Group(sShell, SWT.NONE);
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		group.setText("Período");
		group.setLayout(new GridLayout(3, false));
		lblData = new Label(group, SWT.RIGHT);
		lblData.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblData.setText("Data");
		txtData = new Text(group, SWT.BORDER);
		txtData.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		lblCalendario = new Label(group, SWT.NONE);
		lblCalendario.setText("");
		lblCalendario.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/kloja/icones/calendario.gif")));

	}

}
