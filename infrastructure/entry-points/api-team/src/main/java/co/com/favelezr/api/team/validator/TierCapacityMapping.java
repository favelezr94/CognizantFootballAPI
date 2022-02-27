package co.com.favelezr.api.team.validator;

import java.util.Map;

public final class TierCapacityMapping {
    public static final Map<String, Integer> capacityByTier = Map.ofEntries(Map.entry("1", 50000),
            Map.entry("2", 10000),
            Map.entry("3", 3000)
    );

}
