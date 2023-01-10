package wood.mike

import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Named


@CompileStatic
@Controller("/my")
class MyController {

    TeamConfiguration teamConfiguration
    GrandTourConfiguration grandTourConfiguration

    MyController(TeamConfiguration teamConfiguration,
                 @Named('france') GrandTourConfiguration grandTourConfiguration ) {
        this.teamConfiguration = teamConfiguration
        this.grandTourConfiguration = grandTourConfiguration
    }

    @Get("/team")
    TeamConfiguration team() {
        this.teamConfiguration
    }

    @Get('/grandTour')
    GrandTourConfiguration grandTour() {
        this.grandTourConfiguration
    }
}
