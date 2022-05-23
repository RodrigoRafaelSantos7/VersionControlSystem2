package project;

import artefact.Artefact;
import user.User;

public interface Inhouse extends Project {
    int getConfidentialityLvl();

    int getNumOfMembers();

    int getNumOfArtefacts();

    int getNumOfRevisions();

    boolean hasMember(String username);

    void addMember(User user);

    boolean hasArtefact(String artefactName);

    void addArtefact(Artefact artefact);
}
