/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import java.util.regex.Pattern;

/**
 *
 * @author jdani
 */
public class Java_String extends Java_Attribute{
    Pattern expr;
    public Java_String(String id, String defaultValue,Pattern expr) {
        super(id, defaultValue);
        this.expr = expr;
    }
    @Override
    public String genDeclaration() {
        return String.format(super.genDeclaration(),"String");
    }

    
    @Override
    public String genSet(){
        if(this.expr == null)
            return String.format(super.genSet(),"String");
        //throw  new Exception("");
       return "public void set"+UpperId+"(%s "+this.id+")throws Exception{\n"
               + "Pattern pat = Pattern.compile(\""+this.expr.toString()+"\");\n"
               + "Matcher mat = pat.matcher("+this.id+");\n"
               + "if (mat.matches()) this."+this.id+"="+this.id+";"
               + "else throw new Exception(\"Error en la expresion regular "+this.expr.toString()+"\");";
    }
    
    @Override
    public String genGet() {
        return String.format(super.genGet(),"String");
    }

    @Override
    public String SetAndGet() {
        return this.genGet()+"\n"+this.genSet();
    }

    @Override
    public String arg() {
        return "String "+this.id;
    }
  
}
