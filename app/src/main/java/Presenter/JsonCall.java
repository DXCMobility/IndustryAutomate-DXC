package Presenter;



import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import Pojo.Assembly_cooling_fan;
import Pojo.Assembly_line;
import Pojo.F1_bulbs;
import Pojo.F2_bulbs;
import Pojo.Generic_fan;
import Pojo.Humidity;
import Pojo.Industry;
import Pojo.Industry2;
import Pojo.Power_consumption;
import Pojo.Sound;
import Pojo.Temp;
import Pojo.Windmill;

/**
 * Created by pateniku on 2/7/2017.
 */

public class JsonCall {

    private String Const_Industry = "industry";
    private String ConstAssembly_cooling_fan = "assembly_cooling_fan";
    private String Const_Assembly_line = "assembly_line";
    private String Const_F1_bulbs = "f1_bulbs";
    private String Const_Generic_fan = "generic_fan";
    private String Const_Humidity = "humidity";
    private String Const_Temp = "temp";
    private String Const_PowerConsumption = "power_consumption";
    private String Const_F2_bulbs = "f2_bulbs";
    private String Const_Sound = "sound";
    private String Const_Windmill = "windmill";
    private String Const_Generated_power = "generated_power";
    private String Const_Status = "status";
    private String Const_Value = "value";


    /*private com.example.pateniku.demoiot.Pojo.Assembly_cooling_fan assembly_cooling_fan;
    private com.example.pateniku.demoiot.Pojo.Humidity humidity;
    private com.example.pateniku.demoiot.Pojo.Assembly_line assembly_line;
    private com.example.pateniku.demoiot.Pojo.Temp temp;
    private com.example.pateniku.demoiot.Pojo.F1_bulbs[] f1_bulbs;
    private com.example.pateniku.demoiot.Pojo.Generic_fan generic_fan;*/


    public ArrayList<Industry> getAutoMacData(JSONObject jsonObject) {
        try {

            JSONArray alSportyDetail = jsonObject.getJSONArray(Const_Industry);
            /*JSONArray jsonArrF2B  = jsonObject.getJSONArray(ContF2_bulbs);*/


                ArrayList<Industry> alIndustry = new ArrayList<Industry>();
                Industry industry = new Industry();
                JSONObject objIndus = alSportyDetail.getJSONObject(0);

                //// Assembly Cooling Fan v/////
                Assembly_cooling_fan objAssembly_cooling_fan = new Assembly_cooling_fan();
                JSONObject objAssembly = objIndus.getJSONObject(ConstAssembly_cooling_fan);
                objAssembly_cooling_fan.setStatus(objAssembly.getString(Const_Status));
                objAssembly_cooling_fan.setValue(objAssembly.getString(Const_Value));
                industry.setAssembly_cooling_fan(objAssembly_cooling_fan);


                //// Assembly_line"
                Assembly_line objAssembly_line = new Assembly_line();
                JSONObject objAssemblyLine = objIndus.getJSONObject(Const_Assembly_line);
                objAssembly_line.setStatus(objAssemblyLine.getString(Const_Status));
                objAssembly_line.setValue(objAssemblyLine.getString(Const_Value));
                industry.setAssembly_line(objAssembly_line);


                /////f1_bulbs

                JSONArray jsonArrF1Bul = objIndus.getJSONArray(Const_F1_bulbs);
                F1_bulbs[] f1_bulbs = new F1_bulbs[jsonArrF1Bul.length()];
                for (int f1Bulb = 0; f1Bulb < jsonArrF1Bul.length(); f1Bulb++) {
                    F1_bulbs objF1_bulbs = new F1_bulbs();
                    JSONObject objF1Bulb = jsonArrF1Bul.getJSONObject(f1Bulb);
                    objF1_bulbs.setStatus(objF1Bulb.getString(Const_Status));
                    objF1_bulbs.setValue(objF1Bulb.getString(Const_Value));
                    f1_bulbs[f1Bulb] = objF1_bulbs;
                }
                industry.setF1_bulbs(f1_bulbs);

                //////Generic_fan
                Generic_fan generic_fan = new Generic_fan();
                JSONObject objgeneric_fan= objIndus.getJSONObject(Const_Generic_fan);
                generic_fan.setStatus(objgeneric_fan.getString(Const_Status));
                generic_fan.setValue(objgeneric_fan.getString(Const_Value));
                industry.setGeneric_fan(generic_fan);

                /////humidity
                Humidity humidity = new Humidity();
                JSONObject objHumidity= objIndus.getJSONObject(Const_Humidity);
                humidity.setStatus(objHumidity.getString(Const_Status));
                humidity.setValue(objHumidity.getString(Const_Value));
                industry.setHumidity(humidity);


                /////Temp
                Temp temp = new Temp();
                JSONObject objTemp= objIndus.getJSONObject(Const_Temp);
                temp.setStatus(objTemp.getString(Const_Status));
                temp.setValue(objTemp.getString(Const_Value));
                industry.setTemp(temp);



            String str=objIndus.getString(Const_PowerConsumption);

            industry.setPower_consumption(str);




                //===============================================================

//                Industry2 industry2 = new Industry2();
//                ////f2_bulbs
//                JSONObject objIndus2 = alSportyDetail.getJSONObject(1);
//                JSONArray jsonArrF2Bul = objIndus2.getJSONArray(Const_F2_bulbs);
//                F2_bulbs[] f2_bulbs = new F2_bulbs[jsonArrF2Bul.length()];
//                for (int f2Bulb = 0; f2Bulb < jsonArrF2Bul.length(); f2Bulb++) {
//                    F2_bulbs objF2_bulbs = new F2_bulbs();
//                    JSONObject objF2Bulb = jsonArrF2Bul.getJSONObject(f2Bulb);
//                    objF2_bulbs.setStatus(objF2Bulb.getString(Const_Status));
//                    objF2_bulbs.setValue(objF2Bulb.getString(Const_Value));
//                    f2_bulbs[f2Bulb] = objF2_bulbs;
//                }
//                industry2.setF2_bulbs(f2_bulbs);
//
//                ///// sound
//                Sound sound= new Sound();
//                JSONObject objSoundJson= objIndus2.getJSONObject(Const_Sound);
//                sound.setStatus(objSoundJson.getString(Const_Status));
//                sound.setValue(objSoundJson.getString(Const_Value));
//                industry2.setSound(sound);
//
//
//                industry.setIndustry2(industry2);
//
//                JSONObject objIndus3 = alSportyDetail.getJSONObject(2);
//                Windmill windmill = new Windmill();
//                JSONObject objwindmill= objIndus3.getJSONObject(Const_Windmill);
//                windmill.setStatus(objwindmill.getString(Const_Status));
//                windmill.setGenerated_power(objwindmill.getString(Const_Generated_power));
//                industry.setWindmill(windmill);



                alIndustry.add(industry);
                return alIndustry;



        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

