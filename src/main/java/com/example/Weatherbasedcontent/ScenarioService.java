package com.example.Weatherbasedcontent;

import com.example.Weatherbasedcontent.Repositories.Scenario;

import java.util.List;

public class ScenarioService {
//This service was added late in the process. Perhaps we should call it ParameterService
// and have the ScenarioList inside this Service. Rather autowire param repos inside this And pass forward in most cases
    //but in other cases have methods like below. Now when adding below method it's a bit tricky to follow the steps
    //also added qty in the service class pretty late..
    private List<Scenario> scenarios;



    public List<Scenario> updateScenarioQty(int[] listQTY, List<Scenario> scenarioList){

        for (int i=0;i<listQTY.length;i++){
            scenarioList.get(i).setQtyContent(listQTY[i]);
        }
        for (int i=0;i<listQTY.length;i++){
            System.out.println("scenario "+scenarioList.get(i).getId() +" count Content:" +  scenarioList.get(i).getQtyContent());
        }

        return scenarioList;
    }
}
