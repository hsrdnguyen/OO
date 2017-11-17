public class SimulateGenerateStudyPlan {
    public static void main(String[] args) throws Exception {
        StudyPlan plan = new StudyPlan("StudyCatalogue.txt");
        plan.printSemesterPlan();
    }
}
