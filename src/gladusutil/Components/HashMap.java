/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gladusutil.Components;

import static gladusutil.GladusUtil.getInteger;

/**
 *
 * @author csqueiroz
 */
public class HashMap extends java.util.HashMap<Object, Object>{
    
    public int getValueAsInt(Object key){
        return getInteger(get(key).toString());
    }
}
