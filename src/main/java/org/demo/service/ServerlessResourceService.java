package org.demo.service;

import javax.enterprise.context.Dependent;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@Dependent
public class ServerlessResourceService implements IResourceService {

  @Override
  public String getResourceType() {
    return "Serverless";
  }

  @Override
  public JSONObject getResource() {
    JSONObject json = new JSONObject();
    json.put("type", "serverless");
    json.put("cloudProvider", "AWS");
    return json;
  }
}
