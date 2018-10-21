/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import edu.unice.banque.entities.Personnee;
import edu.unice.banque.entities.Role;
import edu.unice.banque.session.AuthentificationBean;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author INES NASR
 */
@ManagedBean(name = "userLogin", eager = true)
@RequestScoped
public class UserLoginManagedBean implements Serializable {

    private String message = "Veillez entrer votre login et mot de passe SVP.";
    private String email;
    private String password;
    static Personnee personneConnectee;

    @EJB
    private AuthentificationBean authentificationBean;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Personnee getPersonneConnectee() {
        return personneConnectee;
    }

    public void setPersonneConnectee(Personnee personneConnectee) {
        this.personneConnectee = personneConnectee;
    }

    public String login() {

        Role r = authentificationBean.authentification(email, password);
        personneConnectee = authentificationBean.getPersonneParEmail(email);
        if (null == r) {
            message = "Wrong credentials.";
            return "index";
        } else {
            switch (r) {
                case ADMIN:
                    message = "Successfully logged-in as Admin.";
                    return "ajouterConseiller";
                case CONSEILLER:
                    message = "Successfully logged-in as CONSEILLER.";
                    return "creerCompte";
                case CLIENT:
                    message = "Successfully logged-in as CLIENT.";
                    return "listeComptesClient";
                default:
                    message = "Wrong credentials.";
                    return "index";
            }
        }
    }

}
