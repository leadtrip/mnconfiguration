package wood.mike

import io.micronaut.context.annotation.EachProperty
import io.micronaut.context.annotation.Parameter
import io.micronaut.serde.annotation.Serdeable

import java.time.LocalDate

@Serdeable
@EachProperty('grand-tour')
class GrandTourConfiguration {
    String name
    LocalDate start
    String location
    Integer distance

    GrandTourConfiguration(@Parameter String name) {
        this.name = name
    }
}
