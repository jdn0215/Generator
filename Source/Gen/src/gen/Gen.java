/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gen;

import Components._Class;
import Enums.TypeClass;
import Generators.Generator;
import Generators.Java_Generator;
import Java.Java_Attribute;
import Java.Java_Class;
import Java.Java_String;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jdani
 */
public class Gen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Java_Attribute att = new Java_String("prueba","\"\"",null);
        Java_Attribute att2 = new Java_String("prueba2","\"\"",null);
        HashMap<String,Java_Attribute>map= new HashMap<>();
        map.put("prueba2", att2);
        map.put("prueba", att);
        ArrayList<String>l = new ArrayList<>();
        l.add("import java.util.ArrayList;");
        Generator g = new Java_Generator(map,"Prueba",l,"Prueba",TypeClass.Public); 
        System.out.print(g.gen());
    }
    
}
