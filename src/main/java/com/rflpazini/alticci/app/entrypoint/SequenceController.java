package com.rflpazini.alticci.app.entrypoint;

import com.rflpazini.alticci.app.entrypoint.model.SequenceNumber;
import com.rflpazini.alticci.domain.usecase.FIndSequenceNumberUseCase;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;

@Controller("/alticci")
public class SequenceController {

    @Inject
    private FIndSequenceNumberUseCase composeSequence;

    @Get("/{n}")
    @Operation(summary = "Find the value in Alticci sequence for N",
            description = "Passing a number, we will apply the sequence formula and return the result"
    )
    @ApiResponse(responseCode = "200", description = "The number has been successfully calculated and returned the value of sequence",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(type = "SequenceNumber"))
    )
    @Tag(name = "calculate")
    public HttpResponse<SequenceNumber> get(@PathVariable final int n,
            @QueryValue boolean bestcase) {
        SequenceNumber sequenceNumber = new SequenceNumber();
        if (!bestcase) {
            sequenceNumber.setNumber(composeSequence.search(n));
        } else {
            sequenceNumber.setNumber(composeSequence.searchBest(n));
        }

        return HttpResponse.ok(sequenceNumber);
    }
}
