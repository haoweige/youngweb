package org.youngweb.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.young.controller.InvokerController;
import org.young.controller.ModelAndView;
import org.young.form.Form;

public class AdminController extends InvokerController {

	private static final long serialVersionUID = 1L;

	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response, Form form) {
		return new ModelAndView("admin/index.html");
	}

}
