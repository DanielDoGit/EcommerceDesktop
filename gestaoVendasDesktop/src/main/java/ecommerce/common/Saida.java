package ecommerce.common;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;

public class Saida {
	
	public static void exibirMensagem(Text text, String Mensagem) {
		try {
			MessageBox msg = new MessageBox(text.getShell());
			msg.setText("ECOMMERCE");
			msg.setMessage(Mensagem);
			msg.open();
			text.forceFocus();
			text.selectAll();
		} catch (Exception exe) {
			System.out.println(exe.getMessage());
		}
	}

	public static void exibirMensagem(Control c, String Mensagem) {
		try {
			MessageBox msg = new MessageBox(c.getShell());
			msg.setText("ECOMMERCE");
			msg.setMessage(Mensagem);
			msg.open();
			c.forceFocus();
		} catch (Exception exe) {
			System.out.println(exe.getMessage());
		}
	}

}
