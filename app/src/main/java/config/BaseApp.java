package config;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by kumardev on 2/8/2017.
 */

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

       // new PredictData().execute();


    }

    private class PredictData extends AsyncTask<String,String,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String url="https://ussouthcentral.services.azureml.net/workspaces/0670f5082d194aa0ac093baefe5b3719/services/09e729684ca84050a3a9c4baecaf45ff/execute?api-version=2.0&details=true";

            HttpURLConnection con=null;
            URL obj = null;

            try {
                obj = new URL(url);
                con = (HttpURLConnection) obj.openConnection();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                con.setRequestMethod("POST");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }


            String urlParameters ="";

            con.setDoOutput(true);
            DataOutputStream wr = null;
            try {
                wr = new DataOutputStream(con.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                wr.writeBytes(urlParameters);
                wr.flush();
                wr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int responseCode = 0;
            try {
                responseCode = con.getResponseCode();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.e("\nSending 'POST'URL: " ,":"+ url);
            Log.e("Post parameters : ", ":" + urlParameters);
            Log.e("Response Code : ", ":" + responseCode);

            BufferedReader in = null;
            StringBuffer response=null;
            try {
                in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //  Log.e("Response json",":"+response);

            String response_data=response.toString();
            //print result
            Log.e("Resp Res",":"+response.toString());

            return response_data;





        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}
