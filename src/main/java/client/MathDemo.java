package client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

/**
 * Created by rharris on 4/7/15.
 */
public class MathDemo implements EntryPoint {
	public void onModuleLoad() {
		GWT.log("OnModule Load");
		final HTML display = new HTML();
		display.setStyleName("display");

		Button setMathML = new Button("Set MathML");
		setMathML.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				display.setHTML(
						"<p><math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mfrac><mn>4</mn><mn>5</mn></mfrac></math></p>");
			}
		});
		GWT.log("Button 1 complete");
		Button jax = new Button("Jax It");
		jax.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				typeset(display.getElement());
			}
		});
		GWT.log("Button 2 complete");
		FlowPanel fp = new FlowPanel();
		fp.add(display);
		fp.add(setMathML);
		fp.add(jax);

			GWT.log("FP complete");
		RootPanel.get().add(fp);


	}

	private native void typeset(Element element) /*-{
		$wnd.jaxIt(element);
	}-*/;
}
