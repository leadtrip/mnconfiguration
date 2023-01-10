package wood.mike

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.micronaut.context.annotation.ConfigurationBuilder
import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.serde.annotation.Serdeable

@Serdeable
@JsonIgnoreProperties("builder")
@ConfigurationProperties('team')
class TeamConfiguration {
    String name
    String colour
    List<String> riders

    @ConfigurationBuilder(prefixes = "with", configurationPrefix = "team-admin")
    TeamAdmin.Builder builder = TeamAdmin.builder()
}
