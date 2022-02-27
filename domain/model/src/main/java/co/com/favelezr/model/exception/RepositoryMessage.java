package co.com.favelezr.model.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RepositoryMessage {

    TEAM_NOT_FOUND("FTM01", "Team not found"),
    CREATE_TEAM_WRONG_DATA("FTM02", "Error creating the team, please check the values on the request"),
    CREATE_TEAM_GENERAL_ERROR("FTM03", "Error creating the team"),
    UPDATE_TEAM_NOT_FOUND("FTM04", "Error updating the team, team not found"),
    UPDATE_TEAM_GENERAL_ERROR("FTM05", "Error updating the team"),
    DELETE_TEAM_NOT_FOUND("FTM06", "Error deleting the team, team not found"),
    VALIDATION_ERROR("FTM07", "Error on request, please check the values on the request");

    private final String code;
    private final String message;
}
