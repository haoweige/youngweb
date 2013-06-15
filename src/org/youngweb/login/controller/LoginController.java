package org.youngweb.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.young.controller.InvokerController;
import org.young.controller.ModelAndView;
import org.young.form.Form;
import org.young.ioc.factory.BeanFactory;
import org.youngweb.dao.IUserDao;
import org.youngweb.login.handler.SubmitHandler;

public class LoginController extends InvokerController {

	private static final long serialVersionUID = 1L;

	private SubmitHandler submitHandler;

	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response, Form form) {
		return new ModelAndView("login/index.html");
	}

	public ModelAndView submit(HttpServletRequest request,
			HttpServletResponse response, Form form) {
		dependenceInjected();
		return submitHandler.doHandle(request, response, form);
	}

	private void dependenceInjected() {
		SubmitHandler handler = (SubmitHandler) BeanFactory
				.getObject("submitHandler");
		IUserDao userDao = (IUserDao) BeanFactory.getObject("userDao");
		handler.setUserDao(userDao);
		this.setSubmitHandler(handler);
	}

	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response, Form form) {
		this.clearSessionAttribute(request);
		return new ModelAndView("login/index", ModelAndView.ACTION_REDIRECT);
	}

	public void setSubmitHandler(SubmitHandler submitHandler) {
		this.submitHandler = submitHandler;
	}

}
