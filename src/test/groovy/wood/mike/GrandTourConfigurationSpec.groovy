package wood.mike

import io.micronaut.context.ApplicationContext
import io.micronaut.inject.qualifiers.Qualifiers
import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

class GrandTourConfigurationSpec extends Specification{

    void "test grand tour configuration" () {
        given:
            ApplicationContext ctx = ApplicationContext.run(ApplicationContext, [
                    "grand-tour.bangor.start": '2023-12-01',
                    "grand-tour.bangor.location": 'Bus station',
                    "grand-tour.bangor.distance": 1928,
                    "grand-tour.seend.start": '2023-02-20',
                    "grand-tour.seend.location": 'Post office',
                    "grand-tour.seend.distance": 30
            ])
        when:
            GrandTourConfiguration bangorConfig = ctx.getBean(GrandTourConfiguration, Qualifiers.byName('bangor'))
            GrandTourConfiguration seendConfig = ctx.getBean(GrandTourConfiguration, Qualifiers.byName('seend'))
        then:
            bangorConfig.name == 'bangor'
            bangorConfig.start == LocalDate.of(2023, Month.DECEMBER, 1)
            bangorConfig.distance == 1928

            seendConfig.name == 'seend'
            seendConfig.start == LocalDate.of(2023, Month.FEBRUARY, 20)
            seendConfig.distance == 30
        cleanup:
            ctx.close()
    }

}
