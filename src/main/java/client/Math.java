package client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

/**
 * Created by rharris on 4/7/15.
 */
public class Math implements EntryPoint {
	public void onModuleLoad() {
		ScriptInjector.fromUrl("http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=MML_HTMLorMML").inject();
		final HTML display = new HTML();
		display.setStyleName("display");

		Button setMathML = new Button("Set MathML");
		setMathML.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				display.setHTML(
						"<p><math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mfrac><mn>4</mn><mn>5</mn></mfrac></math></p>");
			}
		});
		Button jax = new Button("Jax It");
		jax.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				typeset(display.getElement());
			}
		});

		FlowPanel fp = new FlowPanel();
		fp.add(display);
		fp.add(setMathML);
		fp.add(jax);

		RootPanel.get().add(fp);


	}

	private native void typeset(Element element) /*-{
		MathJax.Hub.Queue(["Typeset", MathJax.Hub, element]);
	}-*/;
}
