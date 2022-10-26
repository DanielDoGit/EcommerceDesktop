package ecommerce.telas.comum;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

import limasoftware.uteis.Interface;

import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public abstract class Inicial {
	
	protected Shell shell;
	protected Shell pai;
	protected ProgressBar progressBar;
	
	public Inicial(Shell pai) {
		this.pai = pai;
		createContents();
	}
	
	/**
	 * Create contents of the window.
	 */

	private void createContents() {
		shell = new Shell(pai, SWT.APPLICATION_MODAL | SWT.SHELL_TRIM);
		shell.setSize(352, 99);
		shell.setText("Carregamento");
		GridLayout gl_shell = new GridLayout(1, false);
		gl_shell.verticalSpacing = 10;
		shell.setLayout(gl_shell);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblNewLabel.setText("Por favor aguarde...");
		
		progressBar = new ProgressBar(shell, SWT.INDETERMINATE);
		progressBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
	}
}
