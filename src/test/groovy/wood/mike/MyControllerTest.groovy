package wood.mike

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class MyControllerSpec extends Specification {

    @Inject
    @Client("/")
    HttpClient client

    void 'test my team'() {
        when:
            TeamConfiguration teamConfiguration = client.toBlocking().retrieve(HttpRequest.GET("/my/team"), TeamConfiguration)
        then:
            teamConfiguration.name == 'INEOS Grenadiers'
            teamConfiguration.colour == 'Red and black'
        and:
            teamConfiguration.riders.size() == 2
            teamConfiguration.riders == ['Geraint Thomas', 'Tom Pidcock']
    }
}
