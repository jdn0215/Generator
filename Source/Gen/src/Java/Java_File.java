/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import Components.File;
import java.util.List;

/**
 *
 * @author jdani
 */
public class Java_File extends File{
    String pack;
    List<String>imports;
    Java_Class _class;
    public Java_File(String pack,List<String>imports,Java_Class _class){
        super();
        this.pack = pack;
        this.imports = imports;
        this._class = _class;
        this.initHeader();
    }
    @Override
    protected final void initHeader(){
        super.addData("package "+this.pack+";\n");
        this.imports.forEach(x->super.addData("import "+x));
    }
    
    @Override
    public String digest(){
        super.addData(this._class.digest());
        return super.digest();
    }
    
}
