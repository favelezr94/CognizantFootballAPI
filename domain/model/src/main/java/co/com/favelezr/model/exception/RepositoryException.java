package co.com.favelezr.model.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RepositoryException extends Exception {
    private final RepositoryMessage repositoryMessage;
}
