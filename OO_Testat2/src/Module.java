import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Module {
    private String name;

    private Set<Module> Prerequisites = new HashSet<>();

    public Module(String name) {
        setName(name);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Module))
            return false;

        Module otherModule = (Module)other;
        return getName().equals(otherModule.getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Module> getPrerequisites() {
        return Prerequisites;
    }

    public void setPrerequisites(Set<Module> prerequisites) {
        Prerequisites = prerequisites == null ? new HashSet<>() : prerequisites;
    }
}
