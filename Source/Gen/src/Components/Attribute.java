/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

/**
 *
 * @author jdani
 */
public abstract class Attribute implements Component {
    protected String id;
    public Attribute(String id){
        this.id = id;
    }
    @Override
    abstract public String digest();

    public String getId() {
        return id;
    }
    
}
