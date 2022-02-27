package co.com.favelezr.api.team;

import co.com.favelezr.api.team.responses.ErrorResponse;
import co.com.favelezr.api.team.responses.SuccessResponse;
import co.com.favelezr.api.team.validator.TeamDTO;
import lombok.experimental.UtilityClass;
import org.springdoc.core.fn.builders.operation.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY;
import static org.springdoc.core.fn.builders.apiresponse.Builder.responseBuilder;
import static org.springdoc.core.fn.builders.content.Builder.contentBuilder;
import static org.springdoc.core.fn.builders.parameter.Builder.parameterBuilder;
import static org.springdoc.core.fn.builders.requestbody.Builder.requestBodyBuilder;
import static org.springdoc.core.fn.builders.schema.Builder.schemaBuilder;

@UtilityClass
public class TeamOpenAPI {

    private static final String SUCCESS = "Sucess";
    private static final String ERROR = "Error";
    private static final String TEAM_MANAGEMENT = "Team Management";
    private static final String NAME = "name";

    public static Builder findAll(Builder builder) {
        return builder.operationId("FindAll")
                .tag(TEAM_MANAGEMENT)
                .description("Find all teams ordered by stadium capacity")
                .response(responseBuilder()
                        .description(SUCCESS)
                        .responseCode(HttpStatus.OK.toString())
                        .content(contentBuilder().mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation(SuccessResponse.class))))
                .response(responseBuilder()
                        .description(ERROR)
                        .responseCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                        .content(contentBuilder().mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation(ErrorResponse.class))));
    }

    public static Builder findByName(Builder builder) {
        return builder.operationId("Find")
                .tag(TEAM_MANAGEMENT)
                .description("Find a team by its name")
                .parameter(parameterBuilder().in(QUERY).name(NAME).required(true))
                .response(responseBuilder()
                        .description(SUCCESS)
                        .responseCode(HttpStatus.OK.toString())
                        .content(contentBuilder().mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation(SuccessResponse.class))))
                .response(responseBuilder()
                        .description(ERROR)
                        .responseCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                        .content(contentBuilder().mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation(ErrorResponse.class))));
    }

    public static Builder save(Builder builder) {
        return builder.operationId("save")
                .tag(TEAM_MANAGEMENT)
                .description("Save a team")
                .requestBody(requestBodyBuilder().implementation(TeamDTO.class))
                .response(responseBuilder()
                        .description(SUCCESS)
                        .responseCode(HttpStatus.OK.toString())
                        .content(contentBuilder().mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation(SuccessResponse.class))))
                .response(responseBuilder()
                        .description(ERROR)
                        .responseCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                        .content(contentBuilder().mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation(ErrorResponse.class))));
    }

    public static Builder update(Builder builder) {
        return builder.operationId("update")
                .tag(TEAM_MANAGEMENT)
                .description("Update a team")
                .requestBody(requestBodyBuilder().implementation(TeamDTO.class))
                .response(responseBuilder()
                        .description(SUCCESS)
                        .responseCode(HttpStatus.OK.toString())
                        .content(contentBuilder().mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation(SuccessResponse.class))))
                .response(responseBuilder()
                        .description(ERROR)
                        .responseCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                        .content(contentBuilder().mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation(ErrorResponse.class))));
    }

    public static Builder delete(Builder builder) {
        return builder.operationId("Delete")
                .tag(TEAM_MANAGEMENT)
                .description("Delete a team by its name")
                .parameter(parameterBuilder().in(QUERY).name(NAME).required(true))
                .response(responseBuilder()
                        .description(SUCCESS)
                        .responseCode(HttpStatus.OK.toString())
                        .content(contentBuilder().mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation(SuccessResponse.class))))
                .response(responseBuilder()
                        .description(ERROR)
                        .responseCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                        .content(contentBuilder().mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation(ErrorResponse.class))));
    }

}
