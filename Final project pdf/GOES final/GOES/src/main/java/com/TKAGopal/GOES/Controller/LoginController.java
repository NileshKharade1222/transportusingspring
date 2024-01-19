	 package com.TKAGopal.GOES.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TKAGopal.GOES.Model.Contact;
import com.TKAGopal.GOES.Model.Login;

@Controller
public class LoginController {

	@Autowired
	SessionFactory sf;
	
	
	// login.jsp // User / Admin

	@RequestMapping("loginpage") // API
	public String loginpage() {
		return "login"; // pages
	}//login page open

	@RequestMapping("loginp") // API
	public String loginp(Login login, Model model) {
		Session s = sf.openSession();
		Login dlogin = s.get(Login.class, login.getPassword()); // PK

		String page = "login";

		String msg = null;

		if (dlogin != null) {
			if (login.getUsername().equals(dlogin.getUsername())) {
				msg = "welcome";
				page = "home";
			} else {
				msg = "Invalid U and P";
			}
		} else {
			msg = "Invalid U and P";
		}

		model.addAttribute("msg", msg);
		return page;
	} // action check your u and p right/ wrong in database relation

	// createAccount.jsp

	@RequestMapping("createaccount") // API
	public String createaccount() {
		return "createAccount"; // pages
	} // open/show

	@RequestMapping("createaccountdata") // API
	public String createaccountdata(Login login) {

		Session s = sf.openSession();
		Login dlogin = s.get(Login.class, login.getPassword()); // PK
		String page = "login";
		String msg = null;

		if (dlogin != null) {
			if (login.getUsername().equals(dlogin.getUsername())) {
				msg = "Already Register this U and P";
			}
		} else {
			Transaction t = s.beginTransaction();
			s.save(login); // username / password
			t.commit();
		}

		return "createAccount"; // pages
	} // action check you duplicate password and username 

	// home.jsp

	@RequestMapping("homepage") // API
	public String homePage() {
		return "home"; // pages
	} // show

	// about.jsp

	@RequestMapping("aboutpage") // API
	public String aboutPage() {
		return "about"; // pages
	} // show

	// service.jsp

	@RequestMapping("servicepage") // API
	public String servicePage() {
		return "service"; // pages
	} // show

	// contact.jsp

	// condition
	// 1) Already U and P
	// 2) Already mobile
	// 3) Already email

	@RequestMapping("contactpage") // API
	public String contactPage() {
		return "contact"; // pages
	} // show

	@RequestMapping("contactdata") // API
	public String contactdata(Contact contact) {
		Session s = sf.openSession();

		Contact dlogin = s.get(Contact.class, contact.getMobile()); // PK
		String page = "login";
		String msg = null;

		if (dlogin != null) {
			if (contact.getEmail().equals(dlogin.getEmail())) {
				msg = "Already Register this E and M";
			}
		} else {
			Transaction t = s.beginTransaction();
			s.save(contact); // username / password
			t.commit();
		}

		return "contact"; // pages
	} // action chack you dupl e and m

	// APIs
	//

}
