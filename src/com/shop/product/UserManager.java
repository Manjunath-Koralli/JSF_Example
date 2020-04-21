package com.shop.product;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;



@Named
@SessionScoped
public class UserManager implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UserService userService;
	
	private User currentUser;

    public boolean isSignedIn() {
        return currentUser != null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public String signIn(String username, String password) {
        User user = userService.getUser(username);
        if (user == null || !password.equals(user.getPassword())) {
        	//without configuring in faces-config.xml
            //return "sign-in"; 
        	
        	//if configured in faces-config.xml
        	return "failure";
        }

        currentUser = user;
        //without configuring in faces-config.xml
        //return "index";
        
        //if configured in faces-config.xml
        return "success";
    }

    public String signOut() {
        // End the session, removing any session state, including the current user and content of the shopping cart
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        /* Redirect is necessary to let the browser make a new GET request */
        return "index?faces-redirect=true";
        //without configuring in faces-config.xml return type of method will be STRING
        
        //if configured in faces-config.xml return type will be void
    }

    public String save(User user) {
        userService.saveUser(user);
        currentUser = user;
        //without configuring in faces-config.xml
        //return "index";
        
        //if configured in faces-config.xml
        return "home";
    }
	
}
