package org.youngweb.login.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.young.controller.ModelAndView;
import org.young.form.Document;
import org.young.form.Form;
import org.young.handler.YoungHandler;
import org.young.model.ErrorModel;
import org.young.util.StaticConstant;
import org.youngweb.dao.IUserDao;
import org.youngweb.model.User;

public class SubmitHandler extends YoungHandler {

	private Logger logger = Logger.getLogger(SubmitHandler.class);
	private IUserDao userDao;

	@Override
	public ModelAndView doHandle(HttpServletRequest request,
			HttpServletResponse response, Form form) {
		/* find the file uploaded */
		Document document = (Document) form.getProperty("photo");
		logger.info("name=>" + document.getName() + ",mimeType=>"
				+ document.getMimeType() + ",size=>" + document.getSize());
		/* core business */
		ErrorModel model = new ErrorModel();
		if (!validateSubmit(form)) {
			model.setError("用户名、密码不能为空 ");
			return new ModelAndView(model, "login/index.html");
		}
		String name = (String) form.getProperty("username");
		String password = (String) form.getProperty("password");
		User user = userDao.find(name);
		if (user == null || !user.getPassword().equals(password)) {
			model.setError("用户名或密码错误 ");
			model.setProperty("username", name);
			return new ModelAndView(model, "login/index.html");
		}
		setSessionAttribute(request, StaticConstant.SESSION_USER, user);
		/* print the user persisted */
		logger.info("id=>" + user.getId() + ",work=>" + user.getWork()
				+ ",password=>" + user.getPassword());
		Object obj = getSessionAttribute(request, StaticConstant.REQUEST_PATH);
		if (obj != null) {
			String path = (String) obj;
			return new ModelAndView(path, ModelAndView.ACTION_REDIRECT);
		} else {
			model.setSessionUser(user);
			model.setBasePath(basepath(request));
			return new ModelAndView(model, "login/somepage.html");
		}
	}

	private boolean validateSubmit(Form form) {
		Object username = form.getProperty("username");
		Object password = form.getProperty("password");
		if (username == null || password == null)
			return false;
		if ("".equals((String) username) || "".equals((String) password))
			return false;
		return true;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
}
