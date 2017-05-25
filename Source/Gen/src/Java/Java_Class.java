/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import Components._Class;
import Enums.TypeClass;
import java.util.HashMap;

/**
 *
 * @author jdani
 */
public class Java_Class extends _Class{
    TypeClass typeClass;
    public Java_Class(HashMap<String,Java_Attribute>attributes,String className,TypeClass t){
        super(attributes,className);
        this.typeClass = t;
    }
    @Override
    public String digest() {
        String out;
        if(null == this.typeClass)
            out = "protected";
                    
        else  switch (this.typeClass) {
            case Private:
                out= "private";
                break;
            case Public:
                out= "public";
                break;
            default:
                out = "protected";break;
        }
        out+= " class "+super.className+" extends Data{\n";
        out = super.attributes.keySet().stream().map((k) -> (Java_Attribute)super.attributes.get(k)).map((att) -> att.genDeclaration()).reduce(out, String::concat);
        out+= this.Constructor();
        out+=this.ConstructorDefault();
        String temp="";
        temp = super.attributes.keySet().stream().map((k) -> (Java_Attribute)super.attributes.get(k)).map((att) -> att.SetAndGet()).reduce(temp, String::concat);
        out+=temp;
        out+="}\n";
        return out;
    }
    public String ConstructorDefault(){
        String out = "public "+super.className+"(){\n";
        out = super.attributes.keySet().stream().map((k) -> (Java_Attribute)super.attributes.get(k)).map((att) -> "\t"+att.constructorDefault()+"\n").reduce(out, String::concat);
        out+="}\n";
        return out;
    }
    public String Constructor(){
        String out = "public "+super.className;
        out+=(args()+"throws Exception{\n\ttry{\n");
        out = super.attributes.keySet().stream().map((k) -> (Java_Attribute)super.attributes.get(k)).map((att) -> att.initAtt()+"\n").reduce(out, String::concat);
        out+="\t}catch(Exception e){\n";
        out+="\t\tthrow e;\n\t}\n";
        out+="}\n";
        return out;
    }
    public String args(){
        String out = "(";
        Object[]s = super.attributes.keySet().toArray();
        for(int i = 0;i<s.length;i++){
            Java_Attribute att = (Java_Attribute)super.attributes.get((String)s[i]);
            out+= att.arg();
            if(i!=s.length-1)
                out+=", ";
        }
        out+=")";
        return out;
    }
    
}
