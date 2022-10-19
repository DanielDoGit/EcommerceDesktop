package ecommerce.common;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.time.LocalDate;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.hibernate.JDBCException;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import ecommerce.uteis.MostrarErroAction;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

@SuppressWarnings("restriction")
public class SistemaUtil {

	public static void exibirErro(Exception exe, Control control) {
		try {
			String mensagem = "";
			if (exe.getMessage() == null) {
				mensagem = "A mensagem retorna pela exceção é nula. A classe da exceção é: " + exe.getClass().getName();
			} else {
				mensagem = exe.getMessage();
			}
			if (exe instanceof JDBCException) {
				JDBCException je = (JDBCException) exe;
				String code = je.getSQLState();
				if (code.equals("23502") || code.equals("23503")) {
					mensagem = "O registro que você está excluindo já está sendo utilizado por outros registros...";
				} else if (code.equals("23505")) {
					mensagem = "O registro que você está incluindo ou alterando já existe...";
				} else if (code.equals("22001")) {
					mensagem = "Texto maior do que o tamanho suportado pelo banco de dados...";
				}
			}
			new MostrarErroAction(control.getShell(), mensagem, exe);
			control.forceFocus();
		} catch (Exception e) {
			gravarLog(e);
		}
	}

	public static void mostrarRelatorio(JasperPrint jasperPrint, String tituloJanela) throws Exception {

		JasperViewer jv = new JasperViewer(jasperPrint, false);
		jv.setTitle(tituloJanela);
		jv.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
		if (isMicrosoftWindowsOS()) {
			WindowsLookAndFeel wlf = new WindowsLookAndFeel();
			UIManager.setLookAndFeel(wlf);
			SwingUtilities.updateComponentTreeUI(jv);
		}
		jv.setVisible(true);

	}

	public static boolean isMicrosoftWindowsOS() {
		return System.getProperty("os.name").toUpperCase().contains("Windows".toUpperCase());
	}

	public static void gravarLog(Exception exe) {
		try {
			File file = new File("log.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			PrintWriter pw = new PrintWriter(file);
			pw.println("Data: " + LocalDate.now());
			exe.printStackTrace(pw);
			pw.flush();
			pw.close();
		} catch (Exception ex) {
			exe.printStackTrace();
		}
	}

	public static void copiarArquivo(String origem, String destino) throws Exception {
		FileInputStream fis = new FileInputStream(origem);
		FileOutputStream fos = new FileOutputStream(destino);
		FileChannel channelOut = fos.getChannel();
		ReadableByteChannel channelIn = Channels.newChannel(fis);
		channelOut.transferFrom(channelIn, 0, fis.available());
		channelIn.close();
		channelOut.close();
		fos.close();
	}

	public static Color getRGBColor(RGB color) {
		return getRGBColor(color.red, color.green, color.blue);
	}

	public static Color getRGBColor(int red, int green, int blue) {
		return new Color(Display.getCurrent(), red, green, blue);
	}

}
