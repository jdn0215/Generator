/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import java.util.HashMap;

/**
 *
 * @author jdani
 */
abstract public class _Class implements Component {
    protected String className;
    protected HashMap<String,? extends Attribute>attributes;
    public _Class(HashMap<String,? extends Attribute>attributes,String className){
        this.attributes = attributes;
        this.className = className;
    }
    @Override
    abstract public String digest();
}
