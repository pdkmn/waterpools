package org.example.waterpools;

import java.util.Arrays;

public interface LandscapeValidator {

    default int minHeight() {
        return 0;
    }

    default int maxHeight() {
        return 32000;
    }

    default int positionCount() {
        return 32000;
    }

    default void validateLandscape(int[] landscape) {
        if (landscape == null || landscape.length == 0) {
            throw new ValidationException("landscape parameter is null or empty.");
        }

        if (landscape.length > positionCount()) {
            throw new ValidationException(String.format("Invalid landscape size %d points. Maximum point count is %d", landscape.length, positionCount()));
        }

        boolean heightsValid = ! Arrays.stream(landscape).anyMatch(h -> h < minHeight() || h > maxHeight());
        if (!heightsValid) {
            throw new ValidationException(String.format("Invalid height. Height must be in range [%d:%d].", minHeight(), maxHeight()));
        }
    }
}
