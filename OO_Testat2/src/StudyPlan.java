import java.io.IOException;
import java.util.*;

public class StudyPlan {
    private Map<String, Module> Modules = new HashMap<>();

    public StudyPlan(String fileName) throws Exception {
        try (CatalogueReader reader = new CatalogueReader(fileName)) {
            fillModules(reader);
        }
    }

    public StudyPlan(List<String[]> lines) {
        fillModules(lines);
    }

    public void printSemesterPlan() throws PrerequisiteException {
        for (int i = 1; Modules.size() > 0; i++) {
            List<Module> currentModules = new ArrayList<>();

            currentModules = getAvailableModules();

            if(currentModules.size() == 0)
                throw new PrerequisiteException();

            removeCurrentModules(currentModules);

            System.out.println("Semester " + i + " " + getConcatenatedModuleNames(currentModules));
        }
    }

    /**
     * Remove modules visited in the current semester from the other modules' prerequisites and the module map
     * @param currentModules
     */
    public void removeCurrentModules(List<Module> currentModules) {
        for (Module currentModule : currentModules) {
            for (Module module : Modules.values()) {
                if (module.getPrerequisites().contains(currentModule)) {
                    module.getPrerequisites().remove(currentModule);
                }
            }

            Modules.remove(currentModule.getName());
        }
    }

    public static String getConcatenatedModuleNames(List<Module> modules) {
        String moduleNames = "";

        for (Module currentModule : modules) {
            moduleNames += currentModule.getName() + " ";
        }

        return moduleNames;
    }

    public List<Module> getAvailableModules() {
        List<Module> currentModules = new ArrayList<>();

        for (Module module : Modules.values()) {
            if (module.getPrerequisites().size() == 0) {
                currentModules.add(module);
            }
        }

        return currentModules;
    }

    public void fillModules(CatalogueReader reader) throws IOException {
        String[] line;
        List<String[]> lines = new ArrayList<>();

        while((line = reader.readNexteLine()) != null) {
            lines.add(line);
        }

        fillModules(lines);
    }

    public void fillModules(List<String[]> modules) {
        for(String[] newModules : modules) {
            Module topModule = null;
            Set<Module> prerequisites = new HashSet<>();

            for (int i = 0; i < newModules.length; i++) {
                String name = newModules[i];
                Module module = null;

                if ((module = Modules.get(name)) == null) {
                    module = new Module(name);
                    Modules.put(name, module);
                }

                if (i == 0) {
                    topModule = module;
                    continue;
                }

                prerequisites.add(module);
            }

            topModule.setPrerequisites(prerequisites);
        }
    }
}

