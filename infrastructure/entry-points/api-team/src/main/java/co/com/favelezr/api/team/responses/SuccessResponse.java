package co.com.favelezr.api.team.responses;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class SuccessResponse {
    List<Object> data;
}
