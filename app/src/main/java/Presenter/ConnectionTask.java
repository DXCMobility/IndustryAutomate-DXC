package Presenter;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v4.app.Fragment;

import org.json.JSONObject;

import java.util.ArrayList;

import Pojo.Industry;

/**
 * Created by pateniku on 2/7/2017.
 */

public class ConnectionTask extends AsyncTask<String, String, String> {

    private String resp;
    private String BASE_URL = "https://storesupervisor-836fa.firebaseio.com/industry.json";
    private Fragment cntx;
    private IClearedDB iClearedDB;
    public ArrayList<Industry> lstIndustry;
    public ConnectionTask(Fragment cntx, IClearedDB iClearedDB)
        {
            this.iClearedDB = iClearedDB;
            this.cntx = cntx;
        }
    @Override
    protected String doInBackground(String... params) {
        publishProgress("Sleeping..."); // Calls onProgressUpdate()
        try {
            // Do your long operations here and return the result
            resp = new HttpConnection().readUrl(BASE_URL);
            JSONObject jsonObj = new JSONObject(resp);
            JsonCall jsonCall = new JsonCall();
            lstIndustry = jsonCall.getAutoMacData(jsonObj);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    /*
     * (non-Javadoc)
     *
     * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
     */
    @Override
    protected void onPostExecute(String result) {
        // execution of result of Long time consuming operation
        System.out.println("IN post execute......");
        iClearedDB.AutomatedData(lstIndustry);



    }

    /*
     * (non-Javadoc)
     *
     * @see android.os.AsyncTask#onPreExecute()
     */

    /*
     * (non-Javadoc)
     *
     * @see android.os.AsyncTask#onProgressUpdate(Progress[])
     */
    @Override
    protected void onProgressUpdate(String... text) {
        // Things to be done while execution of long running operation is in
        // progress. For example updating ProgessDialog
    }
}