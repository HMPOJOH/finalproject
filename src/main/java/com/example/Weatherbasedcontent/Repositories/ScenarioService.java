package com.example.Weatherbasedcontent.Repositories;

import java.util.List;

public class ScenarioService {

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
