# VersionControlSystem2
Deadline: Until 23h59 (Lisbon time) of June 03, 2022.


1.1 **Problem description**

  The objective of the work is the implementation of a version control system for a software house. This
system is responsible for managing changes to software projects which include computer programs,
documents, class diagrams, or other artefacts. Changes are identified by a number, termed the ”revision
number”. For example, an initial set of files is ”revision 1”. When the first change is made, the resulting
set is ”revision 2”, and so on. Each revision is associated with a timestamp and the employee making
the update. To simplify the development, each project artefact will have its own independent revision
number that starts with the number 1 and is incremented each time the artefact is updated, as discussed
before. Given that some projects developed have confidentiality concerns, in addition to managing
revisions, the system should also ensure that the personnel working on these projects have the necessary
clearance level. The application will support data on the employees, either software developers or project
managers, the projects and their associated artefacts, the definition of project teams of developers, and
the changes/updates made to project artefacts.

  **Users** For each registered user the system maintains the username (unique identifier) and their job
position. The job positions to be considered are a project manager and software developer. Company
personnel also maintain a clearance level, limiting the projects and artefacts that can be updated.
Software developers are associated with a project manager, responsible for managing their work. Project
managers are also responsible for creating new projects and associating a team for each project they
are managing. Developers work on the projects they were assigned by project managers, but project
managers can also work on projects that are not managed by them.

  **Project** Each project includes the following information: a unique identifier, the manager, and the
relevant keywords. There are two types of projects: in-house or outsourced. Outsourced projects have
no associated developing team, instead, it is just kept the name of the company developing the project.
In-house projects have a confidentiality level, a developing team, and associated artefacts.
Each artefact has the following information: an owner – the developer that added the artefact to the
project, a name that must be unique within the project, a description (e.g. java code, UML class diagram)
and a sequence of revisions. Each revision includes the username of the team member responsible for
updating the artefact, a date, and a short description of the revision.
[POO2122-TP02.v1.4.pdf](https://github.com/RodrigoRafaelSantos7/VersionControlSystem2/files/8710879/POO2122-TP02.v1.4.pdf)
