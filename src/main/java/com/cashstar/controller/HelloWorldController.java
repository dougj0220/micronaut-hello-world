package com.cashstar.controller;

import com.cashstar.entity.HelloWorld;
import com.cashstar.service.HelloWorldService;
import com.cashstar.util.ApiResponse;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

@RequiredArgsConstructor
@Controller("/hello")
public class HelloWorldController {

    private final static Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);

    @Inject
    private final HelloWorldService helloWorldService;

    @Get("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<HelloWorld> findAll() {
        LOG.info("find all hello world");
        return helloWorldService.findAll();
    }

    @Get("/find/{text}")
    @Produces(MediaType.APPLICATION_JSON)
    public HelloWorld findByText(String text) {
        LOG.info("rest findByText: {}", text);
        return helloWorldService.findByText(text);
    }

    @Post()
    @Produces(MediaType.APPLICATION_JSON)
    public HelloWorld save(@Body HelloWorld hellWorld) {
        LOG.info("rest saving new HelloWorld entity");
        return helloWorldService.save(hellWorld);
    }

    @Delete("/{id}")
    public HttpResponse delete(Long id) {
        LOG.info("deleting hello world by id: {}", id);
        // TODO: fix me and wrap ApiResponse --> HttpResponseWrapper or something like this
        ApiResponse<Boolean> apiResponse = new ApiResponse<>("HelloWorld domain delete response",
                helloWorldService.delete(id));
        return HttpResponse.ok(apiResponse);
    }
}
