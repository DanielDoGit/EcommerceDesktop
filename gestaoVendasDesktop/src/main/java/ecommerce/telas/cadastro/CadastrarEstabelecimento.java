package ecommerce.telas.cadastro;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;

public abstract class CadastrarEstabelecimento {

	protected Shell shell;
	protected Shell pai;
	protected Text textEstabelecimento;
	protected Text textRazaoSocial;
	protected Text textCidade;
	protected Text textCnpj;
	protected CLabel labelIconePesquisar;
	protected Text textendereco;
	protected Text textNumero;
	protected Text textTelefone;
	protected Text textCelular;
	protected Button botaoGravar;
	protected Button botaoLimpar;
	
	public CadastrarEstabelecimento(Shell pai) {
		this.pai = pai;
		createContents();
	}
	
	/**
	 * Create contents of the window.
	 */
	private void createContents() {
		shell = new Shell(pai, SWT.APPLICATION_MODAL | SWT.SHELL_TRIM);
		shell.setSize(609, 385);
		shell.setText("Estabelecimento");
		GridLayout gl_shlEstabelecimento = new GridLayout(6, false);
		gl_shlEstabelecimento.verticalSpacing = 10;
		gl_shlEstabelecimento.marginBottom = 10;
		gl_shlEstabelecimento.marginRight = 10;
		gl_shlEstabelecimento.marginTop = 10;
		gl_shlEstabelecimento.marginLeft = 10;
		shell.setLayout(gl_shlEstabelecimento);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblEstabelecimento = new Label(shell, SWT.NONE);
		lblEstabelecimento.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, true, 3, 1));
		lblEstabelecimento.setText("Estabelecimento");
		
		textEstabelecimento = new Text(shell, SWT.BORDER);
		textEstabelecimento.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_CYAN));
		GridData gd_textEstabelecimento = new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1);
		gd_textEstabelecimento.widthHint = 461;
		textEstabelecimento.setLayoutData(gd_textEstabelecimento);
		
		Label lblRazosocial = new Label(shell, SWT.NONE);
		lblRazosocial.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, true, 3, 1));
		lblRazosocial.setText("Razão Social");
		
		textRazaoSocial = new Text(shell, SWT.BORDER);
		GridData gd_textRazaoSocial = new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1);
		gd_textRazaoSocial.widthHint = 461;
		textRazaoSocial.setLayoutData(gd_textRazaoSocial);
		
		Label lblCnpj = new Label(shell, SWT.NONE);
		lblCnpj.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, true, 3, 1));
		lblCnpj.setText("CNPJ");
		
		textCnpj = new Text(shell, SWT.BORDER);
		textCnpj.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_CYAN));
		GridData gd_textCnpj = new GridData(SWT.LEFT, SWT.CENTER, true, false, 3, 1);
		gd_textCnpj.widthHint = 228;
		textCnpj.setLayoutData(gd_textCnpj);
		
		Label lblTelefone = new Label(shell, SWT.NONE);
		lblTelefone.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, true, 3, 1));
		lblTelefone.setText("Telefone");
		
		textTelefone = new Text(shell, SWT.BORDER);
		GridData gd_textTelefone = new GridData(SWT.LEFT, SWT.CENTER, true, false, 3, 1);
		gd_textTelefone.widthHint = 166;
		textTelefone.setLayoutData(gd_textTelefone);
		
		Label lblCelular = new Label(shell, SWT.NONE);
		lblCelular.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, true, 3, 1));
		lblCelular.setText("Celular");
		
		textCelular = new Text(shell, SWT.BORDER);
		GridData gd_textCelular = new GridData(SWT.LEFT, SWT.CENTER, true, false, 3, 1);
		gd_textCelular.widthHint = 166;
		textCelular.setLayoutData(gd_textCelular);
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 6, 1));
		
		Label lblCidade = new Label(shell, SWT.NONE);
		lblCidade.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, true, 3, 1));
		lblCidade.setText("Cidade");
		
		textCidade = new Text(shell, SWT.BORDER);
		textCidade.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_CYAN));
		textCidade.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		labelIconePesquisar = new CLabel(shell, SWT.NONE);
		labelIconePesquisar.setImage(new Image(null,"./icones/search.png"));
		labelIconePesquisar.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		labelIconePesquisar.setText("");
		new Label(shell, SWT.NONE);
		
		Label lblEndereo = new Label(shell, SWT.NONE);
		lblEndereo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, true, 3, 1));
		lblEndereo.setText("Endereço");
		
		textendereco = new Text(shell, SWT.BORDER);
		GridData gd_textendereco = new GridData(SWT.LEFT, SWT.CENTER, true, false, 3, 1);
		gd_textendereco.widthHint = 284;
		textendereco.setLayoutData(gd_textendereco);
		
		Label lblN = new Label(shell, SWT.NONE);
		lblN.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, true, 3, 1));
		lblN.setText("Nº");
		
		textNumero = new Text(shell, SWT.BORDER);
		GridData gd_textNumero = new GridData(SWT.LEFT, SWT.CENTER, true, false, 3, 1);
		gd_textNumero.widthHint = 87;
		textNumero.setLayoutData(gd_textNumero);
		
		botaoLimpar = new Button(shell, SWT.NONE);
		GridData gd_botaoLimpar = new GridData(SWT.RIGHT, SWT.CENTER, false, true, 5, 1);
		gd_botaoLimpar.widthHint = 75;
		botaoLimpar.setLayoutData(gd_botaoLimpar);
		botaoLimpar.setText("Limpar");
		
		botaoGravar = new Button(shell, SWT.NONE);
		GridData gd_botaoGravar = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_botaoGravar.widthHint = 75;
		botaoGravar.setLayoutData(gd_botaoGravar);
		botaoGravar.setText("Gravar");
	}

}
