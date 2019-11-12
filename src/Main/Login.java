/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Viet
 */
public class Login {

    public static int authenticate(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return 2;
        } else if (username.equals("user") && password.equals("user")) {
            return 1;
        } else {
            return 0;
        }
    }
}
