package org.youngweb.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.young.controller.InvokerController;
import org.young.controller.ModelAndView;
import org.young.form.Form;
import org.young.model.StaticizeModel;

public class MainController extends InvokerController {

	private static final long serialVersionUID = 1L;

	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response, Form form) {
		return new ModelAndView("htm/index.htm", ModelAndView.ACTION_REDIRECT);
	}

	 public ModelAndView staticize(HttpServletRequest request,
			HttpServletResponse response, Form form) {
		StaticizeModel model = new StaticizeModel();
		model.setPath("/htm/index2.htm");
		model.setProperty("somedata", "somevalue");
		return new ModelAndView(model, "common/index.html",
				ModelAndView.ACTION_STATICIZE);
	}

}
