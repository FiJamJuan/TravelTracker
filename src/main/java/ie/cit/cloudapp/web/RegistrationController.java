/**
 * 
 */
package ie.cit.cloudapp.web;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import ie.cit.cloudapp.UserInfo;
import ie.cit.cloudapp.hashPassword;
import ie.cit.cloudapp.jdbcUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
;

/**
 * @author fiona
 * 
 */

@Controller
@RequestMapping("travel/login/registeruser")
public class RegistrationController {
	@Autowired
	private jdbcUserRepository userrepo;
	
	private UserInfo userinfo = new UserInfo();
	private Boolean userexists = false;

	
	@RequestMapping(method = RequestMethod.GET)
	public void main(Model model) {	
		//
		model.addAttribute("userexists",userexists);

	}

	@RequestMapping(params="home", method = RequestMethod.GET)
	public String home(Model model) {	
		//return to start/homepage
		return ("redirect:../../travel/login/main.html");    
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String registerUserData(Model model, @RequestParam String username,
			@RequestParam String pwd, @RequestParam String home,
			@RequestParam String email) throws IOException, NoSuchAlgorithmException {
		//add the user to the database
	   if (! SecurityContextHolder.getContext().getAuthentication().getName().isEmpty())
			//clear session data
	   SecurityContextHolder.getContext().setAuthentication(null);
	
		//first check if existing user.
		if (! userrepo.getUserData(username).isEmpty())
		{
			userexists = true;
			model.addAttribute("userexists",userexists);
			return ("redirect:../../travel/login/registeruser.html");    
		}
		// create md5 hash of password
		hashPassword hpw = new hashPassword();
		String pass = hpw.md5password(pwd);
		
		userinfo.setUsername(username);
		userinfo.setEmail(email);
		userinfo.setPwd(pass);
		userinfo.setHome(home);
		userrepo.save(userinfo);
	    ///return to login page
	    return ("redirect:../../travel/tracker/traveltracker.html");
	  

	}
}
