package net.aaron2599.Features.Setting;

public class Setting<T> {

    protected T value;
    private Setting<?> parent;
    private final String name;
    private final String type;

    public Setting(String type, String name, T value){
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public Setting(Setting<?> parent, String type, String name, T value){
        this.parent = parent;
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    public T getValue(){
        return value;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Setting<?> getParent(){
        return parent;
    }

}
