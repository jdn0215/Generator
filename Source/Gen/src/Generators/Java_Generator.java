/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generators;

import Components.Attribute;
import Components.Component;
import Components.File;
import Components._Class;
import Enums.TypeClass;
import Java.Java_Attribute;
import Java.Java_Class;
import Java.Java_File;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author jdani
 */
public class Java_Generator implements Generator{
    File file;
    _Class _class;
    public Java_Generator(HashMap<String,Java_Attribute >args,String pack,List<String>imports,String className,TypeClass t){
        this._class = new Java_Class(args,className,t);
        this.file = new Java_File(pack,imports,(Java_Class)this._class);
    }
    @Override
    public String gen() {
        return file.digest();
    }
    
}
