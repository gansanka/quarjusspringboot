package org.demo.service;

import javax.enterprise.context.Dependent;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@Dependent
public class ContainerResourceService implements IResourceService {

  @Override
  public String getResourceType() {
    return "Container";
  }

  @Override
  public JSONObject getResource() {
    JSONObject json = new JSONObject();
    json.put("type", "container");
    json.put("cloudProvider", "AWS");
    return json;
  }

}
