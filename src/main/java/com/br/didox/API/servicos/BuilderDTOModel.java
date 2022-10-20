package com.br.didox.API.servicos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.br.didox.API.interfaces.IObjectDTO;

public class BuilderDTOModel {
    public static Object build(IObjectDTO iObjectDTO, Object objectModel) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        for (var methodDTO : iObjectDTO.getClass().getMethods()) {
            if(methodDTO.getName().contains("get")){
                String prop = methodDTO.getName().replace("get", "");
                var setMethod = getMethod(objectModel, "set" + prop);
                if(setMethod != null){
                    var value = methodDTO.invoke(iObjectDTO);
                    setMethod.invoke(objectModel, value);
                }
            }
        }

        return objectModel;
    }

    public static Method getMethod(Object objectModel, String methodName) {
        var methods = objectModel.getClass().getMethods();
        for (var method : methods) {
            if( method.getName().equals(methodName)){
                return method;
            }
        }
        return null;
    }
}
