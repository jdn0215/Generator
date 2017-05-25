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
public abstract class File implements Component{
    protected String data;
    public File(){
        this.data = "";
    }        
    @Override
    public String digest(){
        return data;
    }
    public void addData(String data){
        this.data += ('\n'+data);
    }
    abstract protected void initHeader();
}
