package ecommerce.uteis;

import java.util.Calendar;

import java.util.Date;
import java.util.GregorianCalendar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import limasoftware.conversao.ConverteDatas;
import limasoftware.teclas.Enter;

public class Calendario {

	private Shell sShell;
	private DateTime dateTime;
	private Text text;
	private CLabel cLabel;
	private String formato;

	public Calendario(Text text) {
		this.text = text;
		formato = "dd/MM/yyyy";
		inicializar();
	}

	private void inicializar() {
		createSShell();
		Date data = ConverteDatas.convertDateUserBean(text.getText());
		if (data != null) {
			Calendar calendar = GregorianCalendar.getInstance();
			calendar.setTime(data);
			dateTime.setYear(calendar.get(Calendar.YEAR));
			dateTime.setMonth(calendar.get(Calendar.MONTH));
			dateTime.setDay(calendar.get(Calendar.DAY_OF_MONTH));
		}
		int x = Display.getCurrent().getCursorLocation().x - (sShell.getSize().x / 2);
		int y = Display.getCurrent().getCursorLocation().y - (sShell.getSize().y / 2);
		sShell.setLocation(x, y);
		sShell.open();
	}

	private void createSShell() {
		sShell = new Shell(text.getShell(), SWT.SHELL_TRIM | SWT.APPLICATION_MODAL);
		sShell.setText("Calendário");
		sShell.setSize(new Point(256, 246));
		GridLayout gl_sShell = new GridLayout(1, false);
		gl_sShell.marginBottom = 5;
		gl_sShell.marginTop = 5;
		gl_sShell.marginRight = 5;
		gl_sShell.marginLeft = 5;
		sShell.setLayout(gl_sShell);
		dateTime = new DateTime(sShell, SWT.CALENDAR | SWT.BORDER);
		dateTime.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		cLabel = new CLabel(sShell, SWT.NONE);
		cLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		cLabel.setAlignment(SWT.CENTER);
		cLabel.setText("Aceitar");
		cLabel.setImage(new Image(Display.getCurrent(), "./icones/aceitar.png"));
		cLabel.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				selecionarData();
			}
		});
		dateTime.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (Enter.isTeclaEnter(e.keyCode)) {
					selecionarData();
				}
			}
		});
	}

	private void selecionarData() {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.set(Calendar.YEAR, dateTime.getYear());
		calendar.set(Calendar.MONTH, dateTime.getMonth());
		calendar.set(Calendar.DAY_OF_MONTH, dateTime.getDay());
		text.setText(ConverteDatas.convDateBeanUser(calendar.getTime(), formato));
		sShell.close();
		text.forceFocus();
		text.selectAll();
	}

}
