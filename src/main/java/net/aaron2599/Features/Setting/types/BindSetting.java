package net.aaron2599.Features.Setting.types;

import net.aaron2599.Features.Setting.Setting;

public class BindSetting extends Setting<Integer> {

    private boolean binding = false;

    public BindSetting(int bind){
        super("Bind", "bind", bind);
    }

    public boolean getBinding(){
        return binding;
    }

    public void setBinding(boolean binding){
        this.binding = binding;
    }

    public void setBind(int bind) {
        this.value = bind;
    }

}
