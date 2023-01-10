package wood.mike

import io.micronaut.context.ApplicationContext
import spock.lang.Specification

class TeamConfigurationSpec extends Specification{

    void "test team configuration"() {
        given:
            def teamName = 'Chippenham Wheelers'
            def teamColour = 'Yellow'
            def riders = ['Chunky Monkey', 'Chester Draws']
            ApplicationContext ctx = ApplicationContext.run(ApplicationContext, [
                    "team.name": teamName,
                    "team.colour": teamColour,
                    "team.riders": riders
            ])
        when:
            TeamConfiguration teamConfiguration = ctx.getBean(TeamConfiguration)
        then:
            teamConfiguration.name == teamName
            teamConfiguration.colour == teamColour
            teamConfiguration.riders[0] == riders[0]
            teamConfiguration.riders[1] == riders[1]
        cleanup:
            ctx.close()
    }

    void "test team configuration admin configuration builder "() {
        given:
            def teamName = 'Chippenham Wheelers'
            def teamColour = 'Yellow'
            def riders = ['Chunky Monkey', 'Chester Draws']
            def manager = 'Rich short'
            def coach = 'Claire long'
            def physio = 'Hex wrench'
            ApplicationContext ctx = ApplicationContext.run(ApplicationContext, [
                    "team.name": teamName,
                    "team.colour": teamColour,
                    "team.riders": riders,
                    "team.team-admin.manager": manager,
                    "team.team-admin.coach": coach,
                    "team.team-admin.physiotherapist": physio
            ])

        when:
            TeamConfiguration teamConfiguration = ctx.getBean(TeamConfiguration)
            TeamAdmin teamAdmin = teamConfiguration.builder.build()

        then:
            teamConfiguration.name == teamName
            teamConfiguration.colour == teamColour
            teamConfiguration.riders[0] == riders[0]
            teamConfiguration.riders[1] == riders[1]

            // check the builder has values set
            teamConfiguration.builder.manager == manager
            teamConfiguration.builder.coach == coach
            teamConfiguration.builder.physiotherapist == physio

            // check the object can be built
            teamAdmin.manager == manager
            teamAdmin.coach == coach
            teamAdmin.physiotherapist == physio

        cleanup:
            ctx.close()
    }
}
