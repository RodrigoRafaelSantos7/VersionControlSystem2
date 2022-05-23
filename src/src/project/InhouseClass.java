package project;

import artefact.Artefact;
import revision.Revision;
import user.User;

import java.util.*;

public class InhouseClass extends AbstractProject implements Inhouse {

    //Instance variables.
    private final int confidentialityLvl;
    private final LinkedHashMap<String, User> members;
    private final Map<String, Artefact> artefacts;
    private final Map<String, List<Artefact>> artefactsByMember;
    private final HashSet<Revision> revisions;

    public InhouseClass(String managerUsername, String projectName, String[] keywords,
                        int confidentialityLvl) {
        super(managerUsername, projectName, keywords);
        this.confidentialityLvl = confidentialityLvl;
        this.members = new LinkedHashMap<>();
        this.artefacts = new HashMap<>();
        this.artefactsByMember = new HashMap<>();
        this.revisions = new HashSet<>();
    }

    @Override
    public int getConfidentialityLvl() {
        return confidentialityLvl;
    }

    @Override
    public int getNumOfMembers() {
        return members.size();
    }

    @Override
    public int getNumOfArtefacts() {
        return artefacts.size();
    }

    @Override
    public int getNumOfRevisions() {
        return revisions.size();
    }

    @Override
    public boolean hasMember(String username) {
        return members.containsKey(username) || username.equals(managerUsername);
    }

    @Override
    public void addMember(User user) {
        members.put(user.getUsername(), user);
    }

    @Override
    public boolean hasArtefact(String artefactName) {
        return artefacts.containsKey(artefactName);
    }

    @Override
    public void addArtefact(Artefact artefact) {
        List<Artefact> list = artefactsByMember.get(artefact.getCreator());
        if (list == null) {
            list = new LinkedList<>();
            artefactsByMember.put(artefact.getCreator(), list);
        }
        list.add(artefact);

        artefacts.put(artefact.getName(),artefact);
    }


}
