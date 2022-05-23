package version.control.system;

import artefact.Artefact;
import project.*;
import user.*;
import version.control.system.exceptions.*;

import java.util.*;

public class VersionControlSystemClass implements VersionControlSystem {

    //Instance variables.
    private final SortedMap<String, User> users;
    private final Map<String, Manager> managers;
    private final Map<String, List<Project>> projectByKeywords;
    private final LinkedHashMap<String, Project> projects;

    /**
     * Constructor.
     */
    public VersionControlSystemClass() {
        this.users = new TreeMap<>();
        this.managers = new HashMap<>();
        this.projectByKeywords = new HashMap<>();
        this.projects = new LinkedHashMap<>();
    }


    @Override
    public void registerUser(String jobPosition, String username, String managerUsername,
                             int clearanceLvl) throws JobPositionDoesNotExistException,
            UsernameAlreadyExistsException, ManagerUsernameDoesNotExistException {
        if (!hasJobPoisition(jobPosition)) throw new JobPositionDoesNotExistException();
        if (getUser(username) != null) throw new UsernameAlreadyExistsException();

        User user;

        if (jobPosition.equals(UserTypes.MANAGER.getText())) {
            user = new ManagerClass(username, clearanceLvl);
            managers.put(username, (Manager) user);
        } else {
            if (getManager(managerUsername) == null)
                throw new ManagerUsernameDoesNotExistException();

            user = new DeveloperClass(username, managerUsername, clearanceLvl);
            getManager(managerUsername).addDeveloper(user);
        }

        users.put(username, user);
    }

    @Override
    public Iterator<User> listAllUsers() {
        return users.values().iterator();
    }

    @Override
    public void registerProject(String managerUsername, String projectType, String projectName,
                                String[] keywords, String companyName, int confidentialityLvl)
            throws ProjectTypeDoesNotExistException, ManagerUsernameDoesNotExistException,
            ProjectNameAlreadyExistsException, InsuficientClearanceLevelException {
        if (!hasProjectType(projectType))
            throw new ProjectTypeDoesNotExistException();
        if (getManager(managerUsername) == null)
            throw new ManagerUsernameDoesNotExistException();
        if (getProject(projectName) != null)
            throw new ProjectNameAlreadyExistsException();

        Project project;
        if (projectType.equals(ProjectTypes.INHOUSE.getText())) {
            if (!hasClearanceLevel(managerUsername, confidentialityLvl))
                throw new InsuficientClearanceLevelException();

            project = new InhouseClass(managerUsername, projectName, keywords, confidentialityLvl);
        } else project = new OutsourcedClass(managerUsername, projectName, keywords, companyName);

        projects.put(projectName, project);

        for (String keyword :
                keywords) {
            List<Project> list = projectByKeywords.get(keyword);
            if (list == null) {
                list = new LinkedList<>();
                projectByKeywords.put(keyword, list);
            }
            list.add(project);
        }

        getManager(managerUsername).addProjectAsManager(project);
    }

    @Override
    public int getClearanceLvl(String username) {
        return getUser(username).getClearanceLvl();
    }

    @Override
    public Iterator<Project> listAllProjects() {
        return projects.values().iterator();
    }

    @Override
    public Iterator<String> addUsersToProject(String managerUsername, String projectName,
                                              String[] usernames) throws
            ManagerUsernameDoesNotExistException, ProjectNameDoesNotExistException,
            InvalidManagerException {
        if (getManager(managerUsername) == null)
            throw new ManagerUsernameDoesNotExistException();
        if (!(getProject(projectName) instanceof Inhouse project))
            throw new ProjectNameDoesNotExistException();
        if (!managerUsername.equals(getProjectManagerUsername(projectName)))
            throw new InvalidManagerException();

        String[] res = new String[usernames.length];
        for (int i = 0; i < usernames.length; i++) {
            String username = usernames[i];

            if (project.hasMember(username))
                res[i] = String.format(Output.ALREADY_MEMBER.getOutput(), username);
            else if (getUser(username) == null)
                res[i] = String.format(Output.USERNAME_DOES_NOT_EXIST.getOutput(), username);
            else if (project.getConfidentialityLvl() > getUser(username).getClearanceLvl())
                res[i] = String.format(Output.INSUFFICIENT_CLEARANCE.getOutput(), username);
            else {
                res[i] = String.format(Output.ADDED_TEAM.getOutput(), username);

                User user = getUser(username);

                project.addMember(user);
                user.addProjectAsMember(project);
            }
        }

        return Arrays.stream(res).iterator();
    }

    @Override
    public String getProjectManagerUsername(String projectName) {
        return getProject(projectName).getManagerUsername();
    }

    @Override
    public Iterator<String> addArtefactsToProject(String memberUsername, String projectName,
                                                  Artefact[] artefacts) throws
            UserDoesNotExistException, ProjectNameDoesNotExistException,
            UserDoesNotExistInProjectException {
        if (getUser(memberUsername) == null)
            throw new UserDoesNotExistException();
        if (!(getProject(projectName) instanceof Inhouse project))
            throw new ProjectNameDoesNotExistException();
        if (!project.hasMember(memberUsername))
            throw new UserDoesNotExistInProjectException();

        String[] res = new String[artefacts.length];

        for (int i = 0; i < artefacts.length; i++) {
            Artefact artefact = artefacts[i];

            if (project.hasArtefact(artefact.getName())) {
                res[i] = String.format(Output.ALREADY_IN_PROJECT.getOutput(), artefact.getName());
            } else if (artefact.getConfidentialityLvl() > project.getConfidentialityLvl()) {
                res[i] = String.format(Output.EXCEEDS_CONFIDENTIALITY.getOutput(),
                        artefact.getName());
            } else {
                res[i] = String.format(Output.ADDED_PROJECT.getOutput(), artefact.getName());

                project.addArtefact(artefact);
            }
        }

        return Arrays.stream(res).iterator();
    }

    private User getUser(String username) {
        return users.get(username);
    }

    private Manager getManager(String username) {
        return managers.get(username);
    }

    private boolean hasJobPoisition(String jobPosition) {
        return jobPosition.equals(UserTypes.MANAGER.getText()) ||
                jobPosition.equals(UserTypes.DEVELOPER.getText());
    }

    private boolean hasProjectType(String projectType) {
        return projectType.equals(ProjectTypes.INHOUSE.getText()) ||
                projectType.equals(ProjectTypes.OUTSOURCED.getText());
    }

    private Project getProject(String projectName) {
        return projects.get(projectName);
    }

    private boolean hasClearanceLevel(String managerUsername, int confidentialityLvl) {
        return getManager(managerUsername).getClearanceLvl() >= confidentialityLvl;
    }


}
