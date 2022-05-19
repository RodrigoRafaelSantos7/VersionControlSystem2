package user;

public interface Developer extends User {
    /**
     * @return - the number of projects of the developer.
     */
    int getNumberOfProjects();

    /**
     * @return - the username of the manager associated with the developer.
     */
    String getManagerUsername();
}
