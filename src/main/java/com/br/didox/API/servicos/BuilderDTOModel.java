package com.br.didox.API.servicos;

import java.lang.reflect.InvocationTargetException;

import com.br.didox.API.interfaces.IObjectDTO;

public class BuilderDTOModel {
    public static Object build(IObjectDTO iObjectDTO) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException{
        return build(iObjectDTO, null);
    }

    public static Object build(IObjectDTO iObjectDTO, Object objectModel) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException{
        if(objectModel == null) objectModel = objectModel.getClass().getDeclaredConstructor().newInstance();

        for (var methodDTO : iObjectDTO.getClass().getMethods()) {
            if(methodDTO.getName().contains("get")){
                String prop = methodDTO.getName().replace("get", "");
                try{
                    var setMethod = objectModel.getClass().getMethod("set" + prop, new Class[] { String.class } );
                    var value = methodDTO.invoke(iObjectDTO);
                    setMethod.invoke(objectModel, value);
                }
                catch(Exception err) { }
            }
        }

        return objectModel;
    }
}
