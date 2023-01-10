package wood.mike

import groovy.transform.CompileStatic

@CompileStatic
class TeamAdmin {

    String manager
    String coach
    String physiotherapist

    private TeamAdmin() {
    }

    static Builder builder() {
        return new Builder()
    }

    static class Builder {
        String manager
        String coach
        String physiotherapist


        Builder withManager(String manager) {
            this.manager = manager
            this
        }

        Builder withCoach(String coach) {
            this.coach = coach
            this
        }

        Builder withPhysiotherapist(String physiotherapist) {
            this.physiotherapist = physiotherapist
            this
        }

        TeamAdmin build() {
            TeamAdmin teamAdmin = new TeamAdmin()
            teamAdmin.manager = this.manager
            teamAdmin.coach = this.coach
            teamAdmin.physiotherapist = this.physiotherapist
            teamAdmin
        }
    }
}
