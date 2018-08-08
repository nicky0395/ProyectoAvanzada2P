package e.nicolejeem.prueba2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class Consulta extends AppCompatActivity {

    TextView tabla;
    ArrayList<Usuario> P=new ArrayList<Usuario>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        TableRow row = new TableRow(getBaseContext());
        TextView textView;


    }
    private class Read extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
        @Override
        protected void onPostExecute(String result) {
            String []objetos=result.split(" ");
            JSONArray ja;
            try {
                P.clear();
                for(int i=0;i<objetos.length-1;i++){
                    ja = new JSONArray(objetos[i]);
                    P.add(new Usuario((ja.getString(0)),Integer.parseInt(ja.getString(1))));
                }
               // Collections.sort(P);
                //tabla.setText();

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

   /* private String getTabla(){
        String tablar="\t\t\tNOMBRE\t\t\t\t\t\tEDAD\n";
        for(int i=0;i<P.size();i++){
            String pos=" ->"+P.get(i);
            if(P.get(i).getPosicion()==100){
                pos="DNF";
            }
            tablar+="\t\t\t"+pos+"\t\t\t\t\t\t\t\t"+getPiloto(P.get(i).getPil_id(),false)+"\n";
        }
        return tablar;
    }*/

    private String downloadUrl(String myurl) throws IOException {
        Log.i("URL",""+myurl);
        myurl = myurl.replace(" ","%20");
        InputStream is = null;
        // Only display the first 500 characters of the retrieved
        // web page content.
        int len = 500;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d("respuesta", "The response is: " + response);
            is = conn.getInputStream();

            // Convert the InputStream into a string
            String contentAsString = readIt(is, len);
            return contentAsString;

            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }
}
