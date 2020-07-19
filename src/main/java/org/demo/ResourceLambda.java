package org.demo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.demo.service.ContainerResourceService;
import org.demo.service.IResourceService;
import org.demo.service.ServerlessResourceService;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPEvent;

@Named("getResource")
public class ResourceLambda implements RequestHandler<APIGatewayV2HTTPEvent, String> {

  @Autowired
  ServerlessResourceService defaultService;

  @Autowired
  ContainerResourceService containerService;

  @Override
  public String handleRequest(APIGatewayV2HTTPEvent input, Context context) {
    List<IResourceService> serviceList = new ArrayList<>();
    serviceList.add(defaultService);
    serviceList.add(containerService);

    String type = input.getQueryStringParameters().get("getType");
    System.out.println("Input ::: " + type);
    IResourceService service = serviceList.stream().filter(item -> item.getResourceType().equalsIgnoreCase(type))
        .findFirst().orElse(defaultService);

    return service.getResource().toString();
  }

}
