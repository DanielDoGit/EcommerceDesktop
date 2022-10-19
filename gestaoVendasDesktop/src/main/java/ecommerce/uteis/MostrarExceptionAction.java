package ecommerce.uteis;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;

import ecommerce.common.Saida;
import ecommerce.common.SistemaUtil;
import limasoftware.uteis.Interface;

public class MostrarExceptionAction extends MostrarException {

	public MostrarExceptionAction(Shell pai, Exception ex) {
		super(pai);
		mostrarExcetion(ex);
		adicionarEventosButton();
		Interface.centralizarShell(janela);
		janela.open();
		Interface.manterJanelaModal(janela);
	}

	private void mostrarExcetion(Exception ex) {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PrintWriter pw = new PrintWriter(bos);
			ex.printStackTrace(pw);
			pw.flush();
			text.setText(new String(bos.toByteArray()));
			pw.close();
			bos.close();
		} catch (Exception j) {
		}
	}

	private void adicionarEventosButton() {
		btnSair.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				janela.close();
			}
		});
		btnSalvar.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				try {
					DirectoryDialog f = new DirectoryDialog(janela);
					String resultado = f.open();
					if (resultado != null) {
						Files.write(Paths.get(resultado).resolve("excecao.txt"), text.getText().getBytes());
						Saida.exibirMensagem(janela,"A exceção foi salva com sucesso no arquivo!");
					}
				} catch (Exception ex) {
					SistemaUtil.gravarLog(ex);
				}
			}
		});
	}

}