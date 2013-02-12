package it.portus.addon.numberfield;

import it.portus.addon.numberfield.widgetset.shared.NumberFormat;
import it.portus.addon.numberfield.widgetset.shared.TextAlignment;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import com.vaadin.Application;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * @author Francesco Portus (portusgraphics@gmail.com)
 * 
 * @since 20/nov/2012
 */
@SuppressWarnings("serial")
public class NumberFieldApplication extends Application {

	private <N extends TextualNumberField<? extends Number>> AbstractComponent getComponent(final List<N> fields) {
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.setSpacing(true);
		verticalLayout.setSizeFull();

		{
			for (AbstractField f : fields) {
				VerticalLayout vLayout = new VerticalLayout();
				vLayout.setSizeFull();
				vLayout.setSpacing(true);

				HorizontalLayout valueLayout = new HorizontalLayout();
				valueLayout.setSizeFull();

				f.setSizeFull();
				vLayout.addComponent(f);
				vLayout.addComponent(valueLayout);
				vLayout.setComponentAlignment(valueLayout, Alignment.BOTTOM_LEFT);

				verticalLayout.addComponent(vLayout);
			}
		}

		return verticalLayout;
	}

	@Override
	public void init() {
		Window mainWindow = new Window("NumberField Application");
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.setSpacing(true);
		verticalLayout.setSizeFull();

		SpinnerNumberField<Integer> spinnerTest = new SpinnerNumberField<Integer>(Integer.class, "Number Field");

		spinnerTest.setValue(1000.00);
		spinnerTest.setAllowNegative(true);
		spinnerTest.setAllowNull(true);
		spinnerTest.setMaxVal(5000);
		spinnerTest.setMinVal(0);
		spinnerTest.setTextAlignment(TextAlignment.RIGHT);

		Locale brasilLocale = new Locale("pt", "BR");
		spinnerTest.setLocale(brasilLocale);

		spinnerTest.setInputPrompt("Inserire un Valore");

		final List<TextualNumberField<?>> allFields = new LinkedList<TextualNumberField<?>>();
		allFields.add(spinnerTest);

		List<TextualNumberField<Byte>> byteFields = new LinkedList<TextualNumberField<Byte>>();
		List<SpinnerNumberField<Byte>> byteSpinFields = new LinkedList<SpinnerNumberField<Byte>>();
		for (NumberFormat nt : NumberFormat.values()) {
			byteFields.add(new TextualNumberField<Byte>(Byte.class, Byte.class.getSimpleName() + " - " + nt.name(), nt));
			byteSpinFields.add(new SpinnerNumberField<Byte>(Byte.class, Byte.class.getSimpleName() + " - " + nt.name(), nt));
		}
		allFields.addAll(byteFields);
		allFields.addAll(byteSpinFields);

		List<TextualNumberField<Short>> shortFields = new LinkedList<TextualNumberField<Short>>();
		List<SpinnerNumberField<Short>> shortSpinFields = new LinkedList<SpinnerNumberField<Short>>();
		for (NumberFormat nt : NumberFormat.values()) {
			shortFields.add(new TextualNumberField<Short>(Short.class, Short.class.getSimpleName() + " - " + nt.name(), nt));
			shortSpinFields.add(new SpinnerNumberField<Short>(Short.class, Short.class.getSimpleName() + " - " + nt.name(), nt));
		}
		allFields.addAll(shortFields);
		allFields.addAll(shortSpinFields);

		List<TextualNumberField<Integer>> intFields = new LinkedList<TextualNumberField<Integer>>();
		List<SpinnerNumberField<Integer>> intSpinFields = new LinkedList<SpinnerNumberField<Integer>>();
		for (NumberFormat nt : NumberFormat.values()) {
			intFields.add(new TextualNumberField<Integer>(Integer.class, Integer.class.getSimpleName() + " - " + nt.name(), nt));
			intSpinFields.add(new SpinnerNumberField<Integer>(Integer.class, Integer.class.getSimpleName() + " - " + nt.name(), nt));
		}
		allFields.addAll(intFields);
		allFields.addAll(intSpinFields);

		List<TextualNumberField<Long>> longFields = new LinkedList<TextualNumberField<Long>>();
		List<SpinnerNumberField<Long>> longSpinFields = new LinkedList<SpinnerNumberField<Long>>();
		for (NumberFormat nt : NumberFormat.values()) {
			longFields.add(new TextualNumberField<Long>(Long.class, Long.class.getSimpleName() + " - " + nt.name(), nt));
			longSpinFields.add(new SpinnerNumberField<Long>(Long.class, Long.class.getSimpleName() + " - " + nt.name(), nt));
		}
		allFields.addAll(longFields);
		allFields.addAll(longSpinFields);

		List<TextualNumberField<Double>> doubleFields = new LinkedList<TextualNumberField<Double>>();
		List<SpinnerNumberField<Double>> doubleSpinFields = new LinkedList<SpinnerNumberField<Double>>();
		for (NumberFormat nt : NumberFormat.values()) {
			doubleFields.add(new TextualNumberField<Double>(Double.class, Double.class.getSimpleName() + " - " + nt.name(), nt));
			doubleSpinFields.add(new SpinnerNumberField<Double>(Double.class, Double.class.getSimpleName() + " - " + nt.name(), nt));
		}
		allFields.addAll(doubleFields);
		allFields.addAll(doubleSpinFields);

		List<TextualNumberField<Float>> floatFields = new LinkedList<TextualNumberField<Float>>();
		List<SpinnerNumberField<Float>> floatSpinFields = new LinkedList<SpinnerNumberField<Float>>();
		for (NumberFormat nt : NumberFormat.values()) {
			floatFields.add(new TextualNumberField<Float>(Float.class, Float.class.getSimpleName() + " - " + nt.name(), nt));
			floatSpinFields.add(new SpinnerNumberField<Float>(Float.class, Float.class.getSimpleName() + " - " + nt.name(), nt));
		}
		allFields.addAll(floatFields);
		allFields.addAll(floatSpinFields);

		GridLayout gridLayout = new GridLayout(6, 2);
		gridLayout.setSizeFull();
		gridLayout.setSpacing(true);
		int i = 0;
		gridLayout.addComponent(getComponent(byteFields), i, 0);
		gridLayout.addComponent(getComponent(shortFields), ++i, 0);
		gridLayout.addComponent(getComponent(intFields), ++i, 0);
		gridLayout.addComponent(getComponent(longFields), ++i, 0);
		gridLayout.addComponent(getComponent(doubleFields), ++i, 0);
		gridLayout.addComponent(getComponent(floatFields), ++i, 0);

		i = 0;
		gridLayout.addComponent(getComponent(byteSpinFields), i, 1);
		gridLayout.addComponent(getComponent(shortSpinFields), ++i, 1);
		gridLayout.addComponent(getComponent(intSpinFields), ++i, 1);
		gridLayout.addComponent(getComponent(longSpinFields), ++i, 1);
		gridLayout.addComponent(getComponent(doubleSpinFields), ++i, 1);
		gridLayout.addComponent(getComponent(floatSpinFields), ++i, 1);

		verticalLayout.addComponent(gridLayout);

		{
			HorizontalLayout hLayout = new HorizontalLayout();
			hLayout.setSpacing(true);

			HorizontalLayout valueLayout = new HorizontalLayout();

			hLayout.addComponent(spinnerTest);
			hLayout.addComponent(valueLayout);
			hLayout.setComponentAlignment(valueLayout, Alignment.BOTTOM_LEFT);

			verticalLayout.addComponent(hLayout);
		}
		{
			HorizontalLayout layout = new HorizontalLayout();
			layout.setSpacing(true);

			Button btnEnabled = new Button("Enabled", new ClickListener() {
				private boolean enable = true;

				@Override
				public void buttonClick(ClickEvent event) {
					enable = !enable;

					event.getButton().setCaption("Enabled [" + enable + "]");

					for (AbstractField f : allFields) {
						f.setEnabled(enable);
					}
				}
			});
			layout.addComponent(btnEnabled);
			layout.setComponentAlignment(btnEnabled, Alignment.BOTTOM_LEFT);

			Button btnReadonly = new Button("Read Only", new ClickListener() {
				private boolean readonly = false;

				@Override
				public void buttonClick(ClickEvent event) {
					readonly = !readonly;

					event.getButton().setCaption("Read Only [" + readonly + "]");

					for (AbstractField f : allFields) {
						f.setReadOnly(readonly);
					}
				}
			});
			layout.addComponent(btnReadonly);
			layout.setComponentAlignment(btnReadonly, Alignment.BOTTOM_LEFT);

			Button btnRepaint = new Button("Repaint", new ClickListener() {

				@Override
				public void buttonClick(ClickEvent event) {
					for (AbstractField f : allFields) {
						f.requestRepaint();
					}
				}
			});
			layout.addComponent(btnRepaint);
			layout.setComponentAlignment(btnRepaint, Alignment.BOTTOM_LEFT);

			Button btnValue = new Button("Value", new ClickListener() {

				@Override
				public void buttonClick(ClickEvent event) {
					event.getButton().setCaption("Value");

					Label label = null;
					for (AbstractField f : allFields) {
						String value = f.getValue() + "";
						if (f.getValue() != null) {
							value += " " + f.getValue().getClass().getSimpleName();
						}
						label = new Label(value);

						AbstractOrderedLayout parent = (AbstractOrderedLayout) f.getParent();
						HorizontalLayout valueLayout = ((HorizontalLayout) parent.getComponent(1));
						valueLayout.removeAllComponents();
						valueLayout.addComponent(label);
					}

				}
			});
			layout.addComponent(btnValue);
			layout.setComponentAlignment(btnValue, Alignment.BOTTOM_LEFT);

			verticalLayout.addComponent(layout);
		}

		mainWindow.addComponent(verticalLayout);
		setMainWindow(mainWindow);
	}
}
