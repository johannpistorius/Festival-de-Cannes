/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festival.de.cannes;

/**
 *
 * @author p1511158
 */
public class DAOException extends Exception{
    public DAOException(String message, Throwable cause){
        super(message, cause);
    }
    public DAOException(Throwable cause){
        super(cause);
    }
}
