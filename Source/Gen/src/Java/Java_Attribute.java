/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import Components.Attribute;
import Enums.Types;

/**
 *
 * @author jdani
 */
abstract public class Java_Attribute extends Attribute{
    protected String defaultValue;
    protected Types type;
    protected String UpperId;
    public Java_Attribute(String id,String defaultValue){
        super(id);
        this.defaultValue = defaultValue;
        UpperId = this.setId();
    }

    @Override
    public String digest() {
        return id;
    }
    
    public String genDeclaration(){
        return "protected %s "+this.id+";\n";
    }
    public String genSet(){
         return "public void set"+UpperId+"(%s "+this.id+"){this."+this.id+"="+this.id+";}";
    }
    public String genGet(){
         return "public %s get"+UpperId+"(){return this."+this.id+";}";
    }
    public String constructorDefault(){
        return "this."+this.id+" = "+this.defaultValue+";";
    }
    abstract public String SetAndGet();
    abstract public String arg();
    public String initAtt(){
        return "\tthis.set"+this.UpperId+"("+this.id+");";
    }
    
    final String setId(){
        String aux = id;
        String temp = id.substring(0, 1);
        temp = temp.toUpperCase();
        aux = aux.substring(1,aux.length());
        return temp+aux;
    }
}
