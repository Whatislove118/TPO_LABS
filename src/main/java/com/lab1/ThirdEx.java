package com.lab1;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class ThirdEx {
    Human Arthur;
    Human Ford;
    Human Anonchik;
    ArrayList<String> predictionActionResult;
    ArrayList<Human> humanArrayList;



    @Before
    public void setUpStory(){
        this.Arthur = new Human("Артур", null, null);
        this.Ford = new Human("Форд",
                new GlassFlask(
                        new Fish("золотая", "маленькая", "Дори")
                ), "Бетельгейзе"

        );
        this.Anonchik = new Human("Анончик", null, null);

        this.predictionActionResult = new ArrayList<>();
        this.predictionActionResult.add("Артур смотрит на Форда");
        this.predictionActionResult.add("Форд предлагает засунуть Дори в ухо");
        this.predictionActionResult.add("Действие неизвестно");

        this.humanArrayList = new ArrayList<>();
        this.humanArrayList.add(this.Arthur);
        this.humanArrayList.add(this.Ford);
        this.humanArrayList.add(this.Anonchik);

      

    }

    @Test
    public void testAction() {
       for (int i = 0; i<3; i++){
           Human human = this.humanArrayList.get(i);
           String predictResult = this.predictionActionResult.get(i);
           Assert.assertEquals(predictResult, human.action());
       }

    }

    @Test
    public void testArthurDream(){
        String predictResultArthurDream = "Он мечтает о пачке кукурузных хлопьев";
        Assert.assertEquals(predictResultArthurDream, Human.dream(this.Arthur));
    }

    @Test
    public void testHumansOrigin(){
        String predictOrigin;
        for (Human human: this.humanArrayList) {
            if (human.name.equals("Форд")){
                predictOrigin = "Бетельгейзе";
                Assert.assertEquals(predictOrigin, human.origin);
            }else{
                Assert.assertNull(human.origin);
            }
        }
    }

    @Test
    public void testHumansHandleObject(){
        for (Human human: this.humanArrayList){
            if (human.name.equals("Форд")){
                Assert.assertNotNull(human.handleObject);
                Assert.assertEquals(GlassFlask.class, human.handleObject.getClass());
            }else{
                Assert.assertNull(human.handleObject);
            }
        }
    }

    @Test
    public void testHandleObjectContains_NOT_NULL() {
        Assert.assertNotNull(((GlassFlask)this.Ford.handleObject).fish);
    }

    @Test
    public void testHandleObjectContains_CURRENT_FISH() {
        String predictFishInfo = "Содержит Дори цвета золотая размера маленькая";
        Assert.assertEquals(predictFishInfo, ((GlassFlask)this.Ford.handleObject).get_info());
    }


}


class Human {
    public String name;
    public HandleObject handleObject;
    public String origin;

    public Human(String name, HandleObject handleObject, String origin) {
        this.name = name;
        this.handleObject = handleObject;
        this.origin = origin;
    }

    public String action() {
        String result;
        switch (this.name){
            case "Артур":
                result = this.name + " смотрит на Форда";
                return result;
            case "Форд":
                return this.name + " предлагает засунуть " + ((GlassFlask)this.handleObject).fish.name + " в ухо";
            default:
                return "Действие неизвестно";
            }
        }

    public static String dream(Human who){
        if (who.name.equals("Артур")){
            return "Он мечтает о пачке кукурузных хлопьев";
        } else {
            return "Он ни о чем не мечтает";
        }
    }

}


interface HandleObject {

}

class Fish {
    public String color;
    public String size;
    public String name;

    public Fish(String color, String size, String name) {
        this.color = color;
        this.size = size;
        this.name = name;
    }


}

class GlassFlask implements HandleObject{
    public Fish fish;

    public GlassFlask(Fish fish) {
        this.fish = fish;
    }

    public String get_info() {
        return "Содержит " + this.fish.name + " цвета " + this.fish.color + " размера " + this.fish.size;
    }
}


